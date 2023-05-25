package filemanager;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.swing.filechooser.FileSystemView;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class JFileChooserArqs extends JFileChooser {
    public JFileChooserArqs() {
        super();
        initComponent();
    }

    public JFileChooserArqs(String currentDirPath) {
        super(currentDirPath);
        initComponent();
    }

    public void initComponent() {
        Component[] c = getComponents();
        customizeUI(c);
    }

    public void customizeUI(Component[] c) {
        for (Component component : c) {
            if (component instanceof JPanel) {
                ((JPanel) component).setBackground(Color.BLACK);
                if (((JPanel) component).getComponentCount() != 0) {
                    customizeUI(((JPanel) component).getComponents());
                }
            }
            if (component instanceof JTextField) {
                ((JTextField) component).setBackground(Color.decode("#666666"));
                ((JTextField) component).setForeground(Color.WHITE);
                ((JTextField) component).setFont(new Font("DejaVu Sans", Font.PLAIN, 22));

                // Create an EmptyBorder with zero thickness
                Border noBorder = new EmptyBorder(0, 0, 0, 0);

                ((JTextField) component).setBorder(noBorder); // Set the EmptyBorder as the text field's border
            }
            if (component instanceof JToggleButton) {
                ((JToggleButton) component).setPreferredSize(new Dimension(30, 30)); // Set preferred size
                ((JToggleButton) component).setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
            }
            if (component instanceof JComboBox) {
                ((JComboBox) component).setPreferredSize(new Dimension(100, 30)); // Set preferred size
                ((JComboBox) component).setBackground(Color.decode("#666666"));
                ((JComboBox) component).setForeground(Color.WHITE);
                ((JComboBox) component).setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
                
                // Create an EmptyBorder with zero thickness
                Border noBorder = new EmptyBorder(0, 0, 0, 0);

                ((JComboBox) component).setBorder(noBorder); // Set the EmptyBorder as the text field's border
            }
            if (component instanceof JButton) {
                //((JButton) component).setPreferredSize(new Dimension(40, 30)); // Set preferred size
                ((JButton) component).setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
            }
            if (component instanceof JScrollPane) {
                JScrollPane scrollPane = (JScrollPane) component;
                JList<?> fileList = (JList<?>) scrollPane.getViewport().getView();
                fileList.setBackground(Color.BLACK); // Set background color of JList
                fileList.setForeground(Color.WHITE); // Set foreground color of JList
                fileList.setCellRenderer(new CustomListCellRenderer()); // Set custom cell renderer
                scrollPane.setPreferredSize(new Dimension(100, 200)); // Set preferred size of JScrollPane
            }
            if (component instanceof JLabel) {
                String labelText = ((JLabel) component).getText();
                if (labelText.equals("File Name:") || labelText.equals("Files of Type:") || labelText.equals("Look In:")) {
                    ((JLabel) component).setForeground(Color.decode("#a987ff")); // Set text color to white
                    ((JLabel) component).setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
                }
            }
        }
    }

    @Override
   protected JDialog createDialog(Component parent) throws HeadlessException {
       JDialog dialog = super.createDialog(parent);
       dialog.getContentPane().setBackground(Color.BLACK);
       dialog.setSize(624, 366); // Set preferred size for the dialog
       dialog.setLocationRelativeTo(parent);
       return dialog;
   }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFileChooser fileChooser = new JFileChooserArqs();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.showOpenDialog(null);
        });
    }
}

class CustomListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel) {
            JLabel label = (JLabel) renderer;
            Font font = label.getFont();
            label.setFont(new Font("DejaVu Sans", Font.PLAIN, 18)); // Increase font size by 4
            label.setIconTextGap(10); // Increase the gap between text and icon

            // Set icon based on the file type
            if (value instanceof File) {
                File file = (File) value;
                Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file);
                label.setIcon(icon);

                // Set the label text to the file name
                label.setText(file.getName());
            }
        }
        return renderer;
    }
}