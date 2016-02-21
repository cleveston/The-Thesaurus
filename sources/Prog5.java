
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* Prog5 class: This class provides the interface between user and database */
/**
 * ***********************************************************
 */
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.border.EmptyBorder;

public class Prog5 extends JFrame {

    //The private variables
    private final JButton SearchButton;
    private final JLabel TypeSearchLabel;
    private final JMenuItem aboutMenu;
    private final JMenuItem allDefinitionsSubMenu;
    private final JMenuItem allSynonymsSubMenu;
    private final JRadioButton definitionRadioButton;
    private final JMenu definitionsMenu;
    private final JMenuItem exitSubMenu;
    private final JMenu helpMenu;
    private final JMenuItem showAllSubMenu;
    private final JMenuBar menuBar;
    private final JPanel panel;
    private final JPanel parentPanel;
    private final JMenuItem resetSubMenu;
    private final JLabel resultLabel;
    private final JScrollPane resultScrollPane;
    private final JMenuItem saveSubMenu;
    private final ButtonGroup searchTypeRadioButton;
    private final JSeparator separatorUp;
    private final JMenu fileMenu;
    private final JRadioButton synonymRadioButton;
    private final JLabel titleLabel;
    private final JButton viewAllButton;
    private final JTextField wordTextField;

    //Define Database
    private static final Database thesaurus = new Database();

