package ch6;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ch6_3_PICNIC {

//    3
//    2 1
//    0 1
//    4 6
//    0 1 1 2 2 3 3 0 0 2 1 3
//    6 10
//    0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
//
//    1
//    3
//    4
    
    private static int findPair(boolean[][] isFriends, boolean[] alreadyPaired, int numStudents) {
        int target = -1;
        for (int i = 0; i < numStudents; i++) {
            if (!alreadyPaired[i]) {
                target = i;
                break;
            }
        }
        
        if (target == -1)
            return 1;
        
        int count = 0;
        
        for (int i = target + 1; i < numStudents; i++) {
            if (!alreadyPaired[i] && isFriends[target][i]) {
                alreadyPaired[i] = true;
                alreadyPaired[target] = true;
                count += findPair(isFriends, alreadyPaired, numStudents);
                alreadyPaired[i] = false;
                alreadyPaired[target] = false;
            
            }
        }
        return count;
    }
    
    private static void solve(boolean[][] isFriends, int numStudents) {
        boolean[] alreadyPaired = new boolean[numStudents];
        //Arrays.fill(alreadyPaired, false);
        System.out.println(findPair(isFriends, alreadyPaired, numStudents));
    }
    
    public static void main(String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        
        int task = scanner.nextInt();
        int[] numStudents = new int[task];
        boolean[][][] isFriends = new boolean[task][10][10];
        //Arrays.fill(isFriends, false);
        
        for (int i = 0; i < task; i++) {
            numStudents[i] = scanner.nextInt();
            int numFriends = scanner.nextInt();
            
            for (int j = 0; j < numFriends; j++) {
                int friendA = scanner.nextInt();
                int friendB = scanner.nextInt();
                isFriends[i][friendA][friendB] = true;
                isFriends[i][friendB][friendA] = true;
            }
            
        }
        
        for (int i = 0; i < task; i++)
            solve(isFriends[i], numStudents[i]);
        
    }
}
