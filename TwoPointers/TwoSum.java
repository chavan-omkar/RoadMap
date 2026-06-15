import java.util.Arrays;
public class TwoSum{

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int k = 9;

        // System.out.println(Arrays.toString(findSumIndexes(numbers,k)));
        System.out.println(Arrays.toString(sumsIndices(numbers,k)));
        
    }

    private static int[] sumsIndices(int[] arr, int target){
        if(arr == null || arr.length <=0){
            return new int[0];
        }

        int n = arr.length;
        int l = 0;
        int r=n-1;
        int sum = 0;

        while(l < r){
            sum = arr[l] + arr[r];

            if(sum < target){
                l++;
               
            }else if( sum > target){
                r--;
            }else if(sum == target){
                return new int[]{l,r};
            }
        }

        return new int[0];
    }












    private static int[] findSumIndexes(int[]numbers, int k){
        int n = numbers.length;
        int l = 0;
        int r = n-1;
        int[] res = new int[2];

        while(l < r){
            int sum = numbers[l] + numbers[r];

            if(sum == k){
                res[0] = l+1;
                res[1] = r+1;
                return res;
            }

            if(sum < k){
                l++;
            }else{
                r--;
            }
        }

        return new int[]{-1,-1};

    }
}