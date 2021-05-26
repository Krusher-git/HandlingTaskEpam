package com.kozich.infohandling.service.impl;

import com.kozich.infohandling.entity.TextComponent;
import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.impl.TextComposite;
import com.kozich.infohandling.parser.AbstractChainParser;
import com.kozich.infohandling.parser.impl.LexemeParser;
import com.kozich.infohandling.parser.impl.ParagraphParser;
import com.kozich.infohandling.parser.impl.SentenceParser;
import com.kozich.infohandling.parser.impl.SymbolParser;
import com.kozich.infohandling.service.HandlingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HandlingServiceImpl implements HandlingService {
    private final String VOWS_REGEXP = "[EYUIOAeyuioaУЕЫАОЭЯИЮуеыаоэяию]";
    private final String LETTERS_REGEXP = "[A-Za-zА-Яа-я]";

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
    public String findLettersAmount(String sentence) {
        AbstractChainParser parser = new SymbolParser();
        TextComponent textComponent = parser.parse(sentence);
        List<TextComponent> components = textComponent.getList();
        int vows = 0, consonants = 0;
        for (TextComponent component : components) {
            if (component.toString().matches(LETTERS_REGEXP)) {
                if (component.toString().matches(VOWS_REGEXP)) {
                    vows++;
                } else {
                    consonants++;
                }
            }
        }
        String answer = "In this sentence amount of: vows is " + vows + ", consonants is " + consonants + ".";
        return answer;
    }

    @Override
    public String findSentenceWithBiggestWord(String sentences) {
        AbstractChainParser parser = new SentenceParser();
        TextComponent textComponent = parser.parse(sentences);
        List<TextComponent> components = textComponent.getList();
        int biggestWordSize = 0;
        for (TextComponent component : components) {
            for (TextComponent insideComponent : component.getList()) {
                for (TextComponent deepInsideComponent : insideComponent.getList()) {
                    if (deepInsideComponent.getSize() > biggestWordSize) {
                        biggestWordSize = deepInsideComponent.getSize();
                    }
                }
            }
        }
        List<TextComponent> tempComponents = new ArrayList<>();
        for (TextComponent component : components) {
            for (TextComponent insideComponent : component.getList()) {
                for (TextComponent deepInsideComponent : insideComponent.getList()) {
                    if (deepInsideComponent.getSize() == biggestWordSize) {
                        tempComponents.add(component);
                    }
                }
            }
        }
        return tempComponents.toString();
    }

    @Override
    public String deleteSmallerThan(int minWordsAmount, String text) {
        AbstractChainParser parser = new SentenceParser();
        TextComponent textComponent = parser.parse(text);
        List<TextComponent> tempComponent = textComponent.getList();
        tempComponent.removeIf(component -> component.getSize() < minWordsAmount);
        return tempComponent.toString();
    }
}
