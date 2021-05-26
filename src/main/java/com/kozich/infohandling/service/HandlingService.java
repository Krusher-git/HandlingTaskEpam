package com.kozich.infohandling.service;

public interface HandlingService {
    String sortParagraph(String text);
    String deleteSmallerThan(int minWordsAmount, String text);
}
