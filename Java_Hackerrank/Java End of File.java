import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            System.out.println(i +" "+ s);
            i++;            
        }
    }

    }
