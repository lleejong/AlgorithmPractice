package ch6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ch6_8_CLOCKSYNC {
    
    private static boolean[][] clockSwitch = new boolean[10][16];
    
    private static void init() {
        clockSwitch[0][0] = true;
        clockSwitch[0][1] = true;
        clockSwitch[0][2] = true;
        
        clockSwitch[1][3] = true;
        clockSwitch[1][7] = true;
        clockSwitch[1][9] = true;
        clockSwitch[1][11] = true;
        
        clockSwitch[2][4] = true;
        clockSwitch[2][10] = true;
        clockSwitch[2][14] = true;
        clockSwitch[2][15] = true;
        
        clockSwitch[3][0] = true;
        clockSwitch[3][4] = true;
        clockSwitch[3][5] = true;
        clockSwitch[3][6] = true;
        clockSwitch[3][7] = true;
        
        clockSwitch[4][6] = true;
        clockSwitch[4][7] = true;
        clockSwitch[4][8] = true;
        clockSwitch[4][10] = true;
        clockSwitch[4][12] = true;
        
        
        clockSwitch[5][0] = true;
        clockSwitch[5][2] = true;
        clockSwitch[5][14] = true;
        clockSwitch[5][15] = true;
        
        clockSwitch[6][3] = true;
        clockSwitch[6][14] = true;
        clockSwitch[6][15] = true;
        
        clockSwitch[7][4] = true;
        clockSwitch[7][5] = true;
        clockSwitch[7][7] = true;
        clockSwitch[7][14] = true;
        clockSwitch[7][15] = true;
        
        clockSwitch[8][1] = true;
        clockSwitch[8][2] = true;
        clockSwitch[8][3] = true;
        clockSwitch[8][4] = true;
        clockSwitch[8][5] = true;
        
        clockSwitch[9][3] = true;
        clockSwitch[9][4] = true;
        clockSwitch[9][5] = true;
        clockSwitch[9][9] = true;
        clockSwitch[9][13] = true;
    }
    
    private static boolean check(int[] currentTime) {
        for (int time : currentTime) {
            if (time != 12)
                return false;
        }
        return true;
    }
    
    public static void main(String args[]) {
        init();
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();
        int[][] currentTime = new int[30][16];
        for (int i = 0; i < task; i++) {
            for (int j = 0; j < 15; j++)
                currentTime[i][j] = scanner.nextInt();
        }
        
        for (int i = 0; i < task; i++)
            solve(currentTime[i]);
    }
}
