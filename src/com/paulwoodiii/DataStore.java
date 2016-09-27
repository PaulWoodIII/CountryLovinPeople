package com.paulwoodiii;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;

/**
 * Created by paul on 9/26/16.
 */
public class DataStore {
    public static void persist(String filename, Serializable object){
        File f = new File(filename);
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.deep(true).serialize(object);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't save to file!");
        }
    }
}
