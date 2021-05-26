package com.kozich.infohandling.entity;

public interface TextComponent {

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    String getTypeName();

}
