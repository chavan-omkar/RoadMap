import java.util.*;
public class Sudoku{

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                 ,{'6','.','.','1','9','5','.','.','.'}
                                 ,{'.','9','8','.','.','.','.','6','.'}
                                 ,{'8','.','.','.','6','.','.','.','3'}
                                 ,{'4','.','.','8','.','3','.','.','1'}
                                 ,{'7','.','.','.','2','.','.','.','6'} 
                                 ,{'.','6','.','.','.','.','2','8','.'}
                                 ,{'.','.','.','4','1','9','.','.','5'}
                                 ,{'.','.','.','.','8','.','.','7','9'}};

            System.out.println("The given sudoku is valid : " + checkSudoku(board));
        
    }

    private static boolean checkSudoku(char[][] board){
        ArrayList<HashSet<Character>> rows = new ArrayList<>();
        ArrayList<HashSet<Character>> cols = new ArrayList<>();
        HashSet<Character>[][] subGrid = new HashSet[3][3];

        int row = board.length;
        int col = board[0].length;

        for(int i =0;i<row;i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                subGrid[i][j] = new HashSet<>();
            }
        }

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                char c = board[i][j];

                if(c == '.'){
                    continue;
                }

                if(rows.get(i).contains(c)){
                    return false;
                }

                if(cols.get(j).contains(c)){
                    return false;
                }

                if(subGrid[i/3][j/3].contains(c)){
                    return false;
                }

                rows.get(i).add(c);
                cols.get(j).add(c);
                subGrid[i/3][j/3].add(c);


            }

            
        }

        return true;
    }
}