/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_mongo;

import java.io.*;
import java.util.concurrent.TimeUnit;
import lpr1_subd.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rootsu
 */
public class NewEmptyJUnitTest {
    
    MongoInt m;
    //Execute e;
    

    @Test
    public void testExample() throws IOException, InterruptedException{
        

        MongoInt.Setter("LPR1Mongo", "%2BklOun02");
        TimeUnit.MILLISECONDS.sleep(3000);
        Execute fw = new Execute("/home/rootsu/Downloads/irbis.dat");
        
        
    }

    public NewEmptyJUnitTest(){
    }
    
}
