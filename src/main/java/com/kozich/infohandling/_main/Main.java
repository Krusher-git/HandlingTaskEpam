package com.kozich.infohandling._main;

import com.kozich.infohandling.exception.HandlingException;
import com.kozich.infohandling.reader.CustomFileReader;


public class Main {
    public static void main(String[] args) {
        CustomFileReader fileReader = new CustomFileReader();
        try {
            String gg = fileReader.readFile("data/text.txt");
            System.out.println(gg);
        } catch (HandlingException e) {
            e.printStackTrace();
        }

    }
}
