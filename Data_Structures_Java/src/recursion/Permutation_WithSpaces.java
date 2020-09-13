package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation_WithSpaces {

	public static void main(String[] args) {
		
		String str = "ABCD";
		
		List<String> result  = new ArrayList<>();
		String row = str.charAt(0)+"";
		 permutationWithSpaces(str,result,row,1);
		
		System.out.println(result);
	}

	private static void permutationWithSpaces(String str, List<String> result, String row, int index)
	{
		if(index >= str.length())
		{
			result.add(row);
			return;
		}
		String row1 = row+str.charAt(index);
		String row2= row+ " "+str.charAt(index);
		
		permutationWithSpaces(str, result, row1, index+1);
		permutationWithSpaces(str, result, row2, index+1);	
	}
	
	
}
