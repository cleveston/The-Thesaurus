
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* Entry class: It represents a record in the dictionary */
/**
 * ***********************************************************
 */
public class Entry implements Comparable<Entry> {

    //Private variables
    private final String word;
    private final Tree<String> synonyms;

    /**
     * ***********************************************************
     */
    /* Method: Entry */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* String word: The word that will initialize the Entry */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public Entry(String word) {

        //Initialize the object with the appropriate word
        this.word = word;

        //Create the synonyms list
        this.synonyms = new Tree<>();

    }

    /**
     * ***********************************************************
     */
    /* Method: addSynonym */
 /* Purpose: Add new synonym to the entry */
 /* Parameters: */
 /* String synonym: The synonym that will be stored */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void addSynonym(String synonym) throws Exception {

        //Verify if the synonym is present in the dictionary
        if (this.hasSynonym(synonym)) {
            throw new Exception(synonym + " already exists. Operation Canceled.");
        }

        //Otherwise, add the new synonym
        this.synonyms.add(synonym);

    }

    /**
     * ***********************************************************
     */
    /* Method: hasSynonym */
 /* Purpose: Verify if the word contains the specific synonym */
 /* Parameters: */
 /* String synonym: The synonym that will be compared */
 /* Returns: Boolean: Does it contain the synonym? */
    /**
     * ***********************************************************
     */
    public boolean hasSynonym(String synonym) {

        return this.synonyms.contains(synonym);

    }

    /**
     * ***********************************************************
     */
    /* Method: getSynonyms */
 /* Purpose: Get all synonyms of the word */
 /* Parameters: */
 /* Returns: Tree: The synonyms list */
    /**
     * ***********************************************************
     */
    public Tree<String> getSynonyms() {

        return this.synonyms;

    }

    /**
     * ***********************************************************
     */
    /* Method: removeSynonym */
 /* Purpose: Remove a specific synonym from the entry */
 /* Parameters: */
 /* String synonym : The synonym that will be removed */
 /* Returns: void */
    /**
     * ***********************************************************
     */
    public void removeSynonym(String synonym) {

        this.synonyms.remove(synonym);

    }

    /**
     * ***********************************************************
     */
    /* Method: getWord */
 /* Purpose: Get the definition */
 /* Parameters: */
 /* Returns: String */
    /**
     * ***********************************************************
     */
    public String getWord() {

        return this.word;
    }

    /**
     * ***********************************************************
     */
    /* Method: toString */
 /* Purpose: Get the string */
 /* Parameters: */
 /* Returns: String */
    /**
     * ***********************************************************
     */
    public String toString() {

        return this.getWord();
    }

    /**
     * ***********************************************************
     */
    /* Method: compareTo */
 /* Purpose: Compare two entries */
 /* Parameters: */
 /* Returns: Int */
    /**
     * ***********************************************************
     */
    public int compareTo(Entry compare) {
        return this.word.compareTo(compare.getWord());
    }

}
