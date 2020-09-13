package packageB;
import packageA.A1;
public class B1 extends A1{
	A1 a1;
	public B1() {
		a1 = new A1();
	}
	public static void main(String[] args) {
		B1 b1 = new B1();
		System.out.println(b1.protectedA);
	}
	
}
