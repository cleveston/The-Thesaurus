
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* NewDefinitionFrame class: It represents the NewDefinition window */
/**
 * ***********************************************************
 */
import java.awt.Font;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class NewDefinitionFrame extends JFrame {

    //The private variables
    private final JButton addButton;
    private final JButton cancelButton;
    private final JLabel definitionsLabel;
    private final JTextField definitionsTextField;
    private final JPanel panel;
    private final JSeparator separatorDown;
    private final JSeparator separatorUp;
    private final JLabel synonymsLabel;
    private final JScrollPane synonymsScrollPane;
    private final JTextArea synonymsTextArea;
    private final JLabel titleLabel;

    /**
     * ***********************************************************
     */
    /* Method: NewDefinitionFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public NewDefinitionFrame() {

        //Create the components
        panel = new JPanel();
        titleLabel = new JLabel();
        separatorUp = new JSeparator();
        definitionsLabel = new JLabel();
        definitionsTextField = new JTextField();
        synonymsLabel = new JLabel();
        separatorDown = new JSeparator();
        cancelButton = new JButton();
        addButton = new JButton();
        synonymsScrollPane = new JScrollPane();
        synonymsTextArea = new JTextArea();

        //Create the listener
        FormListener formListener = new FormListener();

        //Add the buttons listener
        cancelButton.addActionListener(formListener);
        addButton.addActionListener(formListener);

        setTitle("New Definition");
        setName("newDefinitionFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("New Definition");
        definitionsLabel.setText("New Definition");
        synonymsLabel.setText("New Synonyms (separated by /)");
        cancelButton.setText("Cancel");
        addButton.setText("Add");

        synonymsTextArea.setColumns(20);
        synonymsTextArea.setRows(5);
        synonymsScrollPane.setViewportView(synonymsTextArea);

        //Create the GroupLayout ans set it to the panel
        GroupLayout panelLayout = new GroupLayout(panel);

        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components to the group
        horizontalGroup.addComponent(separatorUp);
        horizontalGroup.addComponent(definitionsTextField);
        horizontalGroup.addComponent(separatorDown);

        //Create another group for the buttons
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addComponent(cancelButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(addButton)
        );

        //Add the components to the group
        horizontalGroup.addComponent(titleLabel);
        horizontalGroup.addComponent(definitionsLabel);
        horizontalGroup.addComponent(synonymsLabel);
        horizontalGroup.addComponent(synonymsScrollPane);

        //Create the Vertical Group
        GroupLayout.Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components to the group
        verticalGroup.addGroup(panelLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addGap(10, 10, 10)
                .addComponent(separatorUp)
                .addGap(10, 10, 10)
                .addComponent(definitionsLabel)
                .addGap(10, 10, 10)
                .addComponent(definitionsTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(synonymsLabel)
                .addGap(10, 10, 10)
                .addComponent(synonymsScrollPane)
                .addGap(10, 10, 10)
                .addComponent(separatorDown)
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addButton)
                        .addComponent(cancelButton))
        );

        //Set the verticalGroup and the horizontalGroup to the panel
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
            if (event.getSource() == cancelButton) {

                //Close the window
                NewDefinitionFrame.this.setVisible(false);
                NewDefinitionFrame.this.dispose();
            } else if (event.getSource() == addButton) {
                NewDefinitionFrame.this.addButtonActionPerformed(event);
            }
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: addButtonActionPerformed */
 /* Purpose: Add a new definition in the dictionary */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void addButtonActionPerformed(ActionEvent event) {

        try {

            //Add new word to the dictionary
            Entry entry = Prog5.getThesaurus().add(definitionsTextField.getText().trim());

            Scanner scanner = new Scanner(synonymsTextArea.getText());
            scanner.useDelimiter("/");

            //For each synonym
            while (scanner.hasNext()) {

                //Add the synonym into the definition
                entry.addSynonym(scanner.next().trim());

            }

            //Show the feedback to the user
            JOptionPane.showMessageDialog(this, "Definition was added in the Thesaurus.", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Close the frame
            this.setVisible(false);
            this.dispose();

        } catch (Exception exception) {
            //Show the feedback to the user
            JOptionPane.showMessageDialog(this, "Definition already added.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
