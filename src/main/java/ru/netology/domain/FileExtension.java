package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileExtension implements Comparable<FileExtension> {
    private String extensionFile;

    @Override
    public int compareTo(FileExtension o) {
        return extensionFile.compareTo(o.extensionFile);
    }
}
