import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        String compare = "";
        for(int i = 0; i <= s.length()-k; i++){
            compare = s.substring(i,i+k);
            if(compare.compareTo(smallest)<0){
                smallest = compare;
            }
            if(compare.compareTo(largest)>0){
                largest = compare;
            }
        }
        return smallest + "\n" + largest;
    }





    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}