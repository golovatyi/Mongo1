/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;

import java.io.*;
import java.util.*;


public class Execute extends FW{
    
    public Execute(String arg) throws IOException{  
        super(arg);
        Rusmark(); //setting up rusmark
        SetHM(); //setting up hashmap
        AppendDB(); 
    }
    public void AP() throws IOException{
        ArrayPrint(rusmark);
    }
    
    public final void AppendDB(){
        for(String[] blck: rusmark){
            for(String line: blck){
                if(!"*****".equals(line)){
                    AppendCollection();
                }
                else{
                    AppendDoc(
                            kwds.get("#".concat(Integer.toString(
                            Integer.parseUnsignedInt(line.substring(1, 5))))
                            ).toString(), "#".concat(Integer.toString(
                            Integer.parseUnsignedInt(line.substring(5)))));
                    }
                }
            }
        }
    }
    

