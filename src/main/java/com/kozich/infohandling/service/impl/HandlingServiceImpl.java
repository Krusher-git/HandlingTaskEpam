package com.kozich.infohandling.service.impl;

import com.kozich.infohandling.parser.AbstractChainParser;
import com.kozich.infohandling.parser.impl.ParagraphParser;
import com.kozich.infohandling.service.HandlingService;

public class HandlingServiceImpl implements HandlingService {
    @Override
    public String sortParagraph(String text) {
        AbstractChainParser parser = new ParagraphParser();
        return null;
    }

    @Override
    public String deleteSmallerThan(int minWordsAmount, String text) {
        return null;
    }
}
