/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;


public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
    private Color textColor = Color.WHITE;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component component = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setForeground(textColor); // Set the text color

            if (value instanceof DefaultMutableTreeNode) {
                Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
                if (userObject instanceof File) {
                    File file = (File) userObject;
                    label.setText(file.getName()); // Set only the name of the file/directory
                }
            }
        }

        if (component.getParent() instanceof JComponent) {
            JComponent parentComponent = (JComponent) component.getParent();
            parentComponent.setBackground(null); // Set background color of the parent component to null (transparent)
        }

        return component;
    }
}

