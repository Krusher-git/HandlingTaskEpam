package com.kozich.infohandling.service.impl;

import com.kozich.infohandling.service.HandlingService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HandlingServiceImplTest {
    private static HandlingService handlingService;
    private final static String FIND_LETTERS_SENTENCE = "Something to check";
    private final static String SENTENCE_DELETE_TEST = "Something to delete. SOUT is not an exit. Bamboozle for the foozle.";
    private final static String PARAGRAPHS_FOR_TEST = "    Adssfsdfsdf. Adffds?\n" +
            "    Dwqwewqe.";
    private final static String MAX_WORD_SENTENCES = "Something to check. And something not to check. A.";

    @BeforeTest
    void setUp() {
        handlingService = new HandlingServiceImpl();
    }

    @Test
    public void testFindLettersAmount() {
        String actual = handlingService.findLettersAmount(FIND_LETTERS_SENTENCE);
        String expected = "In this sentence amount of: vows is 5, consonants is 11.";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDeleteSmallerThan() {
        String actual = handlingService.deleteSmallerThan(4, SENTENCE_DELETE_TEST);
        String expected = "[ SOUT is not an exit,  Bamboozle for the foozle]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testSortParagraphTest() {
        String actual = handlingService.sortParagraph(PARAGRAPHS_FOR_TEST);
        String expected = "[   Dwqwewqe,    Adssfsdfsdf  Adffds]";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindSentenceWithBiggestWord() {
        String actual = handlingService.findSentenceWithBiggestWord(MAX_WORD_SENTENCES);
        String expected = "[ Something to check,  And something not to check]";
        Assert.assertEquals(actual, expected);
    }
}