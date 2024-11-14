import java.io.*;
import java.util.*;

public class Solution {
   public static void main(String[] args) {
    List<Object> result = Arrays.asList(1, 2, 3, "Hello","World");
    for (Object object : result) {
        if(object instanceof String){
            System.out.println(object.toString());
        }else{
            Integer temp =(Integer) object;
            System.out.println(temp);
        } 
    }
}
}
