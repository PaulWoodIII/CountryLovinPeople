package com.paulwoodiii;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by paul on 9/27/16.
 */
public class PersonTest {
    @Test
    public void equals() throws Exception {
        //Given
        Person p1 = new Person(1, "A", "A", "A@B.COM", "A", "192.168.0.1");
        Person p2 = new Person(1, "A", "A", "A@B.COM", "A", "192.168.0.1");

        //If
        //You compare them

        //Then
        assertTrue(p1.equals(p2));
    }

    @Test
    public void compareTo() throws Exception {
        //Given
        Person p1 = new Person(1, "B", "A", "A@B.COM", "A", "192.168.0.1");
        Person p2 = new Person(1, "A", "A", "A@B.COM", "A", "192.168.0.1");
        Person p3 = new Person(1, "A", "A", "A@B.COM", "B", "192.168.0.1");

        //If
        //You compare them

        //Then
        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p2.compareTo(p1) < 0);
        assertTrue(p2.compareTo(p3) < 0);
    }

    @Test
    public void setAndGetPerson() throws Exception {
        //Given
        String firstName = "Alice";
        String lastName = "Bambi";
        String email = "ab@gmail.com";
        int id = 31;
        String country = "France";
        String ipAddress = "127.0.0.1";

        //If
        Person p1 = new Person();
        p1.setId(id);
        p1.setFirst_name(firstName);
        p1.setLast_name(lastName);
        p1.setEmail(email);
        p1.setCountry(country);
        p1.setIp_address(ipAddress);


        //Then
        assertTrue(p1.getCountry().equals(country));
        assertTrue(p1.getLast_name().equals(lastName));
        assertTrue(p1.getFirst_name().equals(firstName));
        assertTrue(p1.getEmail().equals(email));
        assertTrue(p1.getIp_address().equals(ipAddress));
    }

}