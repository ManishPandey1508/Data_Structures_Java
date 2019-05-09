package oops;

public class Action {

	public static void main(String[] args) {
		
		A a = new A();
		
		
		B b = new B();
		
		
		
		A a1 = new B();
		
		a.method();
		b.method();
		a1.method();
		
		System.out.println(a.value);
		
		System.out.println(b.value);
		
		System.out.println(a1.value);
		
		System.out.println(b.value1);
		
	}

}
