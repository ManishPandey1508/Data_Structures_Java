package Array_Leetcode;

/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5*/

/*This problem can be converted to the problem of finding kth element, k is (A's length + B' Length)/2.

If any of the two arrays is empty, then the kth element is the non-empty array's kth element. If k == 0, the kth element is the first element of A or B.

For normal cases(all other cases), we need to move the pointer at the pace of half of the array size to get log(n) time.
*/

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {

			return (findKthELement(total / 2, nums1, nums2, 0, 0) + findKthELement(total/ 2 + 1, nums1, nums2, 0, 0))
					/ 2.0;
		} else {
			return findKthELement(total / 2 + 1, nums1, nums2, 0, 0);
		}

	}

	private long findKthELement(int k, int[] nums1, int[] nums2, int s1, int s2) {

		// Handle Border cases
		if (s1 >= nums1.length) {
			return nums2[k + s2 - 1];
		}
		if (s2 >= nums2.length) {
			return nums1[k + s1 - 1];
		}
		if (k == 1)
			return Math.min(nums1[s1], nums2[s2]);

		int m1 = s1 + k / 2 - 1;
		int m2 = s2 + k / 2 - 1;

		int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

		if (mid1 < mid2) {
			return findKthELement(k - k / 2, nums1, nums2, m1+1, s2);
		} else {
			return findKthELement(k - k / 2, nums1, nums2, s1, m2+1);
		}

	
	}

}
