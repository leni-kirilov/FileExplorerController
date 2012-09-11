package com.kirilov.explorer;

//import filechooser.DirectoryModel;
import com.kirilov.explorer.model.FileSystemTreePanel;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class FileExplorer {

    public static void main(String[] argv) {
        JFrame frame = new JFrame("File Explorer");

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        String startPath = "c:\\";

//        FileSystemModel model = new FileSystemModel(startPath);
        FileSystemTreePanel fileTree = new FileSystemTreePanel(startPath);

//        DirectoryModel directoryModel = new DirectoryModel(new File(startPath) );//(File)model.getRoot() );
//        JTable table = new JTable( directoryModel );
//        table.setShowHorizontalLines( false );
//        table.setShowVerticalLines( false );
//        table.setIntercellSpacing( new Dimension( 0, 2 ) );
//        table.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
//        table.getColumn( "Type" ).setCellRenderer( new DirectoryRenderer() );
//        table.getColumn( "Type" ).setMaxWidth( 32 );
//        table.getColumn( "Type" ).setMinWidth( 32 );

//        fileTree.getTree().addTreeSelectionListener( new TreeListener( directoryModel ) );

        JScrollPane treeScroller = new JScrollPane(fileTree);
        JScrollPane tableScroller = null;// JTable.createScrollPaneForTable( table );
//        treeScroller.setMinimumSize( new Dimension( 300, 0 ) );
//        tableScroller.setMinimumSize( new Dimension( 100, 0 ) );
//        tableScroller.setBackground( Color.white );
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                treeScroller,
                tableScroller);
        splitPane.setContinuousLayout(true);

        frame.getContentPane().add(splitPane);

        frame.setSize(1000, 500);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
//    protected static class TreeListener implements TreeSelectionListener {
//        DirectoryModel model;
//
//        public TreeListener( DirectoryModel mdl ) {
//            model = mdl;
//        }
//        public void valueChanged( TreeSelectionEvent e ) {
//            File fileSysEntity = (File)e.getPath().getLastPathComponent();
//            if ( fileSysEntity.isDirectory() ) {
//                model.setDirectory( fileSysEntity );
//            }
//            else {
//                model.setDirectory( null );
//            }
//        }
//    }
}
