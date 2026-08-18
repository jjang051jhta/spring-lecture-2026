package com.jjang051.sns.global.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UUIDRenameStrategy implements FileRenameStrategy {
    public String rename(String originalFilename) {
        //jfkdskfjlds.jpg
        //jfkdskfjlds_20260818160913235.jpg
        int dotIndex = originalFilename.lastIndexOf(".");
        String fileName = originalFilename.substring(0, dotIndex);
        String extension = originalFilename.substring(dotIndex + 1);
        String uuid = UUID.randomUUID().toString();
        return fileName + "_" + uuid + "." + extension;
    }
}
