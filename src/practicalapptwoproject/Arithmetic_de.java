/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalapptwoproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mmm
 */
public class Arithmetic_de {

    /**
     * @param args the command line arguments
     */
    public static String fix(double n)
    {
        if(n>0&&n<=0.8)
          return "A";
        else if(n>0.8&&n<=0.82)
            return "B";
        else if (n>0.82&&n<=1.0)
            return "C"; 
        return null;
    }
    public static String decomp() {
    
       
        String li = "";
        String x;
        double n=0.772,code,low=0,upp=1;
        double la = 0,ua=0.8,lb=0.8,ub=0.82,lc=0.82,uc=1;
        Scanner m=new Scanner(System.in);
        int l,d=0;
        l=m.nextInt();
        code=n;
        do
        {
            x=fix(code);
           li=li+x; 

            if(x=="A")
            {
              low=low+(upp-low)*la;
              upp=low+(upp-low)*ua;
              code=(n-low)/(upp-low);
            }
            else if(x=="B")
            {
              low=low+(upp-low)*lb;
              upp=low+(upp-low)*ub;
              code=(n-low)/(upp-low);
            }
            else if (x=="C")
            {
              low=low+(upp-low)*lc;
              upp=low+(upp-low)*uc;
              code=(n-low)/(upp-low);
            }
            d++;
        }while(d<l);
        
        return li ;
    }
    
}
