import java.util.HashSet;
import java.util.Set;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(compareVersion("0.1","1.1"));

	}

	public static int compareVersion(String version1, String version2) {
	     
		String[] ver1 = version1.split("\\.");
        
        String[] ver2 = version2.split("\\.");
        
        int i=0;
        int j=0;
        
        // remove leading 0
        
        while(i<ver1.length && ver1[i].equals("0"))
        {
            i++;
        }
         while(j<ver2.length && ver2[j].equals("0"))
        {
            j++;
        }
        
        while(i < ver1.length && j < ver2.length ){
           
            int a = Integer.parseInt(ver1[i]);
            int b = Integer.parseInt(ver2[j]);
            
            if(a > b)
                return 1;
            else if(a<b)
                return -1;               
            else{
                  i++;
                  j++;  
            }
          
        }
        if(i< ver1.length)
            return 1;
        else if(j < ver2.length)
            return -1;
        else 
            return 0;
       
    }
}
