package com.kozich.infohandling.parser;

import com.kozich.infohandling.entity.TextComponent;

public abstract class AbstractChainParser {
    protected AbstractChainParser chainParser = null;

    public abstract TextComponent parse(String text);

    public boolean hasNext() {
        return chainParser != null;
    }

    public void removeNextParser() {
        chainParser = null;
    }
}
