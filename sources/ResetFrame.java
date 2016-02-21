
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* ResetFrame class: It represents the Reset window */
/**
 * ***********************************************************
 */
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class ResetFrame extends JFrame {

    //The private variables
    private final JButton cancelButton;
    private final JTextField filepathTextField;
    private final JLabel infoLabel;
    private final JPanel panel;
    private final JButton resetButton;
    private final JSeparator separatorDown;
    private final JSeparator separatorUp;
    private final JLabel titleLabel;

    /**
     * ***********************************************************
     */
    /* Method: ResetFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public ResetFrame() {

        //Create the components
        panel = new JPanel();
        titleLabel = new JLabel();
        separatorUp = new JSeparator();
        infoLabel = new JLabel();
        filepathTextField = new JTextField();
        separatorDown = new JSeparator();
        cancelButton = new JButton();
        resetButton = new JButton();

        //Create the listener
        FormListener formListener = new FormListener();

        //Add the buttons listener
        cancelButton.addActionListener(formListener);
        resetButton.addActionListener(formListener);

        setTitle("Reset Thesaurus Database");
        setLocationByPlatform(true);
        setName("resetFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("Reset Thesaurus from a File");
        infoLabel.setText("Filename:");
        cancelButton.setText("Cancel");
        resetButton.setText("Reset");

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
                        .addGap(100, 100, 100)
                        .addComponent(resetButton))
                .addComponent(separatorDown)
                .addComponent(separatorUp)
                .addComponent(infoLabel, GroupLayout.Alignment.LEADING)
                .addComponent(filepathTextField)
                .addComponent(titleLabel)
        );

        //Create the sequentialPanel
        GroupLayout.Group sequentialGroup = panelLayout.createSequentialGroup();

        //Add the components and the gaps
        sequentialGroup.addComponent(titleLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(separatorUp);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(infoLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(filepathTextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(separatorDown);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(resetButton)
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
            if (event.getSource() == cancelButton) {

                //Close the window
                ResetFrame.this.setVisible(false);
                ResetFrame.this.dispose();
            } else if (event.getSource() == resetButton) {
                ResetFrame.this.resetButtonActionPerformed(event);
            }
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: resetButtonActionPerformed */
 /* Purpose: Re-initialize the database*/
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void resetButtonActionPerformed(ActionEvent event) {

        try {

            //Read the file and create the thesaurus
            Prog5.readFile(filepathTextField.getText());

            //Show the feedback to the user
            JOptionPane.showMessageDialog(this, "The Thesaurus was re-initialized.", "Success", JOptionPane.INFORMATION_MESSAGE);

            //Clsoe the window
            this.setVisible(false);
            this.dispose();

        } catch (Exception exception) {
            //Show the feedback to the user
            JOptionPane.showMessageDialog(this, "File does not exist.", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }
}
