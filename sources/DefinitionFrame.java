
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* DefinitionFrame class: It represents the Definition window */
/**
 * ***********************************************************
 */
import java.awt.Font;
import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DefinitionFrame extends JFrame {

    //The private variables
    private final JButton newButton;
    private final JPanel panel;
    private final JPanel parentPanel;
    private final JScrollPane resultScrollPane;
    private final JSeparator separatorUp;
    private final JLabel titleLabel;

    /**
     * ***********************************************************
     */
    /* Method: DefinitionFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public DefinitionFrame() {

        //Create the components
        panel = new JPanel();
        titleLabel = new JLabel();
        newButton = new JButton();
        separatorUp = new JSeparator();
        resultScrollPane = new JScrollPane();
        parentPanel = new JPanel();

        //Create the listener
        FormListener formListener = new FormListener();

        setTitle("All Definitions");
        setName("definitionFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("All Definitions");
        newButton.setText("New Definition");

        //Add the button listener
        newButton.addActionListener(formListener);

        //Set the BoxLayout to the panel
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        //Get all the entries
        Tree entries = Prog5.getThesaurus().getAll();

        //Create the iterator over the entry tree
        Iterator<Entry> EntryIterator = entries.iterator(false);

        //While it has next entry
        while (EntryIterator.hasNext()) {

            String text = "";

            Entry item = EntryIterator.next();

            //Get the synonyms list
            Tree synonyms = item.getSynonyms();

            //Create the iterator over the synonym tree
            Iterator<String> SynonymsIterator = synonyms.iterator(false);

            //While it has synonym
            while (SynonymsIterator.hasNext()) {

                String output = SynonymsIterator.next();

                //Concat the synonyms into a string
                text += (SynonymsIterator.hasNext()) ? output + ", " : output;
            }

            //Create the components
            JPanel resultPanel = new JPanel();
            resultPanel.setBorder(new EmptyBorder(8, 10, 8, 10));
            JLabel definitionLabel = new JLabel();
            JLabel synonymsLabel = new JLabel();
            JSeparator resultSeparator = new JSeparator();
            JButton button = new JButton("Delete");

            //Add the listener to the button
            button.addActionListener(new ActionListener() {

                /**
                 * ***********************************************************
                 */
                /* Method: actionPerformed */
 /* Purpose: Button action */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
                /**
                 * ***********************************************************
                 */
                public void actionPerformed(ActionEvent event) {

                    //Ask for confirmation
                    int dialogResult = JOptionPane.showConfirmDialog(null, "Would You like to delete this entry?", "Warning", JOptionPane.YES_NO_OPTION);

                    if (dialogResult == JOptionPane.YES_OPTION) {

                        try {

                            //Remove the entry from the dictionary
                            Prog5.getThesaurus().removeEntry(item);

                            //Show the feedback to the user
                            JOptionPane.showMessageDialog(null, "Word removed: " + item.getWord(), "Success", JOptionPane.INFORMATION_MESSAGE);

                            //Create new window
                            new DefinitionFrame().setVisible(true);

                            //Close the frame
                            DefinitionFrame.this.setVisible(false);
                            DefinitionFrame.this.dispose();

                        } catch (Exception exception) {

                        }

                    }
                }
            });

            //Set the date to the components
            definitionLabel.setText(item.getWord());
            synonymsLabel.setFont(new Font("Dialog", 0, 12));
            synonymsLabel.setText(text);

            //Define the layout
            resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));

            //add the component to the panel
            resultPanel.add(definitionLabel);
            resultPanel.add(synonymsLabel);
            resultPanel.add(button);
            resultPanel.add(resultSeparator);

            //Add the panel to the scrollbar
            parentPanel.add(resultPanel);

        }

        resultScrollPane.setViewportView(parentPanel);

        //Create the GroupLayout and set it to the panel
        GroupLayout panelLayout = new GroupLayout(panel);

        //Set the layout to the panel
        panel.setLayout(panelLayout);

        //Create the sequentialPanel
        GroupLayout.Group sequentialGroup = panelLayout.createSequentialGroup().addComponent(titleLabel).
                addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE);
        sequentialGroup.addComponent(newButton);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        horizontalGroup.addGroup(sequentialGroup);
        horizontalGroup.addComponent(separatorUp);
        horizontalGroup.addComponent(resultScrollPane);

        //Create the Vertical Group
        GroupLayout.Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(newButton)
                                .addComponent(titleLabel))
                        .addGap(10, 10, 10)
                        .addComponent(separatorUp, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(resultScrollPane));

        //Set the verticalGroup and horizontalGroup
        panelLayout.setHorizontalGroup(horizontalGroup);
        panelLayout.setVerticalGroup(verticalGroup);

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

        resultScrollPane.setViewportView(parentPanel);

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
            if (event.getSource() == newButton) {

                //Show the New Definition JFrame
                JFrame newDefinitionFrame = new NewDefinitionFrame();
                newDefinitionFrame.setVisible(true);
            }
        }

    }

}
