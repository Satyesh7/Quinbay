import java.util.Scanner;

public class Solution {

   static boolean isAnagram(String a, String b) {
            String a1 = a.toLowerCase();
     String b1 = b.toLowerCase();

         if(sortString(a1).equals(sortString(b1))){
                 return true;
         }else{
                 return false;
         }
}

public static String sortString(String str){
        char[] ch = str.toCharArray();
        char temp;
        for(int i=0;i<(ch.length)-1;i++){
                for(int j=i+1;j<ch.length;j++){
                        if(ch[j]<ch[i]){
                                temp = ch[i];
                                ch[i]=ch[j];
                                ch[j]=temp;
                        }
                }
        }
        String str1 = new String(ch);
        return str1;
}

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
