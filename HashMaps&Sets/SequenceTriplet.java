import java.util.*;
public class SequenceTriplet{

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 2, 4, 8, 8));
        int r = 2;

        System.out.println(findTriplets(arr,r));
        
    }

    private static int findTriplets(ArrayList<Integer>arr, int r){
        if (arr ==null || arr.isEmpty()){
            return 0;
        }

        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer>right = new HashMap<>();
        int count = 0;

        for(int n : arr){
            right.put(n,right.getOrDefault(n,0)+1);
        }

        for(int num : arr){

            int n = num;

            right.put(n,right.getOrDefault(n, 0)-1);

            if(n % r == 0){
                count += left.getOrDefault(n/r, 0) * right.getOrDefault(n*r, 0);
            }

            left.put(n,left.getOrDefault(n,0)+1);
        }

        return count;

    }
}