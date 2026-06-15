
public class LexicographicalNext{

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(findNextGreater(s));
    }

    private static String findNextGreater(String s){
        if(s == null || s.length() <=0){
            return "";
        }

        char[] letters = s.toCharArray();
        int pivot = letters.length -2;
        int n = letters.length;

        while(pivot >=0 && letters[pivot] >= letters[pivot+1]){
            pivot --; 
        }

        if(pivot == -1){
            reverse(letters,0,n-1);
            return new String(letters);
        }

        int rightSuccesser = n-1;

        while(letters[rightSuccesser] <= letters[pivot]){
            rightSuccesser--;
        }

        char temp = letters[rightSuccesser];
        letters[rightSuccesser] = letters[pivot];
        letters[pivot] = temp;

       reverse(letters,pivot+1,n-1);

       return new String (letters);



        
    }


    private static void reverse(char[] c,int start,int end){
    
        while(start<end){
            char c1 = c[start];
            c[start] = c[end];
            c[end] = c1;
            start++;
            end--;
        }
    }
}