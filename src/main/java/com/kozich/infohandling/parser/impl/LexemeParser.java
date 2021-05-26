package com.kozich.infohandling.parser.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;

public class LexemeParser extends AbstractChainParser {
    private final String LEXEME_REGEXP = "\\s+";
    private final String SYMBOL_REGEXP = "[-!=+,\\(\\)“”]";

    public LexemeParser() {
        chainParser = new WordParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.LEXEME);
        String[] lexemes = text.split(LEXEME_REGEXP);
        AbstractChainParser symbolParser = new SymbolParser();
        for (String lexeme : lexemes) {

            textComponent.add(chainParser.parse(lexeme));
        }
        return textComponent;
    }
}
