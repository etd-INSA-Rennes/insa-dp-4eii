package q3;

public class Main {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		
		MyObject obj = new TimeConsumingObject();
		
		System.out.println("The creation of the MyObject took: " + (System.currentTimeMillis() - time) + " ms.");
		
		time = System.currentTimeMillis();
		obj.foo();
		System.out.println("Calling foo() took: " + (System.currentTimeMillis() - time) + " ms.");
		time = System.currentTimeMillis();
		obj.bar();
		System.out.println("Calling bar() took: " + (System.currentTimeMillis() - time) + " ms.");
		
		System.out.println("With lazy initialization:");
		
		time = System.currentTimeMillis();
		
		obj = new LazyObject();
		
		System.out.println("The creation of the MyObject took: " + (System.currentTimeMillis() - time) + " ms.");
		
		time = System.currentTimeMillis();
		obj.foo();
		System.out.println("Calling foo() took: " + (System.currentTimeMillis() - time) + " ms.");
		time = System.currentTimeMillis();
		obj.bar();
		System.out.println("Calling bar() took: " + (System.currentTimeMillis() - time) + " ms.");
	}

}
