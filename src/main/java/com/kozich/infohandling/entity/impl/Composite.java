package com.kozich.infohandling.entity.impl;

import com.kozich.infohandling.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TextComponent {
    private final List<TextComponent> textComponents = new ArrayList<>();


    @Override
    public void operation() {

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
        return textComponents.toString();
    }
}
