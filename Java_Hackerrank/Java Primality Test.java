import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Solution{
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String n=br.readLine();
        br.close();
        BigInteger bi=new BigInteger(n);
        if(bi.isProbablePrime(10)){
            System.out.println("prime");
        }else{
                System.out.println("not prime");
            }
        }
    }
