package packageA;
import packageA.A1;
public class B1{
	A1 a1;
	public B1() {
		a1 = new A1();
	}
	public static void main(String[] args) {
		
		System.out.println(a1.protectedA);
	}
	
}
