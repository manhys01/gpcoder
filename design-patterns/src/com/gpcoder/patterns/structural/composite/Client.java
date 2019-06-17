package com.gpcoder.patterns.structural.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        FileComponent file1 = new FileLeaf("File 1", 7);
        FileComponent file2 = new FileLeaf("File 2", 3);
        FileComponent file3 = new FileLeaf("File 3", 2);
        FileComponent file4 = new FileLeaf("File 4", 5);

        List<FileComponent> files = Arrays.asList(file1, file2, file3, file4);
        FileComponent folder = new FolderComposite(files);
        folder.showProperty();
        System.out.println("Total size: " + folder.totalSize());
    }
}
