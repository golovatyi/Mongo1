/**
 * initialisation of DB
 */
package lpr1_subd;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.*;
import java.io.*;
import java.util.Iterator;
import org.bson.Document;
import org.bson.*;


import com.mongodb.MongoCredential;
import com.mongodb.MongoClientURI;

//@SuppressWarnings("unchecked")
public class MongoInt extends DetectField {

    static MongoDatabase database;
    static MongoClient mongoClient;
    static MongoCredential credential;
    static int status;
    
    public static String DB;
    public static String psw;
    static Document dc = new Document();
    
    MongoCollection<Document> collection;
    
    public MongoInt(){
        Connect(DB, psw);
    }
    
    public static void Setter(String db, String PSW) {
        MongoInt.DB = db;
        MongoInt.psw = PSW;
        Connect(DB, psw);
    }
    
    public static void Connect(String DB, String psw) throws MongoTimeoutException, 
            MongoSecurityException, MongoCommandException {
        // Creating a Mongo client

        MongoClientURI uri = new MongoClientURI(
       "mongodb+srv://golovatyi97:"+psw+"@subd-6ipsf.mongodb.net/admin");    
        // Creating Credentials
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase("LPR1Mongo");

        credential = MongoCredential.createCredential("golovatyi97", "LPR1Mongo",
        psw.toCharArray());
        System.out.println("Connected to the database successfully");
        // Accessing the database
        System.out.println("Credentials ::"+ credential);
        CreateDB(DB);

        }
    
    public static void RetrieveDocs(String name){
    // Retrieving a collection
    
    MongoCollection<Document> collection =
    database.getCollection(name);
    System.out.println("Collection zencovki selected successfully");
    // Getting the iterable object
    FindIterable<Document> iterDoc = collection.find();
    int i = 1;
    // Getting the iterator
    Iterator it = iterDoc.iterator();
    while (it.hasNext()) {
    System.out.println(it.next());
    i++;
    }
    
    }
    

    public static void CreateDB(String DB) {
        //todo: добавить обработчик com.mongodb.MongoCommandException
        try{
            database = mongoClient.getDatabase(DB);
            database.createCollection("init");
            status = 0;
        }catch(MongoCommandException ex){
            status = 1;
            
//            database = mongoClient.getDatabase(DB);
//            MongoCollection mc = database.getCollection("init");
//            mc.drop();
//            database = mongoClient.getDatabase(DB);
//            database.createCollection("init");
        }
    }

    public final void CreateCollection(String dsnm){
        database.createCollection(dsnm);
        collection = database.getCollection(dsnm);
        
    }
    
    public static void AppendDoc(String key, String value) {
        //System.out.println(key + value);
        dc.append(key, value);
        
 
    }
    public void AppendCollection(){
        if(!dc.isEmpty()){
        collection.insertOne(dc);
        }else{System.out.println("Skipped empty document");}
        
        dc.clear();
    }
    
    /** В ОТДЕЛЬНЫЙ КЛАСС, НАСЛЕДУЕМЫЙ ОТ ЭТОГО*/
    public void MongoToMark(String coll, String DB){
        /**
         * На вход - БД mongo, на выход - rusmark.txt
         */
        collection = database.getCollection(coll); //MongoCollection<Document>
        
        // Getting the iterable object
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
            i++;
        }
       
    }
    
    }
