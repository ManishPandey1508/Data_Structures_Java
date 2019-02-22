
public class PairShoesEAMEX_Rafi {

	public static void main(String[] args) {
		
		String s0 ="RLRRLLRLRRLL";
		String s1 ="RLLLRRRLLR";
		String s2 ="LLRLRLRLRLRLRR";
		
		System.out.println("Answer "+ pairs(s0));
		System.out.println("Answer "+ pairs(s1));
		System.out.println("Answer "+ pairs(s2));
		
		System.out.println(power(0,1));
		System.out.println(power(1,100));
		System.out.println(power(1,1000));
		
		
		
	}

	public static int pairs(String s) {
		
		int result =0;
		int temp=0;
		if(s==null || s.length()==0)
			return result;
		
		for(int i=0;i< s.length();i++) {
			
			char c = s.charAt(i);
			if(c=='L') {
				temp= temp-1;
			}
			else if(c=='R')
				temp=temp+1;
			
			if(temp==0) {
				result++;
			}
			
			
		}
		
		return result;
	}
	
	 public static int power(int A, int B) {
	        int count=0;       
	        int num =0;
	        int power= 0;
	        
	        if(B<=0)
	        	return 0;
	        
	        
	        while(num<=B && power <= B)
	        {
	        	power = num * num;
	        	
	        	if(power >= A && power <= B)
	        		count++;
	        	num++;
	        	
	        }
	        
	        return count;
	    }
	
	
}
