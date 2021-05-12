package com.kozich.infohandling.parser;

import com.kozich.infohandling.entity.TextComponent;

public interface ChainParser {
    TextComponent parse(String text);

    boolean hasNext();
}
