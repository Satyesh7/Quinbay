import java.io.*;
import java.util.*;

public class Solution {

   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    // System.out.println(n);
    ArrayList<Integer> list=new ArrayList<>();
    for(int i=0;i<n;i++){

        list.add(sc.nextInt());
    }
    int q=sc.nextInt();
    for(int i=0;i<q;i++){
        String queryTpe=sc.next();
        if(queryTpe.equals("Insert")){
             int index=sc.nextInt();
        int value=sc.nextInt();
        list.add(index,value);
        }
        else if(queryTpe.equals("Delete")){
            int index=sc.nextInt();
            list.remove(index);
        }
}
list.stream().forEach(i->System.out.print(i+" "));
    }
}
