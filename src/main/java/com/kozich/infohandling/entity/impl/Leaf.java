package com.kozich.infohandling.entity.impl;

import com.kozich.infohandling.entity.TextComponent;

public final class Leaf implements TextComponent {
    private final Character symbol;

    public Leaf(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public void operation() {

    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return symbol.toString();
    }
}
