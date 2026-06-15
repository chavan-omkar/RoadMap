import java.util.*;
public class ShiftZeros{

    public static void main(String[] args){
        int[] arr = {0,1,0,3,12};
        System.out.println(Arrays.toString(shiftZeros(arr)));
    }

    private static int[] shiftZeros(int[] arr){
        if(arr == null || arr.length <=0){
            return new int[0];
        }

        int n = arr.length;
        int l = 0;
        int r = 0;

        while(r < n){
            int num = arr[r];
            if(num != 0){
                if(l != r){
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                }
                l++;
            }
            r++;
           
        }
return arr;

    }
}