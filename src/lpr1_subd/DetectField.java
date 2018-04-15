/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;
//import lpr1_subd.Execute.*;
/**
 *
 * @author rootsu
 */
public class DetectField {
    static MongoInt m;
    
    
    private static void AppendDoc(String key, String value){
        MongoInt.AppendDoc(key, value);
    }
    
    public static void Append10(String line){
        //e.AppendDoc(key, value);
        
        if(line.contains("^D")){
            int index = line.indexOf("^D") + 2;     
            String value = line.substring(index).concat(" p.");
            AppendDoc("Цена",
                    value);
        }
        else{
            System.out.printf(
                "Добавить обработчик."
                        + " Ключ #10, линия %s. \n", line);}
    }
    
    public static void Append106(String line){
        if(line.contains("^a")){
            int index = line.indexOf("^a")+2;
            switch(line.substring(index, index+1)){
                case "d": 
                    AppendDoc("Форма документа",
                    "Крупная печать");
                    break;
                case "e":
                    AppendDoc("Форма документа",
                    "Газетный формат");
                    break;
                case "f":
                    AppendDoc("Форма документа",
                    "Шрифты Брайля и Муна");
                    break;
                case "g":
                    AppendDoc("Форма документа",
                    "Микропечать");
                    break;
                case "h":
                    AppendDoc("Форма документа",
                    "Рукописный");
                    break;
                case "i":
                    AppendDoc("Форма документа",
                    "Информация на нескольких носителях");
                    break;
                case "j":
                    AppendDoc("Форма документа",
                    "Минипечать");
                    break;
                case "r":
                    AppendDoc("Форма документа",
                    "Обычная печать");
                    break;
                case "s":
                    AppendDoc("Форма документа",
                    "Электронный ресурс");
                    break;
                default:  
                    System.out.printf("%s not found \n",
                            line.substring(index));
            }                       
        }
        else{
            System.out.printf(
                "Добавить обработчик."
                        + " Ключ 106, линия %s. \n", line);
        }
    }
    
    public static void Append210(String line){
        int i1, i2;
        if(line.contains("^a")){
            i1 = line.indexOf("^a")+2;
            i2 = (line.contains("^c"))? line.indexOf("^c"): line.length()-1;          
            AppendDoc("Место издания", line.substring(i1, i2));
        }
        if(line.contains("^c")){
            i1 = line.indexOf("^c")+2;
            i2 = (line.contains("^d"))? line.indexOf("^d"): line.length()-1;          
            AppendDoc("Имя издателя", line.substring(i1, i2));
        }
        if(line.contains("^d")){
            i1 = line.indexOf("^d")+2;
            //i2 = line.length()-1;          
            AppendDoc("Дата издания", line.substring(i1));
        }
        
    }
}



