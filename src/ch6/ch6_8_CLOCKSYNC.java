package ch6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ch6_8_CLOCKSYNC {
    
    private static final int NUM_CLOCK = 16;
    private static final int NUM_SWITCH = 10;
    private static boolean[][] clockSwitch = new boolean[NUM_SWITCH][NUM_CLOCK];
    
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
    
    private static boolean checkClock(int[] currentTime) {
        for(int time : currentTime){
            if (time != 12)
                return false;
        }
        return true;
    }
    
    private static void pushSwitch(int[] currentTime, int switchNum) {
        for (int i = 0; i < clockSwitch[switchNum].length; i++) {
            if (clockSwitch[switchNum][i]) {
                currentTime[i] += 3;
                if(currentTime[i] > 12)
                    currentTime[i] -= 12;
            }
        }
    }
    
    
    private static int solve(int currentSwitchNum, int[] currentTime) {
        if (currentSwitchNum == NUM_SWITCH) {
            if (checkClock(currentTime))
                return 0;
            else
                return Integer.MAX_VALUE;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (checkClock(currentTime)) {
                return i;
            } else {
                if (i != 0) {
                    pushSwitch(currentTime, currentSwitchNum);
                }
                result = Math.min(result, i + solve(currentSwitchNum+ 1, currentTime.clone()));
            }
        }
        return result;
    }
    
    public static void main(String args[]) {
        init();
        Scanner scanner = new Scanner(System.in);
        int task = scanner.nextInt();
        int[][] currentTime = new int[30][NUM_CLOCK];
        for (int i = 0; i < task; i++) {
            for (int j = 0; j < 15; j++)
                currentTime[i][j] = scanner.nextInt();
        }
        
        for (int i = 0; i < task; i++) {
            int result = solve(0, currentTime[i]);
            if (result == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(result);
        }
    }
}
