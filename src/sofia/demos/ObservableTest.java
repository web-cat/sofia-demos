package sofia.demos;

import sofia.util.Observable;
import junit.framework.TestCase;

public class ObservableTest extends TestCase
{
	private MockObservable observable;
	private MockObservable2 observable2;
	private boolean changeWasObservedCalled;
	private boolean changeWasObserved2Called;

	protected void setUp()
	{
		observable = new MockObservable();
		observable2 = new MockObservable2();
		changeWasObservedCalled = false;
		changeWasObserved2Called = false;

		observable.addObserver(this);
		observable2.addObserver(this);
	}
	
	
	public void test1()
	{
		observable.setFoo(1);

		assertEquals(1, observable.getFoo());
		assertTrue(changeWasObservedCalled);
		assertFalse(changeWasObserved2Called);
	}
	
	
	public void test2()
	{
		observable2.setBar(2);

		assertEquals(2, observable2.getBar());
		assertFalse(changeWasObservedCalled);
		assertTrue(changeWasObserved2Called);
	}
	
	
	public void changeWasObserved(MockObservable object)
	{
		changeWasObservedCalled = true;
	}


	public void changeWasObserved(MockObservable2 object)
	{
		changeWasObserved2Called = true;
	}


	private class MockObservable extends Observable
	{
		private int foo = 0;
		
		public int getFoo()
		{
			return foo;
		}

		public void setFoo(int newFoo)
		{
			this.foo = newFoo;
			notifyObservers();
		}
	}


	private class MockObservable2 extends Observable
	{
		private int bar = 0;
		
		public int getBar()
		{
			return bar;
		}

		public void setBar(int newBar)
		{
			this.bar = newBar;
			notifyObservers();
		}
	}
}
