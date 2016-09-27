package com.paulwoodiii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by paul on 9/26/16.
 */
public class CountryPeopleParser {
    public static HashMap<String, ArrayList<Person>> parse(String input){
        ArrayList<Person> people = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(input);

            //Skip First Line of a CSV;
            fileScanner.nextLine();
            //Continue

            int i = 0;
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] elements = line.split(",");
                i++;
                if (elements.length != 6) {

                    throw new Exception("Parse Error at line" + i);
                }
                int personId = Integer.valueOf(elements[0]);
                Person c = new Person(personId,elements[1],elements[2],elements[3],elements[4],elements[5]);
                people.add(c);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        HashMap<String, ArrayList<Person>> peopleByCountry = CountryPeopleParser.map(people);
        CountryPeopleParser.sort(peopleByCountry);
        return peopleByCountry;
    }

    private static HashMap<String, ArrayList<Person>> map( ArrayList<Person> people){
        HashMap<String, ArrayList<Person>> hash = new HashMap<String, ArrayList<Person>>();
        for (Person p : people){
            ArrayList<Person> thesePeople = null;
            thesePeople = hash.get(p.country);
            if (thesePeople == null){
                thesePeople = new ArrayList<Person>();
                hash.put(p.country, thesePeople);
            }
            thesePeople.add(p);
        }
        return hash;
    }

    private static HashMap<String, ArrayList<Person>> sort(HashMap<String, ArrayList<Person>> input){

        for (String keyString : input.keySet()){
            ArrayList<Person> peoples = input.get(keyString);
            Collections.sort(peoples);
        }
        return input;
    }

}
