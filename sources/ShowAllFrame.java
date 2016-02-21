
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* ShowAllFrame class: It represents the ShowAll window */
/**
 * ***********************************************************
 */
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ShowAllFrame extends JFrame {

    //The private variables
    private final JPanel panel;
    private final JPanel parentPanel;
    private final JScrollPane resultScrollPanel;
    private final JSeparator separator;
    private final JLabel titleLabel;

    /**
     * ***********************************************************
     */
    /* Method: ShowAllFrame */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public ShowAllFrame() {

        //Get all the entries
        Tree entries = Prog5.getThesaurus().getAll();

        //Create the components
        panel = new JPanel();
        titleLabel = new JLabel();
        separator = new JSeparator();
        resultScrollPanel = new JScrollPane();
        parentPanel = new JPanel();

        setTitle("All Definitions");
        panel.setPreferredSize(new Dimension(350, 400));
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("All Definitions (" + String.valueOf(entries.size()) + ")");

        //Set the parent layout 
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

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

            //Set the date to the components
            definitionLabel.setText(item.getWord());
            synonymsLabel.setFont(new Font("Dialog", 0, 12));
            synonymsLabel.setText(text);

            //Define the layout
            resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));

            //Add the component to the panel
            resultPanel.add(definitionLabel);
            resultPanel.add(synonymsLabel);
            resultPanel.add(resultSeparator);

            //Add the panel to the scrollbar
            parentPanel.add(resultPanel);

        }

        resultScrollPanel.setViewportView(parentPanel);

        //Create the Layout manager
        GroupLayout panelLayout = new GroupLayout(panel);

        //Set the layout to the panel
        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components to the group
        horizontalGroup.addComponent(separator);
        horizontalGroup.addComponent(resultScrollPanel);
        horizontalGroup.addComponent(titleLabel);

        //Create the sequentialPanel
        GroupLayout.Group sequentialGroup = panelLayout.createSequentialGroup();

        //Add the components and the gaps
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(titleLabel);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(separator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE);
        sequentialGroup.addGap(5, 5, 5);
        sequentialGroup.addComponent(resultScrollPanel);

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

}
