import java.io.*;
import java.util.*;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.util.Scanner;

public class Solution { 
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in); String s = sc.nextLine(); sc.close();

    try {
        // Create MD5 MessageDigest instance
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Calculate MD5 hash in bytes
        byte[] messageDigest = md.digest(s.getBytes());

        // Convert byte array into signum representation
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            // Convert each byte to hexadecimal
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        // Print the result
        System.out.println(hexString.toString());
    } catch (NoSuchAlgorithmException e) {
        // Handle exception if MD5 algorithm is not available
        throw new RuntimeException(e);
    }
}
}