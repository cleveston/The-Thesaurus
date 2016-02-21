
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* NewSynonymFrame class: It represents the NewSynonym window */
/**
 * ***********************************************************
 */
import java.awt.Font;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.*;

public class NewSynonymFrame extends JFrame {

    //The private variables
    private final JButton addButton;
    private final JButton cancelButton;
    private final JComboBox<String> definitionComboBox;
    private final JLabel definitionLabel;
    private final JPanel panel;
    private final JSeparator separatorDown;
    private final JSeparator separatorUp;
    private final JLabel synonymsLabel;
    private final JScrollPane synonymsScrollPane;
    private final JTextArea synonymsTextArea;
    private final JLabel titleLabel;

    //The selectBox options
    private final DefaultComboBoxModel options = new DefaultComboBoxModel();

    /**
     * ***********************************************************
     */
    /* Method: NewSynonymFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public NewSynonymFrame() {

        //Create the components
        panel = new JPanel();
        titleLabel = new JLabel();
        separatorUp = new JSeparator();
        definitionLabel = new JLabel();
        definitionComboBox = new JComboBox<>();
        synonymsLabel = new JLabel();
        synonymsScrollPane = new JScrollPane();
        synonymsTextArea = new JTextArea();
        separatorDown = new JSeparator();
        cancelButton = new JButton();
        addButton = new JButton();

        //Create the listener
        FormListener formListener = new FormListener();

        //Add the buttons listener
        cancelButton.addActionListener(formListener);
        addButton.addActionListener(formListener);

        setTitle("New Synonym");
        setName("newSynonymFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("New Synonym");
        definitionLabel.setText("Select the Definition");
        definitionComboBox.setModel(options);
        synonymsLabel.setText("New Synonyms (separated by /)");
        synonymsTextArea.setColumns(20);
        synonymsTextArea.setRows(5);
        synonymsScrollPane.setViewportView(synonymsTextArea);
        cancelButton.setText("Cancel");
        addButton.setText("Add");

        //Create the GroupLayout and set it to the panel
        GroupLayout panelLayout = new GroupLayout(panel);
        //Set the layout to the panel

        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        horizontalGroup.addComponent(separatorUp);
        horizontalGroup.addComponent(definitionComboBox);
        horizontalGroup.addComponent(synonymsScrollPane);
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel)
                        .addComponent(definitionLabel)
                        .addComponent(synonymsLabel))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        //Add the components and the gaps
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addComponent(cancelButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(addButton));
        horizontalGroup.addComponent(separatorDown);

        //Create the Vertical Group
        GroupLayout.Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        verticalGroup.addGroup(panelLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(10, 10, 10)
                .addComponent(separatorUp)
                .addGap(10, 10, 10)
                .addComponent(definitionLabel)
                .addGap(10, 10, 10)
                .addComponent(definitionComboBox)
                .addGap(10, 10, 10)
                .addComponent(synonymsLabel)
                .addGap(10, 10, 10)
                .addComponent(synonymsScrollPane)
                .addGap(10, 10, 10)
                .addComponent(separatorDown)
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelButton)
                        .addComponent(addButton)
                )
        );

        //Set the verticalGroup and the horizontalGroup to the panel
        panelLayout.setVerticalGroup(verticalGroup);
        panelLayout.setHorizontalGroup(horizontalGroup);

        //Create a GroupLayout to the JFrame
        GroupLayout layout = new GroupLayout(getContentPane());

        //Set the layout
        getContentPane().setLayout(layout);

        //Create the Horizontal Group
        GroupLayout.Group panelHorizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        panelHorizontalGroup.addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel)
                .addGap(10, 10, 10)
        );

        //Create the Horizontal Group
        GroupLayout.Group panelVerticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        panelVerticalGroup.addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel)
                .addGap(10, 10, 10)
        );

        //Set the verticalGroup and horizontalGroup
        layout.setHorizontalGroup(panelHorizontalGroup);
        layout.setVerticalGroup(panelVerticalGroup);

        pack();

        //Get all the entries
        Tree entries = Prog5.getThesaurus().getAll();

        //Create the iterator over the entry tree
        Iterator<Entry> EntryIterator = entries.iterator(false);

        //While it has next entry
        while (EntryIterator.hasNext()) {

            Entry item = EntryIterator.next();

            //Add the element into the options
            options.addElement(item.getWord());

        }

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
            if (event.getSource() == cancelButton) {

                //Close the window
                NewSynonymFrame.this.setVisible(false);
                NewSynonymFrame.this.dispose();
            } else if (event.getSource() == addButton) {
                NewSynonymFrame.this.addButtonActionPerformed(event);
            }
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: addButtonActionPerformed */
 /* Purpose: Add new synonyms in the dictionary */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void addButtonActionPerformed(ActionEvent event) {

        try {

            //Search for the word in the dictionary
            Entry entry = Prog5.getThesaurus().searchDefinition(definitionComboBox.getSelectedItem().toString());

            Scanner scanner = new Scanner(synonymsTextArea.getText());
            scanner.useDelimiter("/");

            //For each synonym
            while (scanner.hasNext()) {

                //Add the synonym into the definition
                entry.addSynonym(scanner.next().trim());

            }

            //Show the feedback to the user
            JOptionPane.showMessageDialog(this, "Synonyms were added on the Thesaurus.", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Close the frame
            this.setVisible(false);
            this.dispose();

        } catch (Exception exception) {
            //Show the feedback to the user
            JOptionPane.showMessageDialog(this, "Synonym already added.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
