import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{

    public static void main(String[] args) {
        int[] nums = {0, -1, 2, -3, 1};
        Arrays.sort(nums);
        // List<List<Integer>> result = findTripletSum(nums);
        // System.out.println(result.toString());

        List<List<Integer>> result = findTripletSumToZero(nums);
        System.out.println(result.toString());
    }

    private static List<List<Integer>> findTripletSumToZero(int[]nums){
        if(nums == null || nums.length <=0){
            return new ArrayList<>();
        }

        int n = nums.length;
        // int l1 = 0;
        // int l2 = 1;
        // int r = n-1;

        // Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0;i<n-2;i++){
            
                // int target = nums[i] * -1;

                int l = i+1;
                int r = n-1;

                if(i > 0 && nums[i] == nums[i-1]){
                    continue;
                }

                if(nums[i] > 0){
                    break;
                }

                while(l < r){
                    int sum = nums[i]+nums[l] + nums[r];
                    if(sum == 0){
                        
                        result.add(Arrays.asList(nums[i],nums[l],nums[r]));

                        while(l < r && nums[l] == nums[l+1]){
                            l++;                            
                        }

                        while(l < r && nums[r] == nums[r-1]){
                            r--;
                        }

                        l++;
                        r--;
                    }else if(sum < 0){
                        l++;
                    }else{
                        r--;
                    }

                }
        }
        return result;
    }
















    private static List<List<Integer>> findTripletSum(int[] nums){

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
   

        for(int i =0;i<n;i++){
            int l = i+1;
            int r = n-1;

            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(l < r){
            int sum = nums[i] + nums[l] + nums[r];

            if(sum == 0){
                result.add(Arrays.asList(nums[i],nums[l],nums[r]));

                while(l < r && nums[l] == nums[l+1]){
                    l++;
                }

                while(r > l && nums[r] == nums[r-1]){
                    r--;
                }

                l++;
                r--;
                 
            }
            if(sum < 0){
                l++;
            }else if(sum > 0){
                r--;
            }
           
            
            }

           
        }
        return result;
    }
    
}