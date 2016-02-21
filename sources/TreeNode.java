
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* TreeNode class: This class stores the datum itself */
/**
 * ***********************************************************
 */
class TreeNode<Type> {

    //The private variables
    private Type datum;
    private TreeNode<Type> left;
    private TreeNode<Type> right;

    /**
     * ***********************************************************
     */
    /* Method: TreeNode */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Returns Void */
    /**
     * ***********************************************************
     */
    public TreeNode() {

        //Set all variables to null
        this.datum = null;
        this.left = null;
        this.right = null;

    }

    /**
     * ***********************************************************
     */
    /* Method: getDatum */
 /* Purpose: Get the datum */
 /* Parameters: */
 /* Returns Type: the specific datum  */
    /**
     * ***********************************************************
     */
    public Type getDatum() {
        return this.datum;

    }

    /**
     * ***********************************************************
     */
    /* Method: setDatum */
 /* Purpose: Set the datum in the node */
 /* Parameters: */
 /* Type datum: The datum that will be stored */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void setDatum(Type datum) {
        this.datum = datum;

    }

    /**
     * ***********************************************************
     */
    /* Method: getLeft */
 /* Purpose: Get the left node */
 /* Parameters: */
 /* Returns: TreeNode: the node on the left */
    /**
     * ***********************************************************
     */
    public TreeNode getLeft() {

        return this.left;

    }

    /**
     * ***********************************************************
     */
    /* Method: getRight */
 /* Purpose: Get the right node */
 /* Parameters: */
 /* Returns: TreeNode: the node on the right */
    /**
     * ***********************************************************
     */
    public TreeNode getRight() {

        return this.right;

    }

    /**
     * ***********************************************************
     */
    /* Method: setLeft */
 /* Purpose: Set the left node */
 /* Parameters: */
 /* TreeNode<Type> left: The node that will be changed */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void setLeft(TreeNode<Type> left) {

        this.left = left;

    }

    /**
     * ***********************************************************
     */
    /* Method: setRight */
 /* Purpose: Set the right node */
 /* Parameters: */
 /* TreeNode<Type> right: The node that will be changed */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void setRight(TreeNode<Type> right) {

        this.right = right;

    }

}
