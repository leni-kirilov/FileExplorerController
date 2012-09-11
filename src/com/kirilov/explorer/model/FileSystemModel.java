package com.kirilov.explorer.model;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import javax.swing.tree.TreePath;

public class FileSystemModel extends AbstractTreeModel implements Serializable {

    private File rootFile;
    private FileFilter filter;

    public FileSystemModel() {
        this(System.getProperty("user.home"), new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
    }

    public FileSystemModel(String startPath) {
        this(startPath, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        });
    }

    public FileSystemModel(String startPath, FileFilter filter) {
        this.filter = filter;
        this.rootFile = new File(startPath);
    }

    @Override
    public Object getRoot() {
        return this.rootFile;
    }

    @Override
    public Object getChild(Object parent, int index) {
        File directory = (File) parent;
        File[] children = directory.listFiles(this.filter);
        return children[index];
    }

    @Override
    public int getChildCount(Object parent) {
        File fileSysEntity = (File) parent;
        if (fileSysEntity.isDirectory()) {
            File[] children = fileSysEntity.listFiles(this.filter);
            return children.length;
        } else {
            return 0;
        }
    }

    //TODO check to see why is not a Filter used . For example MyFileFilter.java
//    private boolean checkValidType(String fileName) {
//        boolean result = false;
//
//        if (fileName.endsWith(".jpg")
//                || fileName.endsWith(".pdf")
//                || fileName.endsWith(".bmp")
//                || fileName.endsWith(".png")) {
//            result = true;
//        }
//
//        return result;
//    }
    //TODO check why this is commented?
    @Override
    public boolean isLeaf(Object node) {
        File nod = (File) node;
//        if(nod.listFiles().length == 0 && nod.isDirectory()) return true;
//        return checkValidType(nod.getName()) && nod.isFile();1
        return nod.isFile();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        File directory = (File) parent;
        File fileSysEntity = (File) child;
        String[] children = directory.list();
        int result = -1;

        for (int i = 0; i < children.length; ++i) {
            if (fileSysEntity.getName().equals(children[i])) {
                result = i;
                break;
            }
        }
        return result;
    }
}