package automationFramework;

import java.util.Arrays;

/**
 * Created by anny on 03.03.16.
 */
public class Training {
    public static void main(String[] args){

        String [] a1 = {"c", "b", "a"};
        System.out.println(Arrays.toString(a1));

//        String [] a2 = a1;

        for (int i = 0; i <= a1.length/2; i++){
            String temp = a1[i];
            a1[i] = a1[a1.length - 1 - i];
            a1[a1.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(a1));
    }
  }

