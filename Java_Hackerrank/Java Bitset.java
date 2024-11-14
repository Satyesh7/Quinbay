import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

try (var scanner = new Scanner(System.in)) {
            
            var n = Integer.valueOf(scanner.nextLine().split(" ")[0]);
            var b1 = new BitSet(n);
            var b2 = new BitSet(n);
            var map = Map.of("1", b1, "2", b2);
            
            while(scanner.hasNext()) {
                var operationParts = scanner.nextLine().split(" ");
                var operation = operationParts[0];
                var leftOperand = operationParts[1];
                var rightOperand = operationParts[2];
                
                switch (operation) {
                    case "AND":
                        map.get(leftOperand).and(map.get(rightOperand));
                        break;
                    case "OR":
                        map.get(leftOperand).or(map.get(rightOperand));
                        break;
                    case "XOR":
                        map.get(leftOperand).xor(map.get(rightOperand));
                        break;
                    case "FLIP":
                        map.get(leftOperand).flip(Integer.valueOf(rightOperand));
                        break;
                    default:
                        map.get(leftOperand).set(Integer.valueOf(rightOperand));
                        break;
                }
                
                System.out.printf("%d %d\n", b1.cardinality(), b2.cardinality());
            }
        }
    }
}
