package com.kozich.infohandling.parser.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;

public class SentenceParser extends AbstractChainParser {

    private final String SENTENCE_REGEXP = "[.|?|!|...]\\s";


    public SentenceParser() {
        chainParser = new LexemeParser();
    }

    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] sentences = text.split(SENTENCE_REGEXP);
        for (String sentence : sentences) {
            textComponent.add(chainParser.parse(sentence));
        }
        return textComponent;
    }


}