    /**
     * ***********************************************************
     */
    /* Method: Prog5 */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public Prog5() {

        //Create the components
        searchTypeRadioButton = new ButtonGroup();
        panel = new JPanel();
        titleLabel = new JLabel();
        viewAllButton = new JButton();
        separatorUp = new JSeparator();
        TypeSearchLabel = new JLabel();
        wordTextField = new JTextField();
        SearchButton = new JButton();
        definitionRadioButton = new JRadioButton();
        synonymRadioButton = new JRadioButton();
        resultLabel = new JLabel();
        resultScrollPane = new JScrollPane();
        parentPanel = new JPanel();
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        showAllSubMenu = new JMenuItem();
        saveSubMenu = new JMenuItem();
        resetSubMenu = new JMenuItem();
        exitSubMenu = new JMenuItem();
        definitionsMenu = new JMenu();
        allDefinitionsSubMenu = new JMenuItem();
        allSynonymsSubMenu = new JMenuItem();
        helpMenu = new JMenu();
        aboutMenu = new JMenuItem();

        //Create the listener
        FormListener formListener = new FormListener();

        //Add the buttons listener
        viewAllButton.addActionListener(formListener);
        wordTextField.addFocusListener(formListener);
        showAllSubMenu.addActionListener(formListener);
        saveSubMenu.addActionListener(formListener);
        resetSubMenu.addActionListener(formListener);
        exitSubMenu.addActionListener(formListener);
        allDefinitionsSubMenu.addActionListener(formListener);
        allSynonymsSubMenu.addActionListener(formListener);
        aboutMenu.addActionListener(formListener);

        //Define key accelerator
        aboutMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
        exitSubMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
        resetSubMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
        saveSubMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Thesaurus");
        setName("mainFrame");
        setResizable(false);

        //Set labels, texts and fonts
        titleLabel.setFont(new Font("Dialog", 1, 16));
        titleLabel.setText("The Thesaurus");
        viewAllButton.setText("View all Definitions");
        TypeSearchLabel.setText("Are you searching for:");
        wordTextField.setText("Enter your word");
        SearchButton.setText("Search");
        SearchButton.addActionListener(formListener);
        searchTypeRadioButton.add(definitionRadioButton);
        definitionRadioButton.setSelected(true);
        definitionRadioButton.setText("Definition");
        searchTypeRadioButton.add(synonymRadioButton);
        synonymRadioButton.setText("Synonym");
        resultLabel.setText("Results");
        fileMenu.setText("File");
        showAllSubMenu.setText("Show All");
        fileMenu.add(showAllSubMenu);
        saveSubMenu.setText("Save to Disk");
        fileMenu.add(saveSubMenu);
        resetSubMenu.setText("Reset Dictionary");
        fileMenu.add(resetSubMenu);
        exitSubMenu.setText("Exit");
        fileMenu.add(exitSubMenu);
        menuBar.add(fileMenu);
        definitionsMenu.setText("Manage");
        allDefinitionsSubMenu.setText("All Definitions");
        definitionsMenu.add(allDefinitionsSubMenu);
        allSynonymsSubMenu.setText("All Synonyms");
        definitionsMenu.add(allSynonymsSubMenu);
        menuBar.add(definitionsMenu);
        helpMenu.setText("Help");
        aboutMenu.setText("About");
        helpMenu.add(aboutMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        GroupLayout parentPanelLayout = new GroupLayout(parentPanel);
        parentPanel.setLayout(parentPanelLayout);
        parentPanelLayout.setHorizontalGroup(parentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 566, Short.MAX_VALUE)
        );
        parentPanelLayout.setVerticalGroup(parentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGap(0, 292, Short.MAX_VALUE)
        );

        resultScrollPane.setViewportView(parentPanel);

        //Create the GroupLayout and set it to the panel
        GroupLayout panelLayout = new GroupLayout(panel);

        //Set the layout to the panel
        panel.setLayout(panelLayout);

        //Create the Horizontal Group
        GroupLayout.Group horizontalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        //Add the components and the gaps
        horizontalGroup.addComponent(separatorUp);
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addComponent(titleLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewAllButton)
        );
        horizontalGroup.addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(resultScrollPane)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(TypeSearchLabel)
                                        .addGap(10, 10, 10)
                                        .addComponent(definitionRadioButton)
                                        .addGap(10, 10, 10)
                                        .addComponent(synonymRadioButton))
                                .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(wordTextField, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                                .addComponent(resultLabel)
                        )
                )
        );

        //Create the Horizontal Group
        GroupLayout.Group verticalGroup = panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING);

        verticalGroup.addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(viewAllButton)
                        .addComponent(titleLabel))
                .addGap(10, 10, 10)
                .addComponent(separatorUp, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TypeSearchLabel)
                        .addComponent(definitionRadioButton)
                        .addComponent(synonymRadioButton))
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(wordTextField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addComponent(SearchButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultLabel)
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
    }

    /**
     * ***********************************************************
     */
    /* Method: main */
 /* Purpose: The main method */
 /* Parameters: */
 /* String[] args: The filepath that contains the words */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public static void main(String[] args) {

        //Verify if something was received
        if (args.length == 0) {
            JOptionPane.showMessageDialog(null, "File was not specified.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            //Try to read file and add words to the database
            try {
                readFile(args[0]);

                //Execute main window
                new Prog5().setVisible(true);

            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    /**
     * ***********************************************************
     */
    /* Method: getThesaurus */
 /* Purpose: Get the database */
 /* Parameters: */
 /* Returns: Database */
    /**
     * ***********************************************************
     */
    public static Database getThesaurus() {

        //Get the database
        return thesaurus;

    }

    /**
     * ***********************************************************
     */
    /* Method: readFile */
 /* Purpose: Read data from the file */
 /* Parameters: */
 /* String path: The filepath */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public static void readFile(String path) throws Exception {

        Scanner file = null;

        try {

            //Open the file
            file = new Scanner(new File(path));

            //Remove all data from database
            thesaurus.removeAll();

            //For each line in the file
            while (file.hasNextLine()) {

                //Get the line content
                String input = file.nextLine().trim();

                //Chech if the line is empty
                if (!input.isEmpty()) {

                    //Break the content into words
                    Scanner words = new Scanner(input);
                    words.useDelimiter("/");

                    //Add first word as the definition
                    Entry item = thesaurus.add(words.next().trim());

                    //For each synonym
                    while (words.hasNext()) {

                        //Add the synonym into the definition
                        item.addSynonym(words.next().trim());

                    }
                }

            }
        } catch (Exception exception) {
            throw new Exception("File not found.");
        }

    }

    /**
     * ***********************************************************
     */
    /* FormListener class: It implements the listener to the parent class */
    /**
     * ***********************************************************
     */
    private class FormListener implements ActionListener, FocusListener {

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
            if (event.getSource() == viewAllButton) {
                JFrame showAllFrame = new ShowAllFrame();
                showAllFrame.setVisible(true);
            } else if (event.getSource() == SearchButton) {
                Prog5.this.SearchButtonActionPerformed(event);
            } else if (event.getSource() == showAllSubMenu) {
                JFrame showAllFrame = new ShowAllFrame();
                showAllFrame.setVisible(true);
            } else if (event.getSource() == saveSubMenu) {
                JFrame saveFrame = new SaveFrame();
                saveFrame.setVisible(true);
            } else if (event.getSource() == resetSubMenu) {
                JFrame resetFrame = new ResetFrame();
                resetFrame.setVisible(true);
            } else if (event.getSource() == exitSubMenu) {
                Prog5.this.setVisible(false);
                Prog5.this.dispose();
            } else if (event.getSource() == allDefinitionsSubMenu) {
                JFrame definitionFrame = new DefinitionFrame();
                definitionFrame.setVisible(true);
            } else if (event.getSource() == allSynonymsSubMenu) {
                JFrame allSynonymsFrame = new SynonymFrame();
                allSynonymsFrame.setVisible(true);
            } else if (event.getSource() == aboutMenu) {
                JFrame aboutFrame = new AboutFrame();
                aboutFrame.setVisible(true);
            }
        }

        /**
         * ***********************************************************
         */
        /* Method: focusGained */
 /* Purpose: The function called when the textField gains the focus */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
        /**
         * ***********************************************************
         */
        public void focusGained(FocusEvent event) {
            if (event.getSource() == wordTextField) {

                //Reset the text
                wordTextField.setText("");
            }
        }

        /**
         * ***********************************************************
         */
        /* Method: focusLost */
 /* Purpose: The function called when the textField loses the focus */
 /* Parameters: */
 /* FocusEvent event: the event itself */
 /* Returns: Void */
        /**
         * ***********************************************************
         */
        public void focusLost(FocusEvent event) {
            if (event.getSource() == wordTextField) {
                //Verify if the input is empty
                if (wordTextField.getText().trim().equals("")) {

                    //Reset the text
                    wordTextField.setText("Enter your Word");

                }
            }
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: SearchButtonActionPerformed */
 /* Purpose: The function will display all the search results */
 /* Parameters: */
 /* ActionEvent event: the event itself */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void SearchButtonActionPerformed(ActionEvent event) {

        //Reset the panel
        parentPanel.removeAll();
        resultLabel.setText("Results");

        //Define the panel layout
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

        try {

            //Verify which radiobutton is selected
            if (synonymRadioButton.isSelected()) {

                //Search for the word in the dictionary
                Tree<Entry> entry = thesaurus.searchSynonym(wordTextField.getText());

                resultLabel.setText("Results (" + entry.size() + ")");

                //Create the iterator over the entry tree
                Iterator<Entry> EntryIterator = entry.iterator(false);

                //While it has entry
                while (EntryIterator.hasNext()) {

                    String text = "";

                    //Get the entry content
                    Entry item = EntryIterator.next();

                    //Get the synonyms
                    Tree synonyms = item.getSynonyms();

                    //Create the iterator over the synonyms tree
                    Iterator<String> SynonymsIterator = synonyms.iterator(false);

                    //While it has synonyms
                    while (SynonymsIterator.hasNext()) {

                        //Get the synonym content
                        String synonym = SynonymsIterator.next();

                        //Concat the synonyms into a string
                        text += (SynonymsIterator.hasNext()) ? synonym + ", " : synonym;
                    }

                    //Show the results on screen
                    showResults(item.getWord(), text);

                }

            } else {

                //Get the entry
                Entry entry = thesaurus.searchDefinition(wordTextField.getText());

                parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.PAGE_AXIS));

                String text = "";

                //Get the synonyms list
                Tree synonyms = entry.getSynonyms();

                //Create the iterator over the synonym tree
                Iterator<String> SynonymsIterator = synonyms.iterator(false);

                //While it has synonym
                while (SynonymsIterator.hasNext()) {

                    String output = SynonymsIterator.next();

                    //Concat the synonyms into a string
                    text += (SynonymsIterator.hasNext()) ? output + ", " : output;
                }

                showResults(entry.getWord(), text);

            }
        } catch (Exception exception) {
            //Update the screen
            repaint();
            revalidate();

            //Show feedback
            JOptionPane.showMessageDialog(this, exception.getMessage(), "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        //Update the screen
        repaint();
        revalidate();
    }

    /**
     * ***********************************************************
     */
    /* Method: showResults */
 /* Purpose: Show the result on the screen */
 /* Parameters: */
 /* String word: the definition */
 /* String synonyms: all the synonyms */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private void showResults(String word, String synonyms) {

        //Create the components
        JPanel resultPanel = new JPanel();
        JLabel definitionLabel = new JLabel();
        JLabel synonymsLabel = new JLabel();
        JSeparator resultSeparator = new JSeparator();
        resultPanel.setBorder(new EmptyBorder(8, 10, 8, 10));
        //Define the layout
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));

        //Set the date to the components
        definitionLabel.setText(word);
        synonymsLabel.setFont(new Font("Dialog", 0, 12));
        synonymsLabel.setText(synonyms);

        //add the component to the panel
        resultPanel.add(definitionLabel);
        resultPanel.add(synonymsLabel);
        resultPanel.add(resultSeparator);

        //Add the panel to the scrollbar
        parentPanel.add(resultPanel);

    }

}
