package test1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class quickSort {
	public static int recursion(int[] nums, int left,int right) {
		int temp = nums[left];
		int i = left, j = right;
		
		while(i < j) {
			while(i < j && nums[j] >= temp) --j;
			if(i < j) nums[i] = nums[j];
			while(i < j && nums[i] <= temp) ++i;
			if(i < j) nums[j] = nums[i];
		}
		nums[i] = temp;
		
		return i;
//		recursion(nums, left, i-1);
//		recursion(nums, i+1, right);
	}
	
	
	public static void nonRecursion(int[] nums, int left,int right) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(left);
		s.push(right);
		
		while(!s.empty()) {
			int j = s.pop();
			int i = s.pop();
			if(i >= j) continue;
			int index = recursion(nums, i, j);
			s.push(i);
			s.push(index - 1);
			s.push(index + 1);
			s.push(j);
			
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {20,3,5,0,32,22,11,8,7,9};
		System.out.println(Arrays.toString(nums));
		nonRecursion(nums,0,nums.length - 1);
		System.out.println(Arrays.toString(nums));
	} 
}
