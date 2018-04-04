package DynamicProgramming;

public class IsSubsequence {

	public static void main(String[] args) {

		String s = "abp";
		String t = "avvfjvbeefcknknlkz";
		boolean res = isSubsequence(s, t);
		System.out.println("Result   " + res);

	}

	static boolean isSubsequence(String s, String t) {

		if (t == null || t.length() == 0) {
			return false;
		}

		if (s == null || s.length() == 0) {
			return true;
		}

		int i = 0;
		int j = 0;
		while (i < t.length()) {

			if (j >= s.length())
				return true;
			if (t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			}
			i++;
		}

		return false;
	}

	// For Follow Up 
	
	// We can use Array of List of 256 character.. And store indexes of each character
	// Now traverse 
	
	
	static boolean isSubsequenceFollowUp(String s, String t) {
	
		
		
		
		
		
		return false;
	}
	
}
