import java.util.*;

public class ZeroStriping{

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        setMatrixToZero(grid);
        System.out.print(Arrays.deepToString(grid));
    }

    private static void setMatrixToZero(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        boolean isFirstRowZero = false;
        boolean isFirstColZer = false;

        for(int i =0;i<col;i++){
            if(grid[0][i] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        for(int i =0;i<row;i++ ){
            if(grid[i][0] == 0){
                isFirstColZer = true;
                break;
            }
        }

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(grid[i][j] == 0){
                    grid[0][j] = 0;
                    grid[i][0] = 0;
                }
            }
        }

        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                if(grid[i][0] == 0 || grid[0][j] == 0){
                    grid[i][j] = 0;
                }
            }
        }

        if(isFirstColZer){
            for(int i =0;i<row;i++){
                grid[i][0] = 0;
            }
        }

        if(isFirstRowZero){
            for(int i =0;i<col;i++){
                grid[0][i] = 0;
            }
        }

    }

}