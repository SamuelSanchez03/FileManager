package filemanager;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.WindowEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.event.TreeModelListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.apache.commons.io.FilenameUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Color;
import javax.swing.text.html.HTMLEditorKit;

public class Manager extends javax.swing.JFrame {
    public Manager() {
        initComponents();
        this.setBackground(java.awt.Color.BLACK);
        this.setLocationRelativeTo(null);
        //this.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fileTree = new javax.swing.JTree();
        fileChooser = new JFileChooserArqs();
        renameButton = new java.awt.Button();
        newButton = new java.awt.Button();
        deleteButton = new java.awt.Button();
        openButton = new java.awt.Button();
        filterButton = new java.awt.Button();
        compressButton = new java.awt.Button();
        attributesPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        accessedLabel = new javax.swing.JLabel();
        modifiedLabel = new javax.swing.JLabel();
        createdLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        permissionsLabel = new javax.swing.JLabel();
        ownerLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        othersLabel = new javax.swing.JLabel();
        pathLabel = new javax.swing.JLabel();
        copyPathButton = new java.awt.Button();
        terminalButton = new java.awt.Button();
        chartButton = new java.awt.Button();
        clearFilterButton = new java.awt.Button();
        chartButton1 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH

        );
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(200, 500));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1574, 888));

        jScrollPane1.setBorder(null);

        TreeModel model = new FileTreeModel();
        fileTree.setCellRenderer(new FileTreeCellRenderer());
        //filterModel = new FilteredTreeModel(model);
        fileTree.setModel(model);

        //fileTree.setVisible(false);
        fileTree.setBackground(new java.awt.Color(255, 255, 255));
        fileTree.setBorder(null);
        fileTree.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        fileTree.setMaximumSize(new java.awt.Dimension(78, 482));
        fileTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileTreeMouseClicked(evt);
            }
        });
        fileTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                fileTreeValueChanged(evt);
            }
        });
        fileTree.addMouseListener(new PopClickListener());
        jScrollPane1.setViewportView(fileTree);

        fileChooser.setBackground(new java.awt.Color(0, 0, 0));
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setFont(new java.awt.Font("DejaVu Sans", 0, 36)); // NOI18N
        fileChooser.setForeground(new java.awt.Color(255, 51, 51));
        fileChooser.setBorder(null);
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        renameButton.setEnabled(false);
        renameButton.setLabel("Rename");
        renameButton.setVisible(false);
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        newButton.setEnabled(false);
        newButton.setLabel("New Folder");
        newButton.setVisible(false);
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        deleteButton.setEnabled(false);
        deleteButton.setLabel("Delete");
        deleteButton.setVisible(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        openButton.setEnabled(false);
        openButton.setLabel("Open");
        openButton.setVisible(false);
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        filterButton.setLabel("Filter");
        filterButton.setVisible(false);
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        compressButton.setLabel("Compress (files only)");
        compressButton.setVisible(false);
        compressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressButtonActionPerformed(evt);
            }
        });

        attributesPanel.setBackground(new java.awt.Color(51, 51, 51));
        attributesPanel.setMinimumSize(new java.awt.Dimension(137, 196));
        attributesPanel.setPreferredSize(new java.awt.Dimension(600, 384));

        nameLabel.setBackground(new java.awt.Color(0, 0, 0));
        nameLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(169, 135, 255));
        nameLabel.setText("Name:");

        accessedLabel.setBackground(new java.awt.Color(0, 0, 0));
        accessedLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        accessedLabel.setForeground(new java.awt.Color(169, 135, 255));
        accessedLabel.setText("Accessed:");

        modifiedLabel.setBackground(new java.awt.Color(0, 0, 0));
        modifiedLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        modifiedLabel.setForeground(new java.awt.Color(169, 135, 255));
        modifiedLabel.setText("Modified:");

        createdLabel.setBackground(new java.awt.Color(0, 0, 0));
        createdLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        createdLabel.setForeground(new java.awt.Color(169, 135, 255));
        createdLabel.setText("Created:");

        sizeLabel.setBackground(new java.awt.Color(0, 0, 0));
        sizeLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        sizeLabel.setForeground(new java.awt.Color(169, 135, 255));
        sizeLabel.setText("Size:");

        typeLabel.setBackground(new java.awt.Color(0, 0, 0));
        typeLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        typeLabel.setForeground(new java.awt.Color(169, 135, 255));
        typeLabel.setText("Type:");

        permissionsLabel.setBackground(new java.awt.Color(0, 0, 0));
        permissionsLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        permissionsLabel.setForeground(new java.awt.Color(169, 135, 255));
        permissionsLabel.setText("Permissions:");

        ownerLabel.setBackground(new java.awt.Color(0, 0, 0));
        ownerLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        ownerLabel.setForeground(new java.awt.Color(169, 231, 255));
        ownerLabel.setText("Owner:");

        groupLabel.setBackground(new java.awt.Color(0, 0, 0));
        groupLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        groupLabel.setForeground(new java.awt.Color(222, 84, 166));
        groupLabel.setText("Group:");

        othersLabel.setBackground(new java.awt.Color(0, 0, 0));
        othersLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        othersLabel.setForeground(new java.awt.Color(153, 228, 153));
        othersLabel.setText("Others:");

        pathLabel.setBackground(new java.awt.Color(0, 0, 0));
        pathLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        pathLabel.setForeground(new java.awt.Color(169, 135, 255));
        pathLabel.setText("Path:");
        pathLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout attributesPanelLayout = new javax.swing.GroupLayout(attributesPanel);
        attributesPanel.setLayout(attributesPanelLayout);
        attributesPanelLayout.setHorizontalGroup(
            attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attributesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attributesPanelLayout.createSequentialGroup()
                        .addGroup(attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, attributesPanelLayout.createSequentialGroup()
                                .addComponent(permissionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(othersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(groupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ownerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(sizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, attributesPanelLayout.createSequentialGroup()
                                .addGroup(attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(modifiedLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(accessedLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(createdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        attributesPanelLayout.setVerticalGroup(
            attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attributesPanelLayout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(accessedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifiedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(createdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(attributesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(permissionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ownerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(othersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        copyPathButton.setLabel("Copy as Path");
        copyPathButton.setVisible(false);
        copyPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyPathButtonActionPerformed(evt);
            }
        });

        terminalButton.setActionCommand("Open in terminal");
        terminalButton.setLabel("Open in terminal");
        terminalButton.setVisible(false);
        terminalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminalButtonActionPerformed(evt);
            }
        });

        chartButton.setActionCommand("Open in terminal");
        chartButton.setLabel("File Size Chart");
        chartButton.setVisible(false);
        chartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartButtonActionPerformed(evt);
            }
        });

        clearFilterButton.setActionCommand("Open in terminal");
        clearFilterButton.setLabel("Clear Filter");
        clearFilterButton.setVisible(false);
        clearFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterButtonActionPerformed(evt);
            }
        });

        chartButton1.setActionCommand("Open in terminal");
        chartButton1.setLabel("File Type Chart");
        chartButton1.setVisible(false);
        chartButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(renameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(compressButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chartButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(attributesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(1207, 1207, 1207)
                        .addComponent(compressButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(copyPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(terminalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(chartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(chartButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(renameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(16, 16, 16)
                                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(attributesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(55, 55, 55)
                .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1428, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Listener to rename file through a input dialog
    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        int selectedRows = fileTree.getSelectionCount();
        if (selectedRows == 1)
        {
            try
            {
                File selectedFile = new File(fileTree.getLastSelectedPathComponent().toString());
                String newName = JOptionPane.showInputDialog(fileTree, null, "New Name:", JOptionPane.PLAIN_MESSAGE);
                String newPath = selectedFile.getAbsolutePath().replace(selectedFile.getName(), newName);
                selectedFile.renameTo(new File(newPath));
                updateTree();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, "The file can't be open or can't be created",
               "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_renameButtonActionPerformed

    //Listener to delete the selected files
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        TreePath[] selectedFiles = fileTree.getSelectionPaths();
        File currentFile;
        for (int i = 0; i < selectedFiles.length; i++)
        {
            try
            {
                currentFile = new File(selectedFiles[i].getLastPathComponent().toString());
                currentFile.delete();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, "The file can't be deleted or doesn't exist",
               "Error deleting", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    //Listener to create a new folder wether in the selected folder or containing the selected files
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        int selectedRows = fileTree.getSelectionCount();
        int[] indexes = fileTree.getSelectionRows();
        String newDirectoryName = JOptionPane.showInputDialog(fileTree, null, "New Directory Name:", JOptionPane.PLAIN_MESSAGE);
        try
        {
            switch (selectedRows) {
                case 0 ->                     {
                        File root = (File)fileTree.getModel().getRoot();
                        File newDirectory = new File(root.getAbsolutePath() + "/" + newDirectoryName);
                        newDirectory.mkdir();
                    }
                case 1 ->                     {
                        File selectedDirectory = new File(fileTree.getLastSelectedPathComponent().toString());
                        File newDirectory = new File(selectedDirectory.getAbsolutePath() + "/" + newDirectoryName);
                        newDirectory.mkdir();
                    }
                default -> {
                        TreePath[] filesPaths = fileTree.getSelectionPaths();
                        String directoryPath = ((File)fileTree.getModel().getRoot()).getAbsolutePath();
                        int maxHierarchy = 1000000000;
                        for(int x : indexes)
                        {
                            TreePath currentPath = fileTree.getPathForRow(x).getParentPath();
                            System.out.println(currentPath.getPath().length);
                            if(currentPath.getPath().length < maxHierarchy)
                                directoryPath = currentPath.getLastPathComponent().toString();
                            System.out.println(directoryPath);
                        }
                        File newDirectory = new File(directoryPath + "/" + newDirectoryName);
                        newDirectory.mkdir();
                        for (TreePath tp: filesPaths)
                        {
                            String sourcePath = tp.getLastPathComponent().toString();
                            File sourceFile = new File(sourcePath);
                            sourceFile.renameTo(new File(newDirectory.getAbsolutePath() + "/" + sourceFile.getName()));
                        }
                    }
            }
            updateTree();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "The file can't be open or can't be created",
           "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_newButtonActionPerformed
    
    //Listener to open the file
    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        int selectedRows = fileTree.getSelectionCount();
        if (selectedRows == 1)
        {
            String path = fileTree.getSelectionPath().getLastPathComponent().toString();
            try{
                java.awt.Desktop.getDesktop().open(new File(path));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this, "The file can't be found or doesn't exist",
               "File not found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_openButtonActionPerformed
    
    //Listener to filter the files in the tree
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        String filter = JOptionPane.showInputDialog(fileTree, null, "Extension to filter:", JOptionPane.PLAIN_MESSAGE);
        filterModel.setFilter(filter);
        updateTree();     
    }//GEN-LAST:event_filterButtonActionPerformed
    
    //Function to get a PieDataset with the size of the files inside the directory
    public DefaultPieDataset getDataSetBySize(File file) {
        DefaultPieDataset dps = new DefaultPieDataset();
        try
        {
            File[] listOfFiles = file.listFiles();
            BasicFileAttributes attr;
            String name;
            long value;
            for (File f : listOfFiles) 
            {
                name = f.isDirectory() ? f.getName() + "(Dir)" : f.getName();
                attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                value = attr.size();
                dps.setValue(name, value);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "The file can't be found or doesn't exist",
               "File not found", JOptionPane.ERROR_MESSAGE);
        }
        return dps;
    }
    
    //Function to geet a PieDataSet with the type of the files inside the directory
    public DefaultPieDataset getDataSetByType(File file) {
        DefaultPieDataset dps = new DefaultPieDataset();
        Map<String, Integer> types = new HashMap<String, Integer>();
        try
        {
            File[] listOfFiles = file.listFiles();
            BasicFileAttributes attr;
            String type;
            int value;
            for (File f : listOfFiles) 
            {
                attr = Files.readAttributes(Paths.get(f.getPath()), BasicFileAttributes.class);
                type = f.isDirectory() ? "Directory" : FilenameUtils.getExtension(f.getPath());
                type = type.equals("") ? "Others" : type;
                if (types.containsKey(type))
                {
                    value = types.get(type);
                    types.put(type, value + 1);
                }
                else
                {
                    types.put(type, 1);
                }
            }
            for (Map.Entry<String, Integer> entry : types.entrySet()) 
            {
                type = entry.getKey();
                value = entry.getValue();
                dps.setValue(type, value);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "The file can't be found or doesn't exist",
               "File not found", JOptionPane.ERROR_MESSAGE);
        }
        return dps;
    }
                                             
    //ActionListener for the fileChooser
    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            File selectedFile = fileChooser.getSelectedFile();
            TreeModel fileModel = new FileTreeModel(selectedFile);
            filterModel = new FilteredTreeModel(fileModel);
            fileTree.setModel(filterModel);
            fileTree.clearSelection();
            
            //This timer allows us to update the tree when a new file or directory is added to the tree
            Timer timer = new Timer(100, new java.awt.event.ActionListener(){
                int initChilds = fileTree.getModel().getChildCount(fileTree.getModel().getRoot());
                
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e)
                {
                    File root = (File) fileTree.getModel().getRoot();
                    try{
                        int currentChilds = fileTree.getModel().getChildCount((Object)root);
                        if (currentChilds != initChilds)
                        {
                            initChilds = currentChilds;
                            updateTree();
                            if (cfSize.isVisible())
                                updateSizeChart();
                            if (cfType.isVisible())
                                updateTypeChart();
                        }
                    }catch(ArrayIndexOutOfBoundsException ex){
                        updateTree();
                    }
                }
            });
            timer.start();
        
        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            fileTree.setModel(new FileTreeModel());
            clearLabels();
        }
    }//GEN-LAST:event_fileChooserActionPerformed

    //Function to update de Size Pie Chart
    private void updateSizeChart()
    {
        cfSize.dispatchEvent(new WindowEvent(cfSize, WindowEvent.WINDOW_CLOSING));
        DefaultPieDataset dps = getDataSetBySize(lastSelectedFileSize);
        JFreeChart chart = ChartFactory.createPieChart("Size distribution", dps, true, true, true);
        PiePlot P = (PiePlot)chart.getPlot();
        cfSize = new ChartFrame(lastSelectedFileSize.getName(), chart);
        cfSize.setVisible(true);
        cfSize.setSize(800, 800);
    }
    
    //Function to update de Type Pie Chart
    private void updateTypeChart()
    {
        cfType.dispatchEvent(new WindowEvent(cfType, WindowEvent.WINDOW_CLOSING));
        DefaultPieDataset dps = getDataSetBySize(lastSelectedFileType);
        JFreeChart chart = ChartFactory.createPieChart("Size distribution", dps, true, true, true);
        PiePlot P = (PiePlot)chart.getPlot();
        cfType = new ChartFrame(lastSelectedFileType.getName(), chart);
        cfType.setVisible(true);
        cfType.setSize(800, 800);
    }
    
    //Listener for row selection
    //According to the number of rows selected, some buttons will be disabled
    private void fileTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_fileTreeValueChanged
        int nSelRows = fileTree.getSelectionCount();
        if(nSelRows == 1)
        {
            renameButton.setEnabled(true);
            openButton.setEnabled(true);
            deleteButton.setEnabled(true);
            copyPathButton.setEnabled(true);
            compressButton.setEnabled(true);
            File selectedFile = new File(fileTree.getLastSelectedPathComponent().toString());
            showAttributes(selectedFile);
            if(selectedFile.isDirectory())
            {
                newButton.setEnabled(true);
                terminalButton.setEnabled(true);
                chartButton.setEnabled(true);
                chartButton1.setEnabled(true);
            }
            else
            {
                newButton.setEnabled(false);
                terminalButton.setEnabled(false);
                chartButton.setEnabled(false);
                chartButton1.setEnabled(false);
            }
        }
        else if (nSelRows > 1)
        {
            renameButton.setEnabled(false);
            openButton.setEnabled(false);
            newButton.setEnabled(true);
            deleteButton.setEnabled(true);
            copyPathButton.setEnabled(false);
            compressButton.setEnabled(true);
            terminalButton.setEnabled(false);
            chartButton.setEnabled(false);
            chartButton1.setEnabled(false);
        }
        else
        {
            renameButton.setEnabled(false);
            openButton.setEnabled(false);
            newButton.setEnabled(true);
            deleteButton.setEnabled(false);
            copyPathButton.setEnabled(false);
            compressButton.setEnabled(false);
            terminalButton.setEnabled(false);
            chartButton.setEnabled(false);
            chartButton1.setEnabled(false);
        }
    }//GEN-LAST:event_fileTreeValueChanged

    //Listener to compress the selected files
    private void compressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressButtonActionPerformed
        TreePath[] selectionPaths = fileTree.getSelectionPaths();
        int[] indexes = fileTree.getSelectionRows();
        List<String> filePaths = new ArrayList<String>();
        String directoryPath = ((File)fileTree.getModel().getRoot()).getAbsolutePath();
        int maxHierarchy = 1000000000;
        for(int x : indexes)
        {
            TreePath currentPath = fileTree.getPathForRow(x).getParentPath();
            System.out.println(currentPath.getPath().length);
            if(currentPath.getPath().length < maxHierarchy)
                directoryPath = currentPath.getLastPathComponent().toString();
        }
        for(TreePath tp : selectionPaths)
        {
            filePaths.add(tp.getLastPathComponent().toString());
        }
        String zipName = JOptionPane.showInputDialog(fileTree, null, "Compress File Name:", JOptionPane.PLAIN_MESSAGE);
        zipName = zipName.contains(".zip") ? zipName = zipName : zipName.concat(".zip");
        zipFiles(filePaths, directoryPath + "/" + zipName);
    }//GEN-LAST:event_compressButtonActionPerformed

    //Function to compress files
    public void zipFiles(List<String> files, String zipName)
    {
        FileOutputStream fos;
        ZipOutputStream zipOut;
        FileInputStream fis;
        try 
        {
            fos = new FileOutputStream(zipName);
            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
            for(String filePath:files){
                File input = new File(filePath);
                fis = new FileInputStream(input);
                ZipEntry ze = new ZipEntry(input.getName());
                zipOut.putNextEntry(ze);
                byte[] tmp = new byte[4*1024];
                int size = 0;
                while((size = fis.read(tmp)) != -1){
                    zipOut.write(tmp, 0, size);
                }
                zipOut.flush();
                fis.close();
            }
            zipOut.close();
            JOptionPane.showMessageDialog(this, "The files have been compressed",
               "Completed", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Done... Zipped the files...");
        }
        catch(Exception e)
        {
             JOptionPane.showMessageDialog(this, "Couldn't compress the file(s)",
               "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Listener to copy the path of the selected file
    private void copyPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyPathButtonActionPerformed
        int selectedRows = fileTree.getSelectionCount();
        if (selectedRows == 1)
        {
            String path = fileTree.getSelectionPath().getLastPathComponent().toString();
            Transferable pathSelected = new StringSelection(path);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(pathSelected, null);
        }
    }//GEN-LAST:event_copyPathButtonActionPerformed

    //Listener to open a folder in the terminal
    private void terminalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminalButtonActionPerformed
        try {
            String command = "/usr/bin/gnome-terminal"; 
            String directory = fileTree.getLastSelectedPathComponent().toString();
            File workDirectory = new File(directory);
            System.out.println(workDirectory.getAbsolutePath());
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command, null, workDirectory);
            //Process pr = rt.exec(command);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "The directory can't be open or doesn't exist",
               "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_terminalButtonActionPerformed

    //Listener to clear selection when the mouse is clicked outside the tree
    private void fileTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileTreeMouseClicked
        if(fileTree.getRowForLocation(evt.getX(), evt.getY()) == -1)
            clearLabels();
    }//GEN-LAST:event_fileTreeMouseClicked

    private void clearLabels()
    {
        fileTree.clearSelection();
        accessedLabel.setText("Accessed: " );
        modifiedLabel.setText("Modified: " );
        createdLabel.setText("Created: ");
        sizeLabel.setText("Size: ");
        typeLabel.setText("Type: " );
        ownerLabel.setText("Owner: ");
        groupLabel.setText("Group: ");
        othersLabel.setText("Others");
        pathLabel.setText("Path: ");
    }
    //Listener to show a PieChart with the size distribution inside a folder
    private void chartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartButtonActionPerformed
    try {
            File selectedFile = new File(fileTree.getLastSelectedPathComponent().toString());
            lastSelectedFileSize = selectedFile;
            DefaultPieDataset dps = getDataSetBySize(selectedFile);
            JFreeChart chart = ChartFactory.createPieChart("Size distribution", dps, true, true, true);
            PiePlot P = (PiePlot) chart.getPlot();
            ChartFrame cfSize = new ChartFrame(selectedFile.getName(), chart);
            cfSize.getChartPanel().setBackground(Color.BLACK); // Set background color
            cfSize.setVisible(true);
            cfSize.setSize(800, 800);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "The directory can't be open or doesn't exist",
                    "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_chartButtonActionPerformed

    //Listener to clear filters
    private void clearFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterButtonActionPerformed
        filterModel.setFilter("");
        updateTree();
    }//GEN-LAST:event_clearFilterButtonActionPerformed

    //Listener to show a PieChart with the type distribution inside a folder
    private void chartButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chartButton1ActionPerformed
        try{
            File selectedFile = new File(fileTree.getLastSelectedPathComponent().toString());
            lastSelectedFileType = selectedFile;
            DefaultPieDataset dps = getDataSetByType(selectedFile);
            JFreeChart chart = ChartFactory.createPieChart("Type distribution", dps, true, true, true);
            PiePlot P = (PiePlot)chart.getPlot();
            cfType = new ChartFrame(selectedFile.getName() + "in types", chart);
            cfType.getChartPanel().setBackground(Color.BLACK);
            cfType.setVisible(true);
            cfType.setSize(800, 800);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "The directory can't be open or doesn't exist",
               "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_chartButton1ActionPerformed

    //Function to show the attribute's values on the labels
    public void showAttributes(File file)
    {
        nameLabel.setText("<html>Name: <font color='white'>" + file.getName() + "</font></html>");
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        Path path = Paths.get(file.getPath());
        BasicFileAttributes attr;
        try {
            attr = Files.readAttributes(path, BasicFileAttributes.class);
            accessedLabel.setText("<html>Accessed: <font color='white'>" + attr.lastAccessTime() + "</font></html>");
            modifiedLabel.setText("<html>Modified: <font color='white'>" + attr.lastModifiedTime() + "</font></html>");
            createdLabel.setText("<html>Created: <font color='white'>" + attr.creationTime() + "</font></html>");
            sizeLabel.setText("<html>Size: <font color='white'>" + attr.size() + " bytes" + "</font></html>");
            Set<PosixFilePermission> filePermissions = Files.getPosixFilePermissions(path);
            showPermissions(filePermissions);
            String fileExtension = (file.isDirectory() == true) ? "Directory" : FilenameUtils.getExtension(file.getPath());
            typeLabel.setText("<html>Type: <font color='white'>" + fileExtension + "</font></html>");
            pathLabel.setText("<html>Path: <font color='white'>" + file.getAbsolutePath() + "</font></html>");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "The file can't be found or doesn't exist",
               "File not found", JOptionPane.ERROR_MESSAGE);
        }
        
        //String extension =  Guava.Files.getFileExtension(path);;
    }
    //Function to format in a legible way the permissions of the file
    public void showPermissions(Set<PosixFilePermission> permissions)
    {
        String owner = "Owner: ", group = "Group: ", others = "Others: ";
        if (permissions.contains(PosixFilePermission.OWNER_READ))
            owner += "Read ";
        if (permissions.contains(PosixFilePermission.OWNER_WRITE))
            owner += "Write ";
        if (permissions.contains(PosixFilePermission.OWNER_EXECUTE))
            owner += "Execute ";
        if(owner.equals("Owner: "))
            owner += "None ";
        owner += "\n";
        
        if (permissions.contains(PosixFilePermission.GROUP_READ))
            group += "Read ";
        if (permissions.contains(PosixFilePermission.GROUP_WRITE))
            group += "Write ";
        if (permissions.contains(PosixFilePermission.GROUP_EXECUTE))
            group += "Execute ";
        if(group.equals("Group: "))
            group += "None ";
        group += "\n";
        
        if (permissions.contains(PosixFilePermission.OTHERS_READ))
            others += "Read ";
        if (permissions.contains(PosixFilePermission.OTHERS_WRITE))
            others += "Write ";
        if (permissions.contains(PosixFilePermission.OTHERS_EXECUTE))
            others += "Execute ";
        if(others.equals("Others: "))
            others += "None ";
        others += "\n";
        
        ownerLabel.setText(owner);
        groupLabel.setText(group);
        othersLabel.setText(others);
    }
    
    public void updateTree()
    {
        try
        {
            File root = (File)fileTree.getModel().getRoot();
            TreeModel model = new FileTreeModel(root);
            String filter = filterModel.getFilter();
            filterModel = new FilteredTreeModel(model);
            filterModel.setFilter(filter);
            fileTree.setModel(filterModel);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "The file can't be open or can't be created",
           "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
    
    //FileTreeCellRenderer shows only the file or directory name in the tree, without the full path
    class FileTreeCellRenderer extends DefaultTreeCellRenderer
    {
        private static final long serialVersionUID = 1L;
        private FileSystemView fsv = null;

        public FileTreeCellRenderer()
        {
            super();
            fsv = FileSystemView.getFileSystemView();
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) 
        {
            if(value instanceof File)
            {				
                File f = (File)value;
                value = f.getName();
                if(f.isFile())
                {
                    setLeafIcon(fsv.getSystemIcon(f));
                }
                else
                {				
                    setOpenIcon(getDefaultOpenIcon());
                    setClosedIcon(getDefaultClosedIcon());			
                }
            }
            
            Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            return c;				
        }	
    }
    
    //FilteredTreeModel class allows us to filter the nodes when we create the tree
    class FilteredTreeModel implements TreeModel {
        private TreeModel treeModel;
        private String filter;

        public FilteredTreeModel(TreeModel treeModel) {
            this.treeModel = treeModel;
            this.filter = "";
        }

        public TreeModel getTreeModel() {
            return treeModel;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }
        
        public String getFilter()
        {  
            return filter;
        }

        private boolean recursiveMatch(Object node, String filter) {
            boolean matches = node.toString().contains(filter);

            int childCount = treeModel.getChildCount(node);
            for (int i = 0; i < childCount; i++) {
              Object child = treeModel.getChild(node, i);
              matches |= recursiveMatch(child, filter);
            }

            return matches;
        }

        @Override
        public Object getRoot() {
            return treeModel.getRoot();
        }

        @Override
        public Object getChild(Object parent, int index) {
          int count = 0;
          int childCount = treeModel.getChildCount(parent);
          for (int i = 0; i < childCount; i++) 
          {
            Object child = treeModel.getChild(parent, i);
            if (recursiveMatch(child, filter)) 
            {
                if (count == index) 
                {
                  return child;
                }
                count++;
            }
          }
          return null;
        }

        @Override
        public int getChildCount(Object parent) {
            int count = 0;
            int childCount = treeModel.getChildCount(parent);
            for (int i = 0; i < childCount; i++) 
            {
              Object child = treeModel.getChild(parent, i);
                if (recursiveMatch(child, filter)) 
                {
                    count++;
                }
            }
            return count;
        }

        @Override
        public boolean isLeaf(Object node) {
          return treeModel.isLeaf(node);
        }

        @Override
        public void valueForPathChanged(TreePath path, Object newValue) {}

        @Override
        public int getIndexOfChild(Object parent, Object childToFind){
            int childCount = treeModel.getChildCount(parent);
            for (int i = 0; i < childCount; i++) 
            {
                Object child = treeModel.getChild(parent, i);
                if (recursiveMatch(child, filter)) 
                {
                    if (childToFind.equals(child)) 
                    {
                        return i;
                    }
                }
            }
            return -1;
        }

        @Override
        public void addTreeModelListener(TreeModelListener l) {}

        @Override
        public void removeTreeModelListener(TreeModelListener l) {}
    }
    
    //Classes for the popup method showed when you right clicked on the JTree
    class PopUpDemo extends javax.swing.JPopupMenu {
        public PopUpDemo() {
            add(openButton);
            add(deleteButton);
            add(newButton);
            add(renameButton);
            add(filterButton);
            add(compressButton);
            add(copyPathButton);
            add(terminalButton);
            add(chartButton);
            add(clearFilterButton);
            add(chartButton1);
            makeButtonVisible();
        }
        
        public void makeButtonVisible()
        {
            openButton.setVisible(true);
            deleteButton.setVisible(true);
            newButton.setVisible(true);
            renameButton.setVisible(true);
            filterButton.setVisible(true);
            compressButton.setVisible(true);
            copyPathButton.setVisible(true);
            terminalButton.setVisible(true);
            chartButton.setVisible(true);
            clearFilterButton.setVisible(true);
            chartButton1.setVisible(true);
        }
    }
    class PopClickListener extends java.awt.event.MouseAdapter {
        public void mousePressed(java.awt.event.MouseEvent e) {
            if (e.isPopupTrigger())
                doPop(e);
        }

        public void mouseReleased(java.awt.event.MouseEvent e) {
            if (e.isPopupTrigger())
                doPop(e);
        }

        private void doPop(java.awt.event.MouseEvent e) {
            PopUpDemo menu = new PopUpDemo();
            menu.show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessedLabel;
    private javax.swing.JPanel attributesPanel;
    private java.awt.Button chartButton;
    private java.awt.Button chartButton1;
    private java.awt.Button clearFilterButton;
    private java.awt.Button compressButton;
    private java.awt.Button copyPathButton;
    private javax.swing.JLabel createdLabel;
    private java.awt.Button deleteButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTree fileTree;
    private java.awt.Button filterButton;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modifiedLabel;
    private javax.swing.JLabel nameLabel;
    private java.awt.Button newButton;
    private java.awt.Button openButton;
    private javax.swing.JLabel othersLabel;
    private javax.swing.JLabel ownerLabel;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JLabel permissionsLabel;
    private java.awt.Button renameButton;
    private javax.swing.JLabel sizeLabel;
    private java.awt.Button terminalButton;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
    private FilteredTreeModel filterModel;
    private ChartFrame cfSize;
    private ChartFrame cfType;
    private File lastSelectedFileSize;
    private File lastSelectedFileType;
}
