

public class Palindrome{

    public static void main(String[] args) {
        String s = "a dog! a panic in a pagoda.";
        System.out.println("Given String is palindrome : "+ isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        int n = s.length();
        int l = 0;
        int r = n-1;

        while(l < r){

            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            char c1 = s.charAt(l);
            char c2 = s.charAt(r);

            if(l < r && Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}