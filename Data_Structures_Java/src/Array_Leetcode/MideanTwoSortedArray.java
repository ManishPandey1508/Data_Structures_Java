package Array_Leetcode;

public class MideanTwoSortedArray {

	public static void main(String[] args) {
		int[] x = { 1, 3, 8, 9, 15 };
		int[] y = { 7, 11, 19, 21, 18, 25,30 };

		MideanTwoSortedArray mm = new MideanTwoSortedArray();
		System.out.println(mm.findMedianSortedArrays(x, y));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		// just making first array as smaller array
		if (nums1.length > nums2.length)
			return findMedianSortedArrays(nums2, nums1);

		int x = nums1.length;
		int y = nums2.length;

		int low = 0;
		int high = x;

		while (low <= high) {

			// Find Partitions for X and Y
			int partitionX = low + high / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			// find max left,right x

			int max_leftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
			int min_rightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

			int max_leftY = (partitionY == 0) ? Integer.MIN_VALUE : nums1[partitionY - 1];
			int min_rightY = (partitionY == y) ? Integer.MAX_VALUE : nums1[partitionY];

			// check if we found an exact partition
			if (max_leftX <= min_rightY && max_leftY <= min_rightY) {
				// inside this means exact partition has been found

				if ((x + y) % 2 == 0) {
					return (double) (Math.max(max_leftX, max_leftY) + Math.max(min_rightX, min_rightY)) / 2;
				} else {
					return (double) Math.max(max_leftX, max_leftY);
				}

			} else if (max_leftX > min_rightY) {

				high = partitionX - 1;

			} else {

				low = partitionX - 1;
			}

		}

		throw new IllegalArgumentException();

	}

}
