import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger bigInt1 = sc.nextBigInteger();
    BigInteger bigInt2 = sc.nextBigInteger();
    BigInteger sum = bigInt1.add(bigInt2);
    BigInteger product = bigInt1.multiply(bigInt2);
    System.out.println(sum);
    System.out.println(product);
}
}