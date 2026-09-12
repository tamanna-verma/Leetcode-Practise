/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return helper(nums,0,len-1);
    }
    public TreeNode helper(int nums[] , int left, int right){
        if(left>right)return null;

        int middle = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = helper(nums,left,middle-1);
        root.right = helper(nums,middle+1,right);
        return root;
    }
}