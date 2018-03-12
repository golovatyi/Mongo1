/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;

import java.io.*;
import java.lang.*;
import java.util.*;


public class Execute extends FW{
    String key = "";
    public Execute(String arg) throws IOException{  
        super(arg);
        Rusmark(); //setting up rusmark
        SetHM(); //setting up hashmap
        CreateCollection(arg);
        AppendDB(); 
    }
    public void AP() throws IOException{
        ArrayPrint(rusmark);
    }
    
    public final void AppendDB(){
        
        String value;
        for(String[] blck: rusmark){
            for(String line: blck){
               if((line==null)){continue;}
                for(char ch: line.substring(0, 5).toCharArray()){
                    if((ch=='#')|(Character.isDigit(ch))){
                        //this.key = key.concat(Character.toString(ch));
                        //key = key.concat(Character.toString(ch));
                        key += Character.toString(ch);
                    }
                }
               
                //(key!=null)|(!"".equals(key))|
                if(!((line.substring(5)).length()<=1)){
                    AppendDoc(kwds.get(key).toString(), line.substring(5));
                    this.key = "";
                    
                }
            }
            if(!dc.isEmpty()){AppendCollection();}
        }
    }
}

    

