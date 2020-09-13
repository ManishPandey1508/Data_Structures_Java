package Array_Leetcode;

class BackSpaceString {

	public static void main(String[] args) {
		
		System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));

	}

	public static boolean backspaceCompare(String S, String T) {
		int i1 = S.length() - 1;
		int i2 = T.length() - 1;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		while (i1 >= 0) {
			int hash1 = 0;

			while (i1 >= 0 && S.charAt(i1) == '#') {
				hash1++;
				i1--;
			}

			i1 = i1 - hash1;
			if(i1>=0)
			sb1.append(S.charAt(i1));
			i1--;
		}

		while (i2 >= 0) {
			int hash2 = 0;

			while (i2 >= 0 && T.charAt(i2) == '#') {
				hash2++;
				i2--;
			}

			i2 = i2 - hash2;
			if(i2>=0)
			sb2.append(T.charAt(i2));
			i2--;
		}

		if(sb1.toString().equals(sb2.toString()))
			return true;
		
		return false;
		
		
	}
}