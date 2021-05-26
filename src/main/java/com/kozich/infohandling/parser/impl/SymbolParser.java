package com.kozich.infohandling.parser.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.entity.impl.TextLeaf;
import com.kozich.infohandling.parser.AbstractChainParser;

public class SymbolParser extends AbstractChainParser {

    @Override
    public TextComponent parse(String text) {
        char[] symbols = text.toCharArray();
        TextComponent textComponent = new TextComposite(TextComponentType.SYMBOL);
        for (char symbol : symbols) {
            textComponent.add(new TextLeaf(symbol));
        }
        return textComponent;
    }
}
