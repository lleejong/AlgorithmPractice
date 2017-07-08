package ch7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lleej on 2017-06-28.
 */
public class ch7_3_QUADTREE {
    private static int cursor = 0;
   
    
    private static String solve(String input){
        if(cursor >= input.length())
            return "";
        
        StringBuilder result = new StringBuilder("");
        char ch = input.charAt(cursor++);
        result.append(ch);
        if(ch != 'x'){
            return result.toString();
        }
        //A <-> C
        //B <-> D
        String A = solve(input);
        String B = solve(input);
        String C = solve(input);
        String D = solve(input);
        
        result.append(C);
        result.append(D);
        result.append(A);
        result.append(B);
        
        return result.toString();
    }
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int task = Integer.parseInt(scanner.nextLine());
        ArrayList<String> inputs = new ArrayList<String>();
        for(int i = 0; i < task; i++)
            inputs.add(scanner.nextLine());
        
        for(String input : inputs){
            cursor = 0;
            String result = solve(input);
            System.out.println(result);
        }
    }
}
