package com.kozich.infohandling.parser.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;

public class WordParser extends AbstractChainParser {
    private final String WORD_REGEXP = "[^A-Za-zА-яа-я0-9]";

    public WordParser() {
        chainParser = new SymbolParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.WORD);
        String[] words = text.split(WORD_REGEXP);
        for (String word : words) {
            textComponent.add(chainParser.parse(word));
        }
        return textComponent;
    }
}
