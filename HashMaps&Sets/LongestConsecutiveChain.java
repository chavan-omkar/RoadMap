import java.util.*;

public class LongestConsecutiveChain{

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5, 8, 7, 10, 3};

        System.out.println(longestConsecutiveNoChain(arr));
    }

    private static int longestConsecutiveNoChain(int[] arr){
        if(arr == null || arr.length == 0) return 0;

        int longestChain = 0;

        HashSet<Integer> set = new HashSet<>();

        for(int num : arr){
            set.add(num);
        }

        for(int num : arr){
 
            if(!set.contains(num-1)){
            int currentChain = 1;
            int currentNum = num;

            while(set.contains(currentNum+1)){
                currentNum = currentNum+1;
                currentChain +=1;
            }
            longestChain = Math.max(longestChain, currentChain);
        }
            }
           

            

        return longestChain;
    }
}