package com.paulwoodiii;

import java.io.Serializable;

/**
 * Created by paul on 9/26/16.
 */
public class Person implements Serializable, Comparable {
    int id;
    String first_name;
    String last_name;
    String email;
    String country;
    String ip_address;

    public Person() {}

    public Person(int id, String first_name, String last_name, String email, String country, String ip_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.country = country;
        this.ip_address = ip_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    @Override
    public String toString() {
        return String.format("%s %s from %s", first_name, last_name, country);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getId() != person.getId()) return false;
        if (!getFirst_name().equals(person.getFirst_name())) return false;
        if (!getLast_name().equals(person.getLast_name())) return false;
        return getEmail().equals(person.getEmail());

    }

    public int compareTo(Object o){
        Person p = (Person) o;
        String p1 = String.format("%s%s%s", last_name, first_name, country);
        String p2 = String.format("%s%s%s", p.last_name, p.first_name, p.country);
        return p1.compareTo(p2);
    }
}
