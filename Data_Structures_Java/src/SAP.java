import java.util.Scanner;

public class SAP {

	public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			String output = scan.nextLine();
			//System.out.println(output);
			int n = Integer.parseInt(output);
			if(n==1 || n==0)
				System.out.println(n);
		
			for(int i=0;i<n+1;i++) {
				StringBuffer sb = new StringBuffer();
				for(int j=0;j<n;j++)
				{	
					if(i!=0 && j==n-2) {
						sb.append(i);
					}
					else {
						sb.append(n);
					}
				}
				System.out.println(sb.toString());
				
			}
				
			
		}
	

	}
