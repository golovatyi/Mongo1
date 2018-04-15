/**
 * Conversion to Mongo and sending collection to Atlas cluster.
 * Нужно запараметризовать записи.
 */
package lpr1_subd;

import java.util.*;

public class SetDict extends MongoInt{
    static Map kwds;
    public SetDict(){
        super();
    }
    
    public static Map SetHM() {
        kwds = new HashMap();   
        //++ - добавлен обработчик подполей, либо не требуется
        kwds.put("#1", "Идентификатор");
        kwds.put("#922", "Версия");//++
        kwds.put("#10","ISBN"); //++
        kwds.put("#101","Язык");//++
        kwds.put("#200", "Заглавие и сведения об ответственности");
        kwds.put("#102","Страна публикации");//++
        kwds.put("#106","Форма документа");//++
        kwds.put("#210", "Публикация распространение и др");
        kwds.put("#215", "Физическая характеристика");
        kwds.put("#225","Серия");
        kwds.put("#621", "Место и дата, связанные с историей экземпляра");
        kwds.put("#606","Наименование темы как предмет");
        kwds.put("#700","Автор");
        kwds.put("#899","Данные о местонахождении");
        kwds.put("#620", "Место и дата публикации, исполнения");
        kwds.put("#5", "Идентификатор версии");
        kwds.put("#100", "Данные общей обработки");
        kwds.put("#801", "Источник записи");
        for(int i = 1; i<=1000; i++){
        String itr = "#";
        itr = itr.concat(Integer.toString(i));
        if(!kwds.containsKey(itr)){
            kwds.put(itr, itr);
        }
        }      
        
        return kwds;
 // <editor-fold>      
/** 
 *#908: Б 19
 *#920: PAZK
 *#900: ^Ta^B05
 *#907: ^CZU0^BRUГУК "Московская ЦБС"^A20070104
 *#919: ^Arus^N02^Gca^KPSBO
 *#919: ^N||.
 * /#1000: 00803nam2 22003131  450 
 * #999: 0000000
 * #907: ^C^A20080324^B
#903: 65.290-5/Б 19-091736
#910: ^AC^D^11
  */
  //</editor-fold>   
    }
    
}


