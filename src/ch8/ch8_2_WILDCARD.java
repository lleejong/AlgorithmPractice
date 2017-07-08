package ch8;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lleejong on 2017. 7. 1..
 */
public class ch8_2_WILDCARD {
    
    
    private static void solve(String pattern, ArrayList<String> candidates){
    
    }
    
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int task = Integer.parseInt(scanner.nextLine());
        
        ArrayList<String> patterns = new ArrayList<String>();
        ArrayList<ArrayList<String>> candidatesList = new ArrayList<ArrayList<String>>();
        
        for(int i = 0; i < task; i++){
            patterns.add(scanner.nextLine());
            int numCandidates = Integer.parseInt(scanner.nextLine());
            ArrayList<String> candidates = new ArrayList<String>();
            for(int j = 0; j < numCandidates; j++){
                candidates.add(scanner.nextLine());
            }
            candidatesList.add(candidates);
        }
        
        for(int i = 0; i < task; i++){
            solve(patterns.get(i), candidatesList.get(i));
        }
        
    }
}
