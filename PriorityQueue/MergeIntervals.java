import java.util.*;

public class MergeIntervals{

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = findMergedIntervals(intervals);

        System.out.println(Arrays.deepToString(result));
        
    }

    private static int[][] findMergedIntervals(int[][] intervals){
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));

        for(int[] arr : intervals){
            if(result.isEmpty() || result.get(result.size()-1)[1] < arr[0]){
                result.add(new int[]{arr[0],arr[1]});
            }else{
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1],arr[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}