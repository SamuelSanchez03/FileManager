package filemanager;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class Manager extends javax.swing.JFrame {
    public Manager() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileTree = new javax.swing.JTree();
        renameButton = new java.awt.Button();
        deleteButton = new java.awt.Button();
        newButton = new java.awt.Button();
        openButton = new java.awt.Button();
        sortButton = new java.awt.Button();
        filterButton = new java.awt.Button();
        closeButton = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        TreeModel model = new FileTreeModel();
        fileTree.setModel(model);
        //fileTree.setVisible(false);
        fileTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                fileTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(fileTree);

        renameButton.setEnabled(false);
        renameButton.setLabel("Rename");
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        deleteButton.setEnabled(false);
        deleteButton.setLabel("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        newButton.setEnabled(false);
        newButton.setLabel("New");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        openButton.setEnabled(false);
        openButton.setLabel("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        sortButton.setLabel("Sort");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        filterButton.setLabel("Filter");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        closeButton.setLabel("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(renameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(534, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(openButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filterButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(renameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_renameButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newButtonActionPerformed

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        int selectedRows = fileTree.getSelectionCount();
        if (selectedRows == 1)
        {
            String path = fileTree.getSelectionPath().getLastPathComponent().toString();
            System.out.println(path);
            try{
                java.awt.Desktop.getDesktop().open(new File(path));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "The file can't be found or doesn't exist",
               "File not found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_openButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sortButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeButtonActionPerformed

    //ActionListener for the fileChooser
    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            File selectedFile = fileChooser.getSelectedFile();
            TreeModel fileModel = new FileTreeModel(selectedFile);
            fileTree.setModel(fileModel);
            
            //This timer allows us to update the tree when a new file or directory is added to the tree
            Timer timer = new Timer(100, new java.awt.event.ActionListener(){
                int initChilds = fileTree.getModel().getChildCount(fileTree.getModel().getRoot());
                
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    File root = (File) fileTree.getModel().getRoot();
                    int currentChilds = fileTree.getModel().getChildCount((Object)root);
                    if (currentChilds != initChilds)
                    {
                        initChilds = currentChilds;
                        TreeModel model = new FileTreeModel(root);
                        fileTree.setModel(model);
                    }
                }
            });
            timer.start();
        
        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            fileTree.setModel(new FileTreeModel());
        }
    }//GEN-LAST:event_fileChooserActionPerformed

    private void fileTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_fileTreeValueChanged
        // TODO add your handling code here:
        TreePath[] paths = evt.getPaths();
        if(paths.length >= 1)
        {
            if(paths.length == 1)
            {
                renameButton.setEnabled(true);
                openButton.setEnabled(true);
                if (new File(paths[0].getLastPathComponent().toString()).isDirectory())
                    newButton.setEnabled(true);
            }
            deleteButton.setEnabled(true);
        }
        else
        {
            renameButton.setEnabled(false);
            openButton.setEnabled(false);
            newButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }//GEN-LAST:event_fileTreeValueChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }
    
    //FileTreeModel class allows us to use files in a JTree
    class FileTreeModel implements TreeModel{
        protected File root;
        public FileTreeModel (File root)
        {
            this.root = root;
        }
        
        public FileTreeModel ()
        {
            this.root = null;
        }

        @Override
        public Object getRoot() 
        {
            return root;
        }

        @Override
        public boolean isLeaf(Object node)
        {
            return ((File)node).isFile();
        }

        @Override
        public int getChildCount(Object parent)
        {
            if (root == null)
                return 0;
            String[] children = ((File)parent).list();
            if (children == null)
                return 0;
            return children.length;
        }

        @Override
        public Object getChild(Object parent, int index)
        {
            if (root == null)
                return null;
            String[] children = ((File)parent).list();
            if ((children == null) && (index >= children.length))
                return null;
            return new File((File) parent, children[index]);
        }

        @Override
        public int getIndexOfChild(Object parent, Object child)
        {
            if (root == null)
                return -1;
            String[] children = ((File) parent).list();
            if (children == null)
                return -1;
            String childname = ((File) child).getName();
            for(int i = 0; i < children.length; i++)
            {
                if (childname.equals(children[i]))
                    return i;
            }
            return -1;
        }

        @Override
        public void valueForPathChanged(TreePath path, Object newValue){}

        @Override
        public void addTreeModelListener(TreeModelListener l){}

        @Override
        public void removeTreeModelListener(TreeModelListener l){}
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button closeButton;
    private java.awt.Button deleteButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTree fileTree;
    private java.awt.Button filterButton;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Button newButton;
    private java.awt.Button openButton;
    private java.awt.Button renameButton;
    private java.awt.Button sortButton;
    // End of variables declaration//GEN-END:variables
}
