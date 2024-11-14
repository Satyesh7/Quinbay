import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
    Scanner sc=new Scanner(System.in);
    String A=sc.next();
    String B=sc.next();
    /* Enter your code here. Print output to STDOUT. */
    int sum = A.length()+B.length();
    System.out.println(sum);

    if(A.compareTo(B)<=0){
        System.out.println("No");
    }else{
        System.out.println("Yes");
    }

    String FirstAlpha = A.substring(0,1).toUpperCase();
    String FirstLetter = B.substring(0,1).toUpperCase();

    String remain = A.substring(1,A.length());
    String remaining = B.substring(1,B.length());

    System.out.println(FirstAlpha+remain+" " 
    + FirstLetter+remaining );      

}
}



