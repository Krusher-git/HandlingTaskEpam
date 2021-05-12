package com.kozich.infohandling.reader;

import com.kozich.infohandling.exception.HandlingException;
import com.kozich.infohandling.validator.FileValidator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomFileReader {
    private static final String FILE_EXCEPTION_MESSAGE = "Exception with file";
    private static final String FILE_EMPTY_EXCEPTION_MESSAGE = "The text was not found in the file";
    private static final String FILE_VALID_MESSAGE = "File is not valid";

    public String readFile(String path) throws HandlingException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        URL temp = loader.getResource(path);
        assert temp != null;
        Path filePath = Path.of(new File(temp.getFile()).getAbsolutePath());
        if (!FileValidator.isValidFile(filePath.toString())) {
            throw new HandlingException(FILE_VALID_MESSAGE);
        }
        String fileContent;
        try {
            fileContent = Files.readString(filePath);
        } catch (IOException e) {
            throw new HandlingException(FILE_EXCEPTION_MESSAGE, e);
        }
        if (fileContent.isBlank()) {
            throw new HandlingException(FILE_EMPTY_EXCEPTION_MESSAGE);
        }
        return fileContent;
    }
}
