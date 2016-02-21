
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* SynonymFrame class: It represents the Synonym window */
/**
 * ***********************************************************
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SynonymFrame extends JFrame {

    //The private variables
    private final JLabel definitonLabel;
    private final JButton newButton;
    private final JPanel panel;
    private final JPanel parentPanel;
    private final JScrollPane resultScrollPane;
    private final JComboBox<String> selectDefinitionComboBox;
    private final JSeparator separatorUp;
    private final JLabel titleLabel;

    //The selextBox options
    private final DefaultComboBoxModel options = new DefaultComboBoxModel();

    /**
     * ***********************************************************
     */
    /* Method: SynonymFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public SynonymFrame() {

        //Create the components
        panel = new JPanel();
        titleLabel = new JLabel();
        newButton = new JButton();
        separatorUp = new JSeparator();
        definitonLabel = new JLabel();
        selectDefinitionComboBox = new JComboBox<>();
        resultScrollPane = new JScrollPane();
        parentPanel = new JPanel();

        //Create the listener
        FormListener formListener = new FormListener();

        //Add the buttons listener
        newButton.addActionListener(formListener);
        selectDefinitionComboBox.addActionListener(formListener);

        setTitle("All Synonyms");
        setName("synoymFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("All Synonyms");
        newButton.setText("New Synonym");
        definitonLabel.setText("Select the Definition:");
        selectDefinitionComboBox.setModel(options);

        GroupLayout parentPanelLayout = new GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(parentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        parentPanelLayout.setVerticalGroup(parentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 230, Short.MAX_VALUE)
        );

        resultScrollPane.setViewportView(parentPanel);

        //Create the GroupLayout and set it to the panel
        GroupLayout panelLayout = new GroupLayout(panel);

        //Set the layout to the panel
        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(newButton)
        );
        horizontalGroup.addComponent(separatorUp);
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(selectDefinitionComboBox)
                        .addComponent(definitonLabel)
                )
                .addGap(10, 10, 10));
        horizontalGroup.addComponent(resultScrollPane);

        //Create the Horizontal Group
        GroupLayout.Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        verticalGroup.addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(newButton)
                        .addComponent(titleLabel))
                .addGap(10, 10, 10)
                .addComponent(separatorUp, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(definitonLabel)
                .addGap(10, 10, 10)
                .addComponent(selectDefinitionComboBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(resultScrollPane)
        );

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
            if (event.getSource() == newButton) {
                JFrame newSynonymFrame = new NewSynonymFrame();

                newSynonymFrame.setVisible(true);
            } else if (event.getSource() == selectDefinitionComboBox) {
                SynonymFrame.this.selectDefinitionComboBoxActionPerformed(event);
            }
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: selectDefinitionComboBoxActionPerformed */
 /* Purpose: The function searches for the synonyms */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void selectDefinitionComboBoxActionPerformed(ActionEvent event) {

        //Clear the painel
        parentPanel.removeAll();

        resultScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        try {

            //Get the item
            Entry item = Prog5.getThesaurus().searchDefinition(selectDefinitionComboBox.getSelectedItem().toString());
            //Get the synonyms list
            Tree synonyms = item.getSynonyms();

            //Create the iterator over the synonym tree
            Iterator<String> SynonymsIterator = synonyms.iterator(false);

            //While it has synonym
            while (SynonymsIterator.hasNext()) {

                //Get the synonym
                String synonym = SynonymsIterator.next();

                //Create the components
                JPanel resultPanel = new JPanel();
                resultPanel.setBorder(new EmptyBorder(8, 10, 8, 10));

                JLabel synonymsLabel = new JLabel();
                JSeparator resultSeparator = new JSeparator();
                JButton button = new JButton("Delete");

                //Add the listener to the button
                button.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent ae) {

                        //Ask for confirmation
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You like to delete this synonym?", "Warning", JOptionPane.YES_NO_OPTION);

                        if (dialogResult == JOptionPane.YES_OPTION) {

                            try {

                                //Remove the synonym from the dictionary
                                item.removeSynonym(synonym);

                                //Show the feedback to the user
                                JOptionPane.showMessageDialog(null, "Synonym removed: " + synonym, "Success", JOptionPane.INFORMATION_MESSAGE);

                                //Create new window
                                new SynonymFrame().setVisible(true);

                                //Close JFrame
                                SynonymFrame.this.setVisible(false);
                                SynonymFrame.this.dispose();

                            } catch (Exception exception) {

                            }

                        }
                    }
                });

                //Set the date to the components
                synonymsLabel.setFont(new Font("Dialog", 0, 12));
                synonymsLabel.setText(synonym);

                //Define the layout
                resultPanel.setLayout(new BorderLayout());

                //add the component to the panel
                resultPanel.add(synonymsLabel, BorderLayout.LINE_START);

                resultPanel.add(button, BorderLayout.LINE_END);

                resultPanel.add(resultSeparator, BorderLayout.PAGE_END);

                //Add the panel to the scrollbar
                parentPanel.add(resultPanel);

            }

            resultScrollPane.setViewportView(parentPanel);

        } catch (Exception exception) {

        }

    }

}
