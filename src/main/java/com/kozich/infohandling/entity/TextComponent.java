package com.kozich.infohandling.entity;

import java.util.List;

public interface TextComponent {

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    String getTypeName();

    List<TextComponent> getList();

    int getSize();

}
