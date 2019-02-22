package Strings;

import java.util.HashMap;
import java.util.Map;

public class MultiplyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(multiplyString("123","456"));
	}

	public static String multiplyString(String num1,String num2) {

        Map<Character,Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
      
     /*   int n1=0;
        
        for(int i=0;i< num1.length(); i++)    	
        {
            n1 = n1*10+map.get(num1.charAt(i));
            System.out.println("i  " +i +" num1.charAt(i) " + num1.charAt(i) + " n1 "+ n1);
        }
         System.out.println(n1 );
         int n2=0;
         for(int i=0;i< num2.length(); i++)   
        {
            n2 = n2*10+map.get(num2.charAt(i));
            
              System.out.println("i  " +i +" num2.charAt(i) " + num2.charAt(i) + " n1 "+ n2);
            
        }
         System.out.println(n2);
        return n1* n2 +"";*/
     
        int n1=0;
          
        for(int i=num1.length()-1; i>=0;i--) {
        	
        	 n1 = (n1+map.get(num1.charAt(i)) * (int) Math.pow(10,num1.length()-(i+1))) ;
             System.out.println("i  " +i +" num1.charAt(i) " + num1.charAt(i) + " n1 "+ n1);
        }
        int n2=0;
        
        for(int i=num2.length()-1; i>=0;i--) {
        	
       	 n2 = n2+map.get(num2.charAt(i))*(int) Math.pow(10,num2.length()-(i+1)) ;
            System.out.println("i  " +i +" num2.charAt(i) " + num2.charAt(num2.length()-(i+1)) + " n1 "+ n2);
       }
       
        return n1*n2 +"";
       
	}
	
	
	
	
	
	
}
