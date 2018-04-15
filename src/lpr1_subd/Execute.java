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
    public static String key = "";
    public Execute(String arg) throws IOException{  
        super(arg);
        Rusmark(); //setting up rusmark
        SetHM(); //setting up hashmap
        CreateCollection(arg);
        AppendDB(); 
    }
//    public void AP() throws IOException{
//        ArrayPrint(rusmark);
//    }
    
    public final void AppendDB(){ //данная функция делает записи
        
        
        for(String[] blck: rusmark){ //проход по блокам
            for(String line: blck){ //пробежка по строкам
               if((line==null)){continue;}
                for(char ch: line.substring(0, 5).toCharArray()){
                    if((ch=='#')|(Character.isDigit(ch))){
                        key += Character.toString(ch);
                    }
                }
               
                //нужно учесть подполя, добавить парсирование строки
                if(!((line.substring(5)).length()<=1)){
                    //поместить в отдельный класс, функцию
                    switch(key){
                        case "#10":
                            Append10(line);
                            break;
                        
                        case "#106":
                            Append106(line);
                            break;  
                        
                        case "#210":
                            Append210(line);
                            break;
                        
                        case "#215":    
                        case "#225":    
                        case "#621":
                        case "#908":    
                        case "#606":    
                        case "#700":    
                        case "#920":    
                        case "#900":
                            
                        case "#907":    
                        case "#919":    
                        case "#899":
                        case "#999":    
                        case "#620":    
                        case "#5":    
                        case "#100":    
                        case "#801":    
                           
                        case "#1000":    
                        case "#200":    
                        //case "#907":
                        case "#903":    
                        case "#910":    
                          
                            
                            
                            
                        default:
                            AppendDoc(kwds.get(key).toString(), line.substring(5));
                            
                    
                }
                    this.key = "";
                }
            }
            if(!dc.isEmpty()){AppendCollection();}
        }
    }
}

    

