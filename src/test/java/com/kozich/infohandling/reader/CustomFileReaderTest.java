package com.kozich.infohandling.reader;

import com.kozich.infohandling.exception.HandlingException;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomFileReaderTest {
    private final static String FILE_PATH = "data/test_text.txt";
    private final static String EXPECTED = "    It";

    @Test
    public void testReadFile() throws HandlingException {
        CustomFileReader customFileReader = new CustomFileReader();
        String actual = customFileReader.readFile(FILE_PATH).substring(0, 6);
        assertEquals(EXPECTED, actual);
    }
}