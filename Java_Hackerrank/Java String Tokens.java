import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String trimmed=s.trim();
        String[] tokens = trimmed.split("[ !,?._'@]+");
        int tokenCount=0;
        for(String token: tokens){
            if(!token.isEmpty()){
                tokenCount++;
            }
        }
        System.out.println(tokenCount);
        for (String token : tokens) {
            System.out.println(token);
        }
        scan.close();
    }
}

