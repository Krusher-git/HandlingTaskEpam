package com.kozich.infohandling.service;

public interface HandlingService {
    String sortParagraph(String text);
    String deleteSmallerThan(int minWordsAmount, String text);
    String findSentenceWithBiggestWord (String sentences);
    String findLettersAmount (String sentence);
}
