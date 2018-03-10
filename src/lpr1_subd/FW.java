/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author rootsu
 */
public class FW {
// <editor-fold desc="globals">
    String src;
    Scanner file;
    String[] init; //initial array



// </editor-fold>

    // <editor-fold desc="I. Init">
    public Scanner fOpen() throws IOException{ 
        file = new Scanner (new File(src));
        return file;
    }
    public void fClose() throws IOException{
        file.close();
    }
    public int CountRows() throws IOException{
        int i = 0;
        file = fOpen();
        while(file.hasNextLine()){
            ++i;
            file.nextLine();   
        }
        fClose();
        return i;
    }
    
    public String[] Init() throws IOException{
        int row = CountRows();
        init = new String[row];
        file = fOpen();
        for(int i = 0; i < row; i++){
            init[i] = file.nextLine();
        }
        fClose();
       
        return init; 
    }
    // </editor-fold>  
    
    public void OneDimPr(String[] arr){
        int row;
        row = arr.length;
        
        for(int i = 0; i<row; i++){
            
            System.out.print(arr[i] + "  ");
            
            System.out.println(' ');
        }
       }
    
    /** <editor-fold desc="При вызове из GUI задается источник scr. С ним и работаем">
     * 
     * @param name - имя файла, с которым работают  ВСЕ файловые методы
     * @throws java.io.IOException
     */
    public FW(String name) throws IOException{
        this.src = name; 
    }    
    // </editor-fold>
}
