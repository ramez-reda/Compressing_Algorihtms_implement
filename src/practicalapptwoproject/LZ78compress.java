/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicalapptwoproject;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ramez
 */
public class LZ78compress {
static String tags = "" ; 
 static String  str ;
    //int finish ;
     List <Tag> Tags = new LinkedList <Tag>();
     LZ78compress (String x){
     str = x ;
     }
     LZ78compress(){}
   
      public  String  compress (){
     
      List <String> dictionary = new LinkedList <String>();
      
      String newstr = "" , last = "";
      int to , where = 0 ;
      boolean exist  = false ;
      
      dictionary.add(" ");
      // newstr = "" + str.charAt(0);
   //   Tags.add(new Tag (0,str.charAt(0)));
     // dictionary.add(newstr);
      
      
      for (  int i = 0 ; i < str.length() ; )
     
      { 
          
          to = i+1 ;
          
       
          newstr = "" + str.substring(i, to) ;
            int j = 0 ;
      
       while (  to <= str.length())
       {  
            newstr = "" + str.substring(i, to) ;
          exist = false ;
          
            if(j== dictionary.size())
               break ;
            
          
           
       
       if (dictionary.get(j).equals(newstr))
       {
        exist = true ;
        //last = newstr ;
        
        to ++ ;
        
        where = j ;
       
       
       }
       
       
      
       j++;
      
         
       }
       
       
      
       
       if (!exist)
       {
      
           
       if (newstr.length() == 1 )
       {
       Tags.add(new Tag (0,str.charAt(i)));
      dictionary.add(newstr);
       i++;
       }
       
       else
       {  Tags.add(new Tag (where,newstr.charAt(newstr.length()-1)));
      dictionary.add(newstr);
       i= to ;
       
       }
       }
       if (exist)
       {
         
       Tags.add(new Tag (where,' '));
      dictionary.add(newstr);
      
       break ;
       
       }
       
       }
       for (Tag tg : Tags)
       { 
           
           tags = tags +  tg.printtag();
         
       }
       return tags ;
        
      }
     
      public static String decompress (List <Tag> Tags){
      String str = "" ;
      String character ;
          List <String> dictionary = new LinkedList <String> () ;
      dictionary.add(" ");
          for (Tag tg : Tags)
      { if (tg.pointer == 0)
      {
          character = "" + tg.nextchar ;
      str = str + character ;
      dictionary.add(character);
      }
      else 
      {
      character = dictionary.get(tg.pointer) + tg.nextchar;
      str = str + dictionary.get(tg.pointer) + tg.nextchar;
       dictionary.add(character);
      }
      
      
      }
     return str ;
      }
     
    
}
