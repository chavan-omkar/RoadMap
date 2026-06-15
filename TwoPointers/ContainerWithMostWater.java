public class ContainerWithMostWater{

    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7};
        // System.out.println(findMaxWater(height));
        System.out.println(largestContainer(height));
    }


    private static int largestContainer(int[] heights){
        if(heights == null || heights.length <2){
            return 0;
        }

        int n = heights.length;
        int l = 0;
        int r = n-1;

        int maxWater = Integer.MIN_VALUE;

        while(l < r){
            int minHeight = Math.min(heights[l],heights[r]);
            int width = r-l;

            maxWater = Math.max(minHeight*width,maxWater);

            if(heights[l] < heights[r]){
                l++;
            }else if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
                r--;
            }

        }

        return  maxWater;
    }












    private static int findMaxWater(int[] heights){

        if(heights == null || heights.length < 2) return 0;
        int l = 0;
        int r = heights.length-1;
        int maxWater = 0;

        while(l < r){
            int minHeight = Math.min(heights[l],heights[r]);
            int width = r - l;
            int currentWater = minHeight * width;

            maxWater = Math.max(maxWater,currentWater);

            if(heights[l] <  heights[r]){
                l++;
            }else{r--;}
        }

        return maxWater;
    }
}