package com.gpcoder.patterns.structural.composite;

public class FileLeaf implements FileComponent {

    private String name;
    private long size;

    public FileLeaf(String name, long size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showProperty() {
        System.out.println(String.format("- FileLeaf:\n + Name: %s\n + Size: %s", name, size));
    }

    @Override
    public long totalSize() {
        return size;
    }
}
