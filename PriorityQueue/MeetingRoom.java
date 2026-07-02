import java.util.*;
public class MeetingRoom{

    public static void main(String[] arhs){
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        int noOfRooms  = findRoomCount(intervals);
        
        System.out.println("No of Rooms Needed for all this meeting is :- "+ noOfRooms);
        System.out.println("No of Rooms Needed for all this meeting is :- "+ findCount(intervals));
    }

    private static int findCount(int[][] intervals){
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        

        for(int i = 0; i < n;i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
         Arrays.sort(ends);

         int startPtr = 0;
         int endPtr = 0;
         int rooms = 0;

         while(startPtr < n){
            if(starts[startPtr] < ends[endPtr]){
                rooms++;

            }else{
                endPtr++;
            }

            startPtr++;
         }

         return rooms;
    }

    private static int findRoomCount(int[][] intervals){
        if(intervals == null && intervals.length <= 0) return 0;

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> mq = new PriorityQueue<>();
        int roomCount = 1;
        int n = intervals.length;

        mq.add(intervals[0][1]);

        for(int i =1;i<n;i++){

            if(intervals[i][0] >= mq.peek()){
                mq.poll();
            }

            mq.add(intervals[i][1]);

           
        }

        return mq.size();
    }
}