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
public class lz77compress {
 String src ;
    
    int pointer ;
int length ;
char nextchar ;
List <lz77compress> list = new LinkedList<lz77compress> ();
public lz77compress (int p , int l , char c){
pointer = p ;
length = l ;
nextchar = c ;
}
public lz77compress (){}
public void compress ()
{   String str = this.src ;
    int i = 0 , j = i+1  , index , pointer , length ;
    char character ;
    String history = "";
    boolean exp = true;
while(i < str.length() && exp ){
if (i==0)
{
history = str.substring(0,1);
list.add(new lz77compress (0,0,str.charAt(0)));
i++ ;
}

else{

if (j== str.length())
{ if (history.contains(str.substring(i, j))){
  index = history.lastIndexOf(str.substring(i, j));
  pointer = i-index ;
length = j- i ;
character = '0';
list.add(new lz77compress (pointer , length , character));
exp = false ;
break ;}
else {

index = history.lastIndexOf(str.substring(i, j-1));
pointer = i - index  ;
length = j-1-i;
character = str.charAt(j-1);
list.add(new lz77compress (pointer , length , character));
history= history.concat(str.substring(i, j));
i = j ;
j++;
break ;
}
}
if (history.contains(str.substring(i, j)))
    j++ ;
else {
if (j-i == 1){
list.add(new lz77compress (0,0,str.charAt(i)));
history = history.concat(str.substring(i, j));
i++;
}
else
{
index = history.lastIndexOf(str.substring(i, j-1));
pointer = i - index  ;
length = j-1-i;
character = str.charAt(j-1);
list.add(new lz77compress (pointer , length , character));
history= history.concat(str.substring(i, j));
i = j ;
j++;
}
}
}

}
}

public String printtags (){
    String tags ="" ;
for (lz77compress t:list){
   // System.out.println("< " + t.pointer + " , " + t.length + " , " + t.nextchar + " > \n" );
 tags = tags +    "< " + t.pointer + " , " + t.length + " , " + t.nextchar + " > " + "\n" ;
}
return tags ;
}
public String decompress (List <lz77compress> list)
{ 
    String str = ""  , seq ;
    int p = 1 ; 
 
    for (lz77compress t : list)
{  
    if(t.pointer == 0)
    {    
        str = str.concat(String.valueOf(t.nextchar)) ;
        p++;
    }
    else {
        
        int from = p-t.pointer-1  , to= from + t.length  ;
        
        seq = str.substring(from ,to );
    str = str.concat(seq );
    if(t.nextchar != '0')
    str = str.concat(String.valueOf(t.nextchar)) ;
    
    p = p + t.length + 1 ; 
        }
       
        
    }
     return str;
    
}
    
   
}

