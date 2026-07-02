import java.util.*;
public class SubArraySum{

    public static void main(String[] args){
        int[] nums = {1,2,3};
        int  k = 3;

        System.out.println(calculateSubArrays(nums,k));
    }

    private static int calculateSubArrays(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;

        map.put(0,1);
        int sum = 0;

        for(int i =0;i<nums.length;i++){

            sum += nums[i];

            int rem = sum - k;

            if(map.containsKey(rem)){
                maxLen += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum,0)+1);

        }
        return maxLen;
    }
}