package ch6;

public class ch6_5_BOARDCOVER {
    
    public static void test(int[] arr){
        arr[0] = 4;
    }
    
    public static void main(String args[]){
        int[] arr = {1,2,3};
        test((int[])arr.clone());
        System.out.println(arr[0]);
    }
}
