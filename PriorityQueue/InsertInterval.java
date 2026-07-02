import java.util.*;
public class InsertInterval{

    public static void main(String[] args) {
        int[][] interval = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] result = InsertInterval(interval,newInterval);

        System.out.println(Arrays.deepToString(result));   
    }

    private static int[][] InsertInterval(int[][] interval, int[] newInterval){
        List<int[]> result = new ArrayList<>();
        int n = interval.length;
        int i = 0;

        while(i < n && interval[i][1] < newInterval[0]){
            result.add(interval[i]);
            i++;
        }

        while(i <n && interval[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],interval[i][0]);
            newInterval[1] = Math.max(newInterval[1],interval[i][1]);
            i++;
        }

        result.add(newInterval);


        while(i < n){
            result.add(interval[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}