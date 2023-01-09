package com.epam.mjc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while (reader.ready()){
                String[] strs = reader.readLine().split(" ");
                result.add(strs[1]);
            }
        }catch (IOException e) {
            System.out.println("Something went wrong");
        }

        String name = result.get(0);
        Integer age = Integer.parseInt(result.get(1));
        String email = result.get(2);
        Long phone = Long.parseLong(result.get(3));

        return  new Profile(name, age, email, phone);
    }
}
