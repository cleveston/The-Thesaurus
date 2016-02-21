
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* Database class: It represents the dictionary itself */
/**
 * ***********************************************************
 */
import java.util.Iterator;

public class Database {

    //Array with all records
    private Tree<Entry> entries;

    /**
     * ***********************************************************
     */
    /* Method: Database */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public Database() {

        //Create the array
        this.entries = new Tree<>();

    }

    /**
     * ***********************************************************
     */
    /* Method: add */
 /* Purpose: Create new entry in the thesaurus */
 /* Parameters: */
 /* String word: The definition of the entry */
 /* Returns: Entry: Return the entry to be populated with synonyms */
    /**
     * ***********************************************************
     */
    public Entry add(String word) throws Exception {

        Entry entry = null;

        try {

            //Verify if the word already exist in the dictionary
            entry = this.searchDefinition(word);

        } catch (Exception exception) {
            //Create a new entry
            entry = new Entry(word);

            //Add entry to the list
            this.entries.add(entry);

            return entry;

        }

        throw new Exception("Word already exists.");

    }

    /**
     * ***********************************************************
     */
    /* Method: searchDefinition */
 /* Purpose: Search for a definition */
 /* Parameters: */
 /* String word: The word that will be compared */
 /* Returns: Entry: did we find it? */
    /**
     * ***********************************************************
     */
    public Entry searchDefinition(String word) throws Exception {

        try {

            //Create a temporary entry to compare on the BinarySearch Tree
            Entry temporary = new Entry(word);

            return this.entries.search(temporary);
        } catch (Exception exception) {
            //Otherwise, throw an exception
            throw new Exception("Nothing found. Try a different word.");
        }

    }

    /**
     * ***********************************************************
     */
    /* Method: searchSynonym */
 /* Purpose: Search for a synonym in the dictionary */
 /* Parameters: */
 /* String word: The word that will be compared */
 /* Returns: Tree: did we find it? */
    /**
     * ***********************************************************
     */
    public Tree<Entry> searchSynonym(String word) throws Exception {

        Tree<Entry> result = new Tree<>();

        //Get the interator of the entry list
        Iterator<Entry> EntriesIterator = this.entries.iterator(false);

        //For each entry
        while (EntriesIterator.hasNext()) {

            //Get the entry
            Entry item = EntriesIterator.next();

            //Check if word has the synonym
            if (item.hasSynonym(word)) {
                //Add synonym to the array
                result.add(item);
            }
        }

        //Check if something was found
        if (result.isEmpty()) {
            throw new Exception("Nothing found. Try a different word.");
        } else {
            //Return the synonyms list
            return result;
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: removeEntry */
 /* Purpose: Remove a specific entry from the dictionary */
 /* Parameters: */
 /* Entry entry: The entry that will be removed */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void removeEntry(Entry entry) {

        this.entries.remove(entry);

    }

    /**
     * ***********************************************************
     */
    /* Method: removeAll */
 /* Purpose: Remove all entries from database */
 /* Parameters: */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void removeAll() {

        this.entries = new Tree<>();

    }

    /**
     * ***********************************************************
     */
    /* Method: getAll */
 /* Purpose: Get all entries from the dictionary */
 /* Parameters: */
 /* Returns: Tree: Return all entries */
    /**
     * ***********************************************************
     */
    public Tree<Entry> getAll() {

        return this.entries;

    }

}
