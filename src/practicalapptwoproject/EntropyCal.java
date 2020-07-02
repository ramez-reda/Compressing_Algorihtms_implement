/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalapptwoproject;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramez
 */
public class EntropyCal {
    String Letterss = "" ;
    String proo = "" ;
    String IS = "";
    String HS= "" ;
    public void cal(String str){
       // String str = "AABAACAADA";

        Double SumEnt = 0.00;
        List<Letter> Entropy = new LinkedList<Letter>();
        Entropy.add(new Letter(str.charAt(0), 1.00, str.length()));

        boolean exp = true;

        for (int i = 1; i < str.length(); i++) {
            exp = true;
            for (int j = 0; j < Entropy.size(); j++) {

                if (Entropy.get(j).letter == str.charAt(i)) {
                    Entropy.get(j).count++;
                    exp = false;
                }

            }
            if (exp) {
                Entropy.add(new Letter(str.charAt(i), 1.00, str.length()));
                exp = true;
            }
        }

        for (Letter let : Entropy) {
            let.calculate();
            SumEnt += let.H;
        }

       
           for (Letter let : Entropy) {
           Letterss = Letterss+ let.letter + "\n";
            proo = proo+   let.prob + "\n";
            
         IS = IS +   let.I + "\n";
            HS = HS + let.H + "\n";
            
        }
        JOptionPane.showMessageDialog(null, "Entropy Equals = " + SumEnt);
        

    }

   

}
    

class Letter {

    char letter;
    int all;
    Double count;
    Double prob;
    Double I, H;

    public Letter(char let, Double counter, int al) {
        letter = let;
        count = counter;
        all = al;
    }

    public void calculate() {
        prob = (Double) count / all;
        I = logb2(1.00 / prob);
        H = prob * I;
    }

    public static Double logb2(Double x) {
        return (Math.log(x)) / (Math.log(2));
    }

}
