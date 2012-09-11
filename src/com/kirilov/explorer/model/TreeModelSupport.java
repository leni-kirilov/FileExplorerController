package com.kirilov.explorer.model;

import java.util.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

public class TreeModelSupport {

    private List<EventListener> list = new ArrayList<>();

    public void addTreeModelListener(TreeModelListener listener) {
        if (listener != null && !list.contains(listener)) {
            list.add(listener);
        }
    }

    public void removeTreeModelListener(TreeModelListener listener) {
        if (listener != null) {
            list.remove(listener);
        }
    }

    public void fireTreeNodesChanged(TreeModelEvent e) {
        Iterator listeners = list.iterator();
        while (listeners.hasNext()) {
            TreeModelListener listener = (TreeModelListener) listeners.next();
            listener.treeNodesChanged(e);
        }
    }

    public void fireTreeNodesInserted(TreeModelEvent e) {
        Iterator listeners = list.iterator();
        while (listeners.hasNext()) {
            TreeModelListener listener = (TreeModelListener) listeners.next();
            listener.treeNodesInserted(e);
        }
    }

    public void fireTreeNodesRemoved(TreeModelEvent e) {
        Iterator listeners = list.iterator();
        while (listeners.hasNext()) {
            TreeModelListener listener = (TreeModelListener) listeners.next();
            listener.treeNodesRemoved(e);
        }
    }

    public void fireTreeStructureChanged(TreeModelEvent e) {
        Iterator listeners = list.iterator();
        while (listeners.hasNext()) {
            TreeModelListener listener = (TreeModelListener) listeners.next();
            listener.treeStructureChanged(e);
        }
    }
}
