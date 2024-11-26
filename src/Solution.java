import java.util.*;

// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;

        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {
            // 현재까지의 최대 높이 갱신
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            // 더 낮은 벽 쪽에서 물 높이 계산
            if (leftMax < rightMax) {
                water += leftMax - height[left];
                left++;
            } else {
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}
