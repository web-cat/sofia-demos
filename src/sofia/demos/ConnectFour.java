package sofia.demos;

import static sofia.graphics.Anchor.*;
import sofia.app.*;
import sofia.graphics.*;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.*;
import android.widget.*;

// -------------------------------------------------------------------------
/**
 * An implementation of the Connect Four board game. The pieces bounce when
 * they land in the slots!
 *
 * @author  Tony Allevato
 * @version 2011.12.13
 */
public class ConnectFour extends ShapeScreen
{
    //~ Instance/static variables .............................................

    private enum Cell
    {
        EMPTY,
        PLAYER1,
        PLAYER2
    }

    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final int X_MARGIN = 20;
    private static final int PADDING = 2;
    private static final int NO_FREE_SLOT = -1;

    private static final Color PLAYER1_COLOR = Color.red;
    private static final Color PLAYER2_COLOR = Color.blue;

    private TextView statusLabel;

    private RectangleShape[] columns;
    private float cellSize;
    private Cell[][] board;
    private boolean player2Turn;
    private boolean gameOver;
    private int slotsFilled = 0;


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    public void initialize()
    {
        board = new Cell[ROWS][COLS];
    }


    // ----------------------------------------------------------
    @Override
    protected void afterInitialize()
    {
        cellSize = getWidth() / COLS;

        columns = new RectangleShape[COLS];

        for (int c = 0; c < COLS; c++)
        {
            RectF bounds = new RectF(
                cellSize * c,
                0,
                cellSize * (c + 1),
                cellSize * ROWS);
            columns[c] = new RectangleShape(bounds);
            columns[c].setColor(Color.gray);
            add(columns[c]);

            for (int r = 0; r < ROWS; r++)
            {
                board[r][c] = Cell.EMPTY;
            }
        }

        statusLabel.setText("Player 1's turn");
        statusLabel.setTextColor(PLAYER1_COLOR.toRawColor());
    }


    // ----------------------------------------------------------
    /**
     * Called when a finger is lifted up from the screen.
     *
     * @param e an object that describes the event
     */
    public void onTouchUp(MotionEvent e)
    {
        if (gameOver)
        {
            return;
        }

        float x = e.getX() - X_MARGIN;
        int col = (int) (x / cellSize);

        int freeSlot = getLowestFreeSlot(col);
        if (freeSlot == NO_FREE_SLOT)
        {
            return;
        }

        slotsFilled++;

        OvalShape piece = new OvalShape(
            BOTTOM.anchoredAt(TOP.of(columns[col]).shiftBy(PADDING, PADDING))
                .sized(cellSize - 2 * PADDING, cellSize - 2 * PADDING));
        piece.setFilled(true);

        if (player2Turn)
        {
            piece.setColor(PLAYER2_COLOR);

            board[freeSlot][col] = Cell.PLAYER2;
            if (checkForWin(Cell.PLAYER2))
            {
                statusLabel.setText("Player 2 wins!");
                statusLabel.setTextColor(PLAYER2_COLOR.toRawColor());
                gameOver = true;
            }
            player2Turn = false;
        }
        else
        {
            piece.setColor(PLAYER1_COLOR);

            board[freeSlot][col] = Cell.PLAYER1;
            if (checkForWin(Cell.PLAYER1))
            {
                statusLabel.setText("Player 1 wins!");
                statusLabel.setTextColor(PLAYER1_COLOR.toRawColor());
                gameOver = true;
            }
            player2Turn = true;
        }

        add(piece);

        PointF position = new PointF(col * cellSize + PADDING,
            freeSlot * cellSize + PADDING);
        piece.animate(750).timing(Timings.bounce()).position(position).play();

        if (!gameOver)
        {
            if (slotsFilled == ROWS * COLS)
            {
                statusLabel.setText("Draw");
                statusLabel.setTextColor(Color.white.toRawColor());
                gameOver = true;
            }
            else if (player2Turn)
            {
                statusLabel.setText("Player 2's turn");
                statusLabel.setTextColor(PLAYER2_COLOR.toRawColor());
            }
            else
            {
                statusLabel.setText("Player 1's turn");
                statusLabel.setTextColor(PLAYER1_COLOR.toRawColor());
            }
        }
    }


    // ----------------------------------------------------------
    private int getLowestFreeSlot(int column)
    {
        for (int r = ROWS - 1; r >= 0; r--)
        {
            if (board[r][column] == Cell.EMPTY)
            {
                return r;
            }
        }

        return NO_FREE_SLOT;
    }


    // ----------------------------------------------------------
    private boolean checkCell(int row, int column, Cell cell)
    {
        if (row < 0 || row >= ROWS || column < 0 || column >= COLS)
        {
            return false;
        }
        else
        {
            return cell == board[row][column];
        }
    }


    // ----------------------------------------------------------
    private boolean checkForWin(Cell cell)
    {
        for (int r = 0; r < ROWS; r++)
        {
            for (int c = 0; c < COLS; c++)
            {
                // Check for vertical win.
                if (checkCell(r, c, cell)
                    && checkCell(r + 1, c, cell)
                    && checkCell(r + 2, c, cell)
                    && checkCell(r + 3, c, cell))
                {
                    return true;
                }

                // Check for horizontal win.
                if (checkCell(r, c, cell)
                    && checkCell(r, c + 1, cell)
                    && checkCell(r, c + 2, cell)
                    && checkCell(r, c + 3, cell))
                {
                    return true;
                }

                // Check for rightward diagonal win.
                if (checkCell(r, c, cell)
                    && checkCell(r + 1, c + 1, cell)
                    && checkCell(r + 2, c + 2, cell)
                    && checkCell(r + 3, c + 3, cell))
                {
                    return true;
                }

                // Check for leftward diagonal win.
                if (checkCell(r + 3, c, cell)
                    && checkCell(r + 2, c + 1, cell)
                    && checkCell(r + 1, c + 2, cell)
                    && checkCell(r, c + 3, cell))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
