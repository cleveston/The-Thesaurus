
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* SaveFrame class: It represents the Save window */
/**
 * ***********************************************************
 */
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;
import javax.swing.*;

public class SaveFrame extends JFrame {

    //The private variables
    private final JButton cancelButton;
    private final JLabel filenameTextLabel;
    private final JTextField filepathTextField;
    private final JPanel panel;
    private final JButton saveButton;
    private final JSeparator separatorDown;
    private final JSeparator separatorUp;
    private final JLabel titleTextLabel;

    /**
     * ***********************************************************
     */
    /* Method: SaveFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public SaveFrame() {

        //Create the components
        panel = new JPanel();
        titleTextLabel = new JLabel();
        separatorUp = new JSeparator();
        filenameTextLabel = new JLabel();
        filepathTextField = new JTextField();
        saveButton = new JButton();
        separatorDown = new JSeparator();
        cancelButton = new JButton();

        //Create the listener
        FormListener formListener = new FormListener();

        //Add the buttons listener
        saveButton.addActionListener(formListener);
        cancelButton.addActionListener(formListener);

        setTitle("Save Thesaurus to Disk");
        setLocationByPlatform(true);
        setName("saveFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleTextLabel.setFont(new Font("Dialog", 1, 16));
        titleTextLabel.setText("Save Thesaurus to Disk");
        filenameTextLabel.setText("Filename:");
        saveButton.setText("Save to Disk");
        cancelButton.setText("Cancel");

        //Create the Layout manager
        GroupLayout panelLayout = new GroupLayout(panel);

        //Set the layout to the panel
        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        horizontalGroup.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                .addGroup(GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addGap(10, 10, 10)
                        .addComponent(saveButton))
                .addComponent(separatorDown)
                .addComponent(separatorUp)
                .addComponent(filenameTextLabel, GroupLayout.Alignment.LEADING)
                .addComponent(filepathTextField)
                .addComponent(titleTextLabel)
        );

        //Create the sequentialPanel
        GroupLayout.Group sequentialGroup = panelLayout.createSequentialGroup();

        //Add the components and the gaps
        sequentialGroup.addComponent(titleTextLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(separatorUp);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(filenameTextLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(filepathTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(separatorDown);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(saveButton)
                .addComponent(cancelButton)
        );

        //Create the Vertical Group
        GroupLayout.Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the sequential group to the verticalGroup
        verticalGroup.addGroup(sequentialGroup);

        //Set the verticalGroup and horizontalGroup
        panelLayout.setVerticalGroup(verticalGroup);
        panelLayout.setHorizontalGroup(horizontalGroup);

        //Create a new layoutManager to the JFrame
        GroupLayout layout = new GroupLayout(getContentPane());

        //Set the layout
        getContentPane().setLayout(layout);

        //Create the horizontalGroup for the JFrame
        GroupLayout.Group panelHorizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panel)
                        .addGap(10, 10, 10)
                );

        //Create the verticalGroup for the JFrame
        GroupLayout.Group panelVerticalGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panel)
                        .addGap(10, 10, 10)
                );

        //Set the verticalGroup and the horizontalGroup to the panel
        layout.setVerticalGroup(panelVerticalGroup);
        layout.setHorizontalGroup(panelHorizontalGroup);

        pack();
    }

    /**
     * ***********************************************************
     */
    /* FormListener class: It implements the listener to the parent class */
    /**
     * ***********************************************************
     */
    private class FormListener implements ActionListener {

        /**
         * ***********************************************************
         */
        /* Method: actionPerformed */
 /* Purpose: The function called when an event occurs */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
        /**
         * ***********************************************************
         */
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == saveButton) {
                SaveFrame.this.saveButtonActionPerformed(event);
            } else if (event.getSource() == cancelButton) {
                //Close frame
                SaveFrame.this.setVisible(false);
                SaveFrame.this.dispose();
            }
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: saveButtonActionPerformed */
 /* Purpose:Save the database to disk*/
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void saveButtonActionPerformed(ActionEvent event) {

        Writer writer = null;

        try {

            //Create the writer
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(filepathTextField.getText()), "utf-8"));

            //Get all words from the dictonary
            Tree entries = Prog5.getThesaurus().getAll();

            //Create the iterator over the entry tree
            Iterator<Entry> EntryIterator = entries.iterator(true);

            //While it has next entry
            while (EntryIterator.hasNext()) {

                String text = "";

                //Get the entry content
                Entry item = EntryIterator.next();

                text += item.getWord() + "/";

                //Get the synonyms list
                Tree synonyms = item.getSynonyms();

                //Create the iterator over the synonym tree
                Iterator<String> SynonymsIterator = synonyms.iterator(true);

                //While it has synonym
                while (SynonymsIterator.hasNext()) {

                    String output = SynonymsIterator.next();

                    //Concat the synonyms into a string
                    text += (SynonymsIterator.hasNext()) ? output + "/" : output;
                }

                //Write entry to the file
                writer.write(text);

                //Add new line
                writer.write(System.getProperty("line.separator"));

                //Flush buffer
                writer.flush();

            }

            //Close the file
            writer.close();

            JOptionPane.showMessageDialog(this, "Entries were saved on the disk.", "Success", JOptionPane.INFORMATION_MESSAGE);

            this.setVisible(false);
            this.dispose();

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Erro while saving.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
