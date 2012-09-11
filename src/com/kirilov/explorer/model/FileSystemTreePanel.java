package com.kirilov.explorer.model;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;

public class FileSystemTreePanel extends JPanel {

    private JTree tree;

    public FileSystemTreePanel() {
        this(new FileSystemModel());
    }

    public FileSystemTreePanel(String startPath) {
        this(new FileSystemModel(startPath));
    }

    public FileSystemTreePanel(String startPath, FileFilter filter) {
        this(new FileSystemModel(startPath, filter));
    }

    public FileSystemTreePanel(FileSystemModel model) {
        tree = new JTree((TreeModel) model) {
            public String convertValueToText(Object value, boolean selected,
                    boolean expanded, boolean leaf, int row,
                    boolean hasFocus) {
                return ((File) value).getName();
            }
        };

        //tree.setLargeModel( true );
        tree.setRootVisible(false);
        tree.setShowsRootHandles(true);
        tree.putClientProperty("JTree.lineStyle", "Angled");

        setLayout(new BorderLayout());
        add(tree, BorderLayout.CENTER);
    }

    public JTree getTree() {
        return tree;
    }
}
