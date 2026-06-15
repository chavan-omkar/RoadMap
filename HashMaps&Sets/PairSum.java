import java.util.*;
public class PairSum{
    public static void main(String[] args) {
        int[] nums = {-1,3,4,2};
        int target = 3;
        
        System.out.println(Arrays.toString(findPair(nums,target)));
    }

    private static int[] findPair(int[] nums, int target){
        if(nums == null || nums.length <= 0){
            return new int[0];
        }

        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;

        for(int i = 0;i<n;i++){
           int curr = nums[i];

           int diff = target-curr;

           if(map.containsKey(diff)){
            return new int[]{map.get(diff), i};
           }
 map.put(nums[i],i);
            

        }

        return new int[0];

    }
}