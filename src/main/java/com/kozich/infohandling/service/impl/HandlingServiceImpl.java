package com.kozich.infohandling.service.impl;

import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;
import com.kozich.infohandling.parser.impl.ParagraphParser;
import com.kozich.infohandling.service.HandlingService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HandlingServiceImpl implements HandlingService {
    @Override
    public String sortParagraph(String text) {
        AbstractChainParser parser = new ParagraphParser();
        TextComponent textComponent = parser.parse(text);
        List<TextComponent> sortedTextComponent = textComponent.getList()
                .stream()
                .sorted(Comparator.comparingInt(TextComponent::getSize))
                .collect(Collectors.toList());
        return sortedTextComponent.toString();
    }

    @Override
    public String deleteSmallerThan(int minWordsAmount, String text) {
        return null;
    }
}
