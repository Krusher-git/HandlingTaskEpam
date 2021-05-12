package com.kozich.infohandling.validator;

import java.io.File;

public class FileValidator {
    public static boolean isValidFile(String path) {
        File file = new File(path);
        return file.isFile() && file.exists();
    }
}
