package com.kozich.infohandling.entity.impl;

import com.kozich.infohandling.entity.TextComponentType;
import com.kozich.infohandling.entity.TextComponent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final Logger logger = LogManager.getLogger();
    private static final String LOG_INFO_MESSAGE = "The composite has already been created";
    private final List<TextComponent> textComponents = new ArrayList<>();
    private final TextComponentType type;


    public TextComposite(TextComponentType type) {
        logger.log(Level.INFO, LOG_INFO_MESSAGE);
        this.type = type;
    }

    @Override
    public List<TextComponent> getList() {
        List<TextComponent> copy = new ArrayList<>(textComponents);
        return copy;
    }

    @Override
    public int getSize() {
        return textComponents.size();
    }

    @Override
    public String getTypeName() {
        return type.name();
    }

    @Override
    public void add(TextComponent textComponent) {
        textComponents.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        textComponents.remove(textComponent);
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (TextComponent component : textComponents) {
            if (component.getTypeName().equals(TextComponentType.PARAGRAPH.name())) {
                text.append("   ").append(component.toString()).append("\n");
            } else if (component.getTypeName().equals(TextComponentType.SENTENCE.name())) {
                text.append(" ").append(component.toString());
            } else if (component.getTypeName().equals(TextComponentType.LEXEME.name()) || component.getTypeName().equals(TextComponentType.WORD.name())) {
                text.append(" ").append(component.toString());
            } else if (component.getTypeName().equals(TextComponentType.SYMBOL.name())) {
                text.append(component.toString());
            }
        }
        return text.toString();
    }
}
