package com.kirilov.explorer.model;


import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Leni
 */
public class MyFileFilter implements FileFilter {

    public static FileFilter filter = new MyFileFilter();

    public boolean accept(File pathname) {
        String fileName = pathname.getName();
        boolean result = false;

        if (fileName.endsWith(".jpg")
                || fileName.endsWith(".pdf")
                || fileName.endsWith(".bmp")
                || fileName.endsWith(".png")
                || !fileName.contains(".")) {
            result = true;
        }

        return result;
    }
}
