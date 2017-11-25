package q3;

public class LazyObject implements MyObject {

	private TimeConsumingObject timeConsumingObject;
	
	@Override
	public void foo() {
		if (timeConsumingObject == null) {
			timeConsumingObject = new TimeConsumingObject();
		}
		
		System.out.println("foo");
	}

	@Override
	public void bar() {
		if (timeConsumingObject == null) {
			timeConsumingObject = new TimeConsumingObject();
		}
		
		System.out.println("bar");
	}
}
