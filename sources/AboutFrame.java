
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* AboutFrame class: It represents the About window */
/**
 * ***********************************************************
 */
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Group;

public class AboutFrame extends JFrame {

    //The private variables
    private final JLabel AuthorLabel;
    private final JLabel LastUpdateLabel;
    private final JButton closeButton;
    private final JLabel dateLabel;
    private final JLabel disciplineLabel;
    private final JLabel disciplineNameLabel;
    private final JLabel label;
    private final JLabel nameLabel;
    private final JPanel panel;
    private final JSeparator separatorDown;
    private final JSeparator separatorUp;
    private final JLabel titleLabel;

    /**
     * ***********************************************************
     */
    /* Method: AboutFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public AboutFrame() {

        //Create the components
        label = new JLabel();
        panel = new JPanel();
        closeButton = new JButton();
        AuthorLabel = new JLabel();
        dateLabel = new JLabel();
        LastUpdateLabel = new JLabel();
        nameLabel = new JLabel();
        disciplineLabel = new JLabel();
        disciplineNameLabel = new JLabel();
        titleLabel = new JLabel();
        separatorUp = new JSeparator();
        separatorDown = new JSeparator();

        //Create the listener
        FormListener formListener = new FormListener();

        setTitle("About");
        setName("aboutFrame");
        setResizable(false);

        //Add the button listener
        closeButton.addActionListener(formListener);

        //Set labels, texts and fonts
        label.setText("label");
        closeButton.setText("Close");
        AuthorLabel.setFont(new Font("Dialog", 0, 12));
        AuthorLabel.setText("Author");
        dateLabel.setText("12/15/2015");
        LastUpdateLabel.setFont(new Font("Dialog", 0, 12));
        LastUpdateLabel.setText("Last Update");
        nameLabel.setText("Iury Cleveston");
        disciplineLabel.setFont(new Font("Dialog", 0, 12));
        disciplineLabel.setText("Discipline");
        disciplineNameLabel.setText("Programming and Algorithms II");
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("About this Program");

        //Create the Layout manager
        GroupLayout panelLayout = new GroupLayout(panel);

        //Set the layout to the panel
        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components to the group
        horizontalGroup.addComponent(titleLabel);
        horizontalGroup.addComponent(AuthorLabel);
        horizontalGroup.addComponent(separatorUp);
        horizontalGroup.addComponent(nameLabel);
        horizontalGroup.addComponent(LastUpdateLabel);
        horizontalGroup.addComponent(dateLabel);
        horizontalGroup.addComponent(disciplineLabel);
        horizontalGroup.addComponent(disciplineNameLabel);

        //Create another group for the button
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(closeButton)
        );

        horizontalGroup.addComponent(separatorDown);

        //Create the sequentialPanel
        Group sequentialGroup = panelLayout.createSequentialGroup();

        //Add the components and the gaps
        sequentialGroup.addComponent(titleLabel);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(separatorUp);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(AuthorLabel);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(nameLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(LastUpdateLabel);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(dateLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(disciplineLabel);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(disciplineNameLabel);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(separatorDown);
        sequentialGroup.addGap(10, 10, 10);
        sequentialGroup.addComponent(closeButton);

        //Create the Vertical Group
        Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

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
        Group panelHorizontalGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(panel)
                        .addGap(10, 10, 10)
                );

        //Create the verticalGroup for the JFrame
        Group panelVerticalGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
            if (event.getSource() == closeButton) {

                //Close the frame
                AboutFrame.this.setVisible(false);
                AboutFrame.this.dispose();
            }
        }
    }

}
