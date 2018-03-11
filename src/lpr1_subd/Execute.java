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
        Rusmark();
         //gathering rusmark
    }
    public void AP() throws IOException{
        ArrayPrint(rusmark);
    }
}
