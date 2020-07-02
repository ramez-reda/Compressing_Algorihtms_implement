/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalapptwoproject;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Ramez
 */
public class OpenFile {
    JFileChooser fileChooser = new JFileChooser();
    StringBuilder sb = new StringBuilder();
    String filename ;
    public void PickMe  () throws Exception{
    if (fileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
    File file = fileChooser.getSelectedFile ();
    filename = fileChooser.getSelectedFile().getAbsolutePath();
    Scanner input = new Scanner (file);
    while (input.hasNext())
    {
        sb.append(input.nextLine()) ;
        
    }
    input.close();
    }
    else {
    //sb.append("no file selected");
    filename="no file selected";
    }
    }
    
}
