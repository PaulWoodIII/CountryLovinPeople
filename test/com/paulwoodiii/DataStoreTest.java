package com.paulwoodiii;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Created by paul on 9/26/16.
 */
public class DataStoreTest {
    @Test
    public void persist() throws Exception {
        //Given
        String filename = "./fixtures/persistOutput.json";
        HashMap<String,String> quickHash = new HashMap<>();
        quickHash.put("key","value");

        //If
        DataStore.persist(filename,quickHash);

        //Then
        File output = new File(filename);
        assertTrue(output.exists());
        Scanner scanner = new Scanner(output);
        String outPutString = scanner.nextLine();
        assertTrue(outPutString.contains("key"));
        assertTrue(outPutString.contains("value"));
    }

}