package com.kozich.infohandling.parser.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;

public class ParagraphParser extends AbstractChainParser {
    private final String PARAGRAPH_REGEXP = "\\n";

    public ParagraphParser() {
        chainParser = new SentenceParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.PARAGRAPH);
        String[] paragraphs = text.split(PARAGRAPH_REGEXP);
        for (String paragraph : paragraphs) {

            textComponent.add(chainParser.parse(paragraph));
        }
        return textComponent;
    }


}
