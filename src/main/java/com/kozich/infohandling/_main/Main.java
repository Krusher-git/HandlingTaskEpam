package com.kozich.infohandling._main;

import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.exception.HandlingException;
import com.kozich.infohandling.parser.AbstractChainParser;
import com.kozich.infohandling.parser.impl.ParagraphParser;
import com.kozich.infohandling.reader.CustomFileReader;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws HandlingException {
        AbstractChainParser chainParser = new ParagraphParser();
        System.out.println(chainParser.hasNext());
        CustomFileReader customFileReader = new CustomFileReader();
        String ad = customFileReader.readFile("data/text.txt");
        TextComponent textComponent = chainParser.parse(ad);
        System.out.println(textComponent.toString());

    }
}
