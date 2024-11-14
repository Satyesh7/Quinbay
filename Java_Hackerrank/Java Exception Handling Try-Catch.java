import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner sc=new Scanner(System.in);

 try{
     int x=sc.nextInt();
     int y=sc.nextInt();
     int c=x/y;
       System.out.println(c);
 }catch(InputMismatchException q){
     System.out.println("java.util.InputMismatchException");
 }
 catch(Exception q){
     System.out.println(q);
 }
}
}