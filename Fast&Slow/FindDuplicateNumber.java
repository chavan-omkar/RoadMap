public class FindDuplicateNumber{

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println("Duplicate No is : " + findDuplicateNo(nums));
    }

    private static int findDuplicateNo(int[] nums){
        int slow= 0;
        int fast = 0;

        do{
            slow = nums[slow];       //1 //3  // 2 //4
            fast = nums[nums[fast]]; //3 //2  // 4 // 2
        }while(slow != fast);

        slow = 0;
        while(slow != fast){

            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}