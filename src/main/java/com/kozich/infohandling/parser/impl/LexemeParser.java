package com.kozich.infohandling.parser.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;

public class LexemeParser extends AbstractChainParser {
    private final String LEXEME_REGEXP = "\\s+";
    private final String SYMBOL_REGEXP = "[-!=,+\\(\\)“”]?[A-Za-zА-яа-я0-9]?[-!=,+\\(\\)“”]";

    public LexemeParser() {
        chainParser = new WordParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent textComponent = new TextComposite(TextComponentType.LEXEME);
        String[] lexemes = text.split(LEXEME_REGEXP);
        AbstractChainParser symbolParser = new SymbolParser();
        for (String lexeme : lexemes) {
            if (lexeme.matches(SYMBOL_REGEXP)) {
                textComponent.add(symbolParser.parse(lexeme));
            } else {
                textComponent.add(chainParser.parse(lexeme));
            }
        }
        return textComponent;
    }
}
