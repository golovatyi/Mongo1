/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpr1_subd;

import com.mongodb.client.MongoDatabase;
import com.mongodb.*;
import java.io.*;
//import com.mongodb.MongoCredential;
//import com.mongodb.MongoClientURI;
public class MongoInt {

    

    public MongoInt() {
    }
    
    public void Connect(String psw) {
    // Creating a Mongo client
    
    MongoClientURI uri = new MongoClientURI(
   "mongodb+srv://golovatyi97:"+psw+"@subd-6ipsf.mongodb.net/SUBD");    // Creating Credentials
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("SUBD");
    
    database.getName();
    MongoCredential credential;
    credential = MongoCredential.createCredential("golovatyi97", "SUBD",
    psw.toCharArray());
    System.out.println("Connected to the database successfully");
    // Accessing the database
    System.out.println("Credentials ::"+ credential);
    }
}