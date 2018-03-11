/**
 * Получение на вход текстового файла и возвращение в виде массива для 
 * дальшейшей работы.
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

    String[] block; //
    String st;
    String[][] rusmark;
    int cblock = 1; 
    int[] crblock; 
    final String stars = "*****";


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
    
    public int CountBlocks() throws IOException{
        for(String s: Init()){
            if(s.equals(stars)){
                ++cblock;
            }
        }
        return cblock;
    } 
    
    public int[] CrBlock() throws IOException{
        crblock = new int[CountBlocks()];
        int i = 0;
        for(String s: Init()){
            if(s.equals(stars)){
                ++i;
            }else{++crblock[i];}
        }
        return crblock;
    }
    
    public int max() throws IOException{
        int max = CrBlock()[0];
        for(int e: CrBlock()){
            max = (e > max) ? e : max;
        }
        return max;
    }
    
    public String[][] Rusmark() throws IOException{ //массив [блоки][строки]
        rusmark = new String[CountBlocks()][max()];
        int i = 0, j = 0;
        for(String s: Init()){
            if(s.equals(stars)){
                ++i; j = 0;
            }else{rusmark[i][j] = s; ++j;}
        }
        return rusmark;
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
    
    
   // <editor-fold desc="II. Helpers"> 
    public void OneDimPr(String[] arr){
        int row;
        row = arr.length;
        
        for(int i = 0; i<row; i++){
            
            System.out.print(arr[i] + "  ");
            
            System.out.println(' ');
        }
       }
    
    public void ArrayPrint(String[][] arr){
        int row, col, i, j;
        row = arr.length;
        col = arr[0].length;
        for(i = 0; i<row; i++){
            for (j = 0; j<col; j++){
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println(' ');
        }
       }
    
    // </editor-fold>  
    
    /** <editor-fold desc="При вызове из GUI задается источник scr.
     * С ним и работаем">
     * 
     * @param name - имя файла, с которым работают  ВСЕ файловые методы
     * @throws java.io.IOException
     */
    public FW(String name) throws IOException{
        this.src = name;
    }    
    /** </editor-fold> */
}
