/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalapptwoproject;

import java.util.Scanner;

/**
 *
 * @author ASASA
 */
public class FloatPoint {

    /**
     * @param args the command line arguments
     */
     static String src ;
    public static float start() {
        
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
          String  x = src ;
        char[] arr = x.toCharArray();
        System.out.println("Enter low rang A");
     float la=sc.nextFloat();
      System.out.println("Enter high rang A");
      float ha=sc.nextFloat();
       System.out.println("Enter low rang B");
       float lb=sc.nextFloat();
        System.out.println("Enter high rang B");
        float hb=sc.nextFloat();
         System.out.println("Enter low rang C");
         float lc=sc.nextFloat();
          System.out.println("Enter high rang C");
         float hc=sc.nextFloat();
        
     

        float lower = 0, upper = 1, compress;
      
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]=='A'){
            lower = lower + (upper - lower) * la;
            upper = lower + (upper - lower) * ha;
        }
            else if(arr[i]=='B'){
            lower = lower + (upper - lower) * lb;
            upper = lower + (upper - lower) * hb;
        }
            else if(arr[i]=='C'){
            lower = lower + (upper - lower) * lc;
            upper = lower + (upper - lower) * hc;
        }
        }
        compress = (float) ((lower + upper) / 2.0);
        return ( compress);
    }
    
}
