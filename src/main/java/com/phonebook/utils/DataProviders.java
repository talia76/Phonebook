package com.phonebook.utils;

import com.phonebook.models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new  Object[]{"Mary", "Poppins", "1234567890", "mary@pop.com", "London", "jnjbjjnkj"});
        list.add(new  Object[]{"Katy", "Perry", "1234567891", "katy@per.com", "Montecito", "jnjbjjnkj"});
        list.add(new  Object[]{"Selin", "Dion", "1234567892", "selin@dion.com", "Las-Vegas", "jnjbjjnkj"});
        list.add(new  Object[]{"Jennifer", "Lopez", "1234567893", "jenn@lo.com", "Los-Angeles", "jnjbjjnkj"});
        return list.iterator();
    }
    @DataProvider
    public Iterator <Object[]> addNewContactFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));

        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new Contact().setName(split[0]).setLastname(split[1]).setPhone(split[2])
                    .setEmail(split[3]).setAddress(split[4]).setDescription(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
