package com.kozich.infohandling.service.impl;

import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;
import com.kozich.infohandling.parser.impl.ParagraphParser;
import com.kozich.infohandling.parser.impl.SentenceParser;
import com.kozich.infohandling.service.HandlingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public String findSentenceWithBiggestWord(String sentences) {
        AbstractChainParser parser = new SentenceParser();
        TextComponent textComponent = parser.parse(sentences);
        List<TextComponent> components = textComponent.getList();
        int biggestWordSize = 0;
        for (TextComponent component : components) {
            if (component.getTypeName().equals(TextComponentType.WORD.name())) {
                if (component.getSize() > biggestWordSize) {
                    biggestWordSize = component.getSize();
                }
            }
        }
        List<TextComponent> tempComponents = new ArrayList<>();
        int tempValue = 0;
        for (TextComponent component : components) {
            if (tempValue == 1 && component.getTypeName().equals(TextComponentType.SENTENCE.name())) {
                int sentenceIndex = components.indexOf(component) - 1;
                TextComponent tempComponent = components.get(sentenceIndex);
                tempComponents.add(tempComponent);
            }
            if (component.getTypeName().equals(TextComponentType.WORD.name())) {
                if (component.getSize() == biggestWordSize) {
                    tempValue = 1;
                }
            }
        }
        return tempComponents.toString();
    }

    @Override
    public String deleteSmallerThan(int minWordsAmount, String text) {
        AbstractChainParser parser = new ParagraphParser();
        TextComponent textComponent = parser.parse(text);
        List<TextComponent> tempComponent = textComponent.getList();
        int tempValue = 0; // Temporary value for foreach
        for (TextComponent component : tempComponent) {
            if (tempValue == 1 && component.getTypeName().equals(TextComponentType.SENTENCE.name())) {
                int sentenceIndex = tempComponent.indexOf(component) - 1;
                tempComponent.remove(sentenceIndex);
                // If previous sentence contains word smaller than minWordsAmount
            }
            if (component.getTypeName().equals(TextComponentType.WORD.name())) {
                if (component.getSize() < minWordsAmount) {
                    tempValue = 1;
                }
            }
        }
        return tempComponent.toString();
    }
}
