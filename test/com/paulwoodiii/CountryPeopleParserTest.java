package com.paulwoodiii;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by paul on 9/26/16.
 */
public class CountryPeopleParserTest {

    @org.junit.Test
    public void testParse() throws Exception {

        //Given
        String input = "id,first_name,last_name,email,country,ip_address\n" +
                "1,Martha,Watson,mw0@un.org,France,97.252.235.144\n" +
                "2,Kathleen,Medina,kmedina1@unc.edu,Czech Republic,149.62.63.167\n" +
                "3,Martha,Jenkins,mjenkins0@un.org,France,97.252.235.143\n";

                // If
        HashMap<String, ArrayList<Person>> people = CountryPeopleParser.parse(input);

        // Then
        assertFalse( people.isEmpty() );
        assertTrue( people.size() == 2);
        assertTrue( people.get("France").size() == 2 );
        //This also test if france is sorted
        Person m = people.get("France").get(0);
        assertTrue( m.first_name .equals("Martha"));
        assertTrue( people.get("France").get(0).getLast_name().equals("Jenkins") );
        assertTrue( people.get("France").get(0).getEmail().equals( "mjenkins0@un.org" ));
        assertTrue( people.get("France").get(0).getCountry().equals( "France") );
        assertTrue( people.get("France").get(0).getIp_address().equals( "97.252.235.143" ));
        assertTrue( people.get("Czech Republic").size() == 1 );
        assertEquals( people.get("England"), null);
    }

}