
package GrokkingDPProblems.PalindromicSubsequence;

public class StringInterLeaving {

	public static void main(String[] args) {
		
		String m = "abd";
		String n= "cef";
		String p = "abcdef";
		System.out.println(" Result "+ isStringInterleaved(m, n, p, 0, 0, 0));
		
		
	}

	public static boolean isStringInterleaved(String m, String n, String p, int i1, int i2, int i3) {
		if (i1 == m.length() && i2 == n.length() && i3 == p.length())
			return true;

		if (i3 == p.length())
			return false;

		boolean b1 = false, b2 = false;

		if (i1 < m.length() && m.charAt(i1) == p.charAt(i3))
			b1 = isStringInterleaved(m, n, p, i1 + 1, i2, i3 + 1);

		if (i2 < n.length() && n.charAt(i2) == p.charAt(i3))
			b2 = isStringInterleaved(m, n, p, i1, i2 + 1, i3 + 1);

		return b1 || b2;

	}

}
