import java.util.ArrayList;
import java.util.List;

public class Veritas_Bhumi {
	
	public static void main(String[] args) {
		
		
		
		
		List<String> list = new ArrayList<>();
	list.add("00L");
		list.add("22L");
		list.add("02R");
		
		
		System.out.println(rollingString("bcd", list));
	}
	
	
	
	
	public static String rollingString(String s, List<String> operations) {
		    // Write your code here
		        String temp=s;

		        int length = s.length();

		        for(String str : operations)
		        {

		            int leftIndex = Integer.parseInt(str.charAt(0)+"");
		            int rightIndex = Integer.parseInt(str.charAt(1)+"");
		            StringBuilder sb = new StringBuilder();
		            sb.append(temp.substring(0,leftIndex));
		            char op = str.charAt(2);
		            if(op=='L'){
		                int i=leftIndex;
		                while(i<=rightIndex){
		                    sb.append(Character.toString((char) (((str.charAt(i) - 'a' - 1) % 26) + 97)));
		                    i++;
		                }
		            }
		            else{
		                int i=leftIndex;
		                while(i<=rightIndex){
		                    sb.append(Character.toString((char) (((str.charAt(i) - 'a' + 1) % 26) + 97)));
		                    i++;
		                }
		            }

		             sb.append(temp.substring(rightIndex+1,length));
		             temp = sb.toString();

		        }


		        return temp;

		    }
}
