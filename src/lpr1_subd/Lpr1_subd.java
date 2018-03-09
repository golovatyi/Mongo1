/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;
import java.io.*;
/**
 *
 * @author rootsu
 */
public class Lpr1_subd extends Conversion{
    
    static String name;
    static InputStream in;
    static Reader r; 
    public Lpr1_subd(String arg) throws FileNotFoundException{
        in = new FileInputStream(arg);
    }
    
    public static void main(String[] args) throws IOException {
        System.out.print("lprmaincalled");
        r = new BufferedReader(new InputStreamReader(in, "Windows-1251"));
    }
}
