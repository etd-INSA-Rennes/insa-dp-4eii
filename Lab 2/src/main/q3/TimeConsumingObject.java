package q3;

/**
 * An object that takes a lot of time to be created.
 */
public class TimeConsumingObject implements MyObject {
	public TimeConsumingObject() {
		super();
		
		try {
			// Faking the time-consuming creation of the object.
			Thread.sleep(5000);
		} catch(final InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void foo() {
		System.out.println("foo");
	}

	@Override
	public void bar() {
		System.out.println("bar");
	}
}
