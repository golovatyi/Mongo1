/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.*;
import java.io.*;
import java.util.Iterator;
import org.bson.Document;

//import com.mongodb.MongoCredential;
//import com.mongodb.MongoClientURI;
public class MongoInt {

    

    public MongoInt() {
        //System.setProperty("encoding", "UTF-8");
    }
    
    public static void Connect(String psw) throws MongoTimeoutException, 
            MongoSecurityException, MongoCommandException {
    // Creating a Mongo client
    System.out.println(psw);
    
    MongoClientURI uri = new MongoClientURI(
   "mongodb+srv://golovatyi97:"+psw+"@subd-6ipsf.mongodb.net/LPR4Mongo");    // Creating Credentials
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("LPR4Mongo");
    database.listCollections();
    MongoCredential credential;
    credential = MongoCredential.createCredential("golovatyi97", "LPR4Mongo",
    psw.toCharArray());
    System.out.println("Connected to the database successfully");
    // Accessing the database
    System.out.println("Credentials ::"+ credential);
    
    // Retrieving a collection
    MongoCollection<Document> collection =
    database.getCollection("Zencovki");
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
}