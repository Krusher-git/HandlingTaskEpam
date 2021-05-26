package com.kozich.infohandling.entity.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TextLeaf implements TextComponent {

    private static final Logger logger = LogManager.getLogger();
    private static final String LOG_INFO_MESSAGE = "The leaf has already been created";
    private static final String LOG_ERROR_MESSAGE = "The leaf is not created";
    private final Character symbol;
    private final TextComponentType type = TextComponentType.SYMBOL;

    public TextLeaf(Character symbol) {

        this.symbol = symbol;
        logger.log(Level.INFO, LOG_INFO_MESSAGE);
    }

    @Override
    public String getTypeName() {
        return type.name();
    }



    @Override
    public void add(TextComponent textComponent) {
        logger.log(Level.ERROR, LOG_ERROR_MESSAGE);
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent textComponent) {
        logger.log(Level.ERROR, LOG_ERROR_MESSAGE);
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return symbol.toString();
    }
}
