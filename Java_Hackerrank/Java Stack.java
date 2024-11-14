import java.util.*;

class Solution{
    public static boolean isValid(String str)
    {
        String open = "{[(";
        String close = "}])";
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (open.indexOf(c) == -1 && close.indexOf(c) == -1)
                {return false;}
            else if (open.indexOf(c) != -1) {stack.push(c);}
            else
                {char opposite = open.charAt(close.indexOf(c));
                if (stack.isEmpty() || stack.pop() != opposite) return false;
                }
            }
        return stack.isEmpty();   
    }
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();
            System.out.println(isValid(input));
        }
        
    }
}



