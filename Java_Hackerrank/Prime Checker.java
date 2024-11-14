import java.io.*;
import java.util.*;

public class Solution {

public static void main(String[] args) {

    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        int n4 = Integer.parseInt(br.readLine());
        int n5 = Integer.parseInt(br.readLine());

        Prime prime = new Prime();
        prime.checkPrime(n1);
        prime.checkPrime(n1, n2);
        prime.checkPrime(n1, n2, n3);
        prime.checkPrime(n1, n2, n3, n4, n5);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
static class Prime { public void checkPrime(int... numbers) { for (int num : numbers) { if (isPrime(num)) { System.out.print(num + " "); } } System.out.println(); }

private boolean isPrime(int num) {
    if (num <= 1) return false;
    if (num == 2) return true;
    if (num % 2 == 0) return false;

    for (int i = 3; i <= Math.sqrt(num); i += 2) {
        if (num % i == 0) return false;
    }
    return true;
}
} } 