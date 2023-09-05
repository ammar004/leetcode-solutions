/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

*/


---------------------------------------------------------------------------
---------------------------------------------------------------------------


  //solution

  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int n=n1+n2;
        int [] newarr=new int[n1+n2];

        int i=0,j=0,k=0;

        while(i<n1 && j<n2)
        {
            if(nums1[i]<nums2[j])
                newarr[k++]=nums1[i++];
            else
                newarr[k++]=nums2[j++];

        }
            if(i==n1)
            {
                while(j<n2)
                    newarr[k++]=nums2[j++];
            }
            else if(j==n2)
            {
                while(i<n1)
                    newarr[k++]=nums1[i++];
            }

        if(n%2==0)
            return (float)(newarr[n/2]+newarr[n/2-1])/2;
        else 
            return newarr[n/2];
    }
}
