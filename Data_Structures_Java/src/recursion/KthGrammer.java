package recursion;

public class KthGrammer {
	   
	
	public static void main(String[] args) {
			String s = KthUtil(1);   
	        System.out.println(s.charAt(0)); 
	}
	
	
    public static String KthUtil(int N){
        
        if(N==1)
            return "0";
        
        String prev = KthUtil(N-1);
        StringBuilder sb = new StringBuilder();
        
        for(char c:prev.toCharArray()){
            if(c=='0')
                sb.append("01");
            else
                sb.append("10");
        }
        
        return sb.toString();
        
    }
}
