package testcase.avartech;

import java.util.Scanner;

public class learnExceptions {
    public static void main(String[] args) {
        int [] arr = new int[3];
        {
            try {
                for (int i = 0; i <= arr.length; i++)
               // System.out.println(arr[i]);
                System.out.println(arr[i]);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }finally {
                System.out.println("finish");
            }

        }

    }
}
