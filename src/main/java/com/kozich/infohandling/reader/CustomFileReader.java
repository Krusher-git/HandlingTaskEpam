package com.kozich.infohandling.reader;

import com.kozich.infohandling.exception.HandlingException;
import com.kozich.infohandling.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomFileReader {
    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_EXCEPTION_MESSAGE = "Exception with file";
    private static final String FILE_EMPTY_EXCEPTION_MESSAGE = "The text was not found in the file";
    private static final String FILE_VALID_MESSAGE = "File is not valid";

    public String readFile(String path) throws HandlingException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL temp = loader.getResource(path);
        assert temp != null;
        Path filePath = Path.of(new File(temp.getFile()).getAbsolutePath());
        if (!FileValidator.isValidFile(filePath.toString())) {
            logger.log(Level.ERROR, FILE_VALID_MESSAGE);
            throw new HandlingException(FILE_VALID_MESSAGE);
        }
        String fileContent;
        try {
            fileContent = Files.readString(filePath);
        } catch (IOException e) {
            logger.log(Level.ERROR, FILE_EXCEPTION_MESSAGE);
            throw new HandlingException(FILE_EXCEPTION_MESSAGE, e);
        }
        if (fileContent.isBlank()) {
            logger.log(Level.ERROR, FILE_EMPTY_EXCEPTION_MESSAGE);
            throw new HandlingException(FILE_EMPTY_EXCEPTION_MESSAGE);
        }
        return fileContent;
    }
}
