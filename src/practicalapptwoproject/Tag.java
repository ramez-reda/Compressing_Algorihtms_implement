/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalapptwoproject;

/**
 *
 * @author Ramez
 */
 public class Tag {
    int pointer ; char nextchar ;
    Tag ( int pointer , char nextchar){
    this.pointer = pointer ;
    this.nextchar = nextchar ;
    }
    public String printtag (){
    String x = "< "+pointer + " , " + nextchar + " > \n";
    //System.out.println("< "+pointer + " , " + nextchar + " >");
    return x ;
    }
}
