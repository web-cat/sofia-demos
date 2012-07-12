package sofia.demos;

import sofia.app.*;
import sofia.graphics.*;

// -------------------------------------------------------------------------
/**
 * The archetypal "Hello World" program.
 *
 * @author  Tony Allevato
 * @version 2011.12.08
 */
public class HelloWorldDemo extends ShapeScreen
{
    // ----------------------------------------------------------
    /**
     * Initializes the contents of the screen.
     */
    public void initialize()
    {
        add(new TextShape("Hello world"));
    }
}
