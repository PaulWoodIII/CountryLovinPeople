package com.paulwoodiii;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by paul on 9/26/16.
 */
public class MainTest {
    @Test
    public void testReadFile() throws Exception {
        //Given
        String input = "./fixtures/testRead.txt";

        //If
        String output = Main.readFile(input);
;
        //Then
        assertTrue(output.equals("a\nb\nc\n"));
    }


}