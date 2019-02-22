package Strings;

public class ReversedWords {

	public static void main(String[] args) {
		System.out.println(reverseWords("the  sky  is blue  "));
	}
	
	
	
    public static String reverseWords(String s) {
       
    	StringBuilder sb = new StringBuilder();
    	
    	String[] temp = s.split(" ");
    	for(int i=1;i<=temp.length;i++) {
    		
    		if(temp[temp.length-i]=="") {
    			continue;
    		}
    		sb.append(temp[temp.length-i]);
    		sb.append(" ");	
    	}
    	
    	return sb.toString().trim();
    }
    
}
