
/**
 * ***********************************************************
 */
/* Iury Cleveston */
 /* Login ID: 7020268298 */
 /* CS-102, Fall 2015 */
 /* Programming Assignment 5 */
 /* Tree class: This class provides the methods to manage the tree */
/**
 * ***********************************************************
 */
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

class Tree<Type extends Comparable<? super Type>> {

    //The root node variable
    private TreeNode<Type> root;

    /**
     * ***********************************************************
     */
    /* Method: Tree */
 /* Purpose: The constructor method*/
 /* Parameters: */
 /* Returns: */
    /**
     * ***********************************************************
     */
    public Tree() {
        root = null;
    }

    /**
     * ***********************************************************
     */
    /* Method: isEmpty */
 /* Purpose: Check if the tree is empty */
 /* Parameters: */
 /* Returns: Boolean */
    /**
     * ***********************************************************
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * ***********************************************************
     */
    /* Method: contains */
 /* Purpose: Check if the item is on the tree */
 /* Parameters: */
 /* Type target: the Item to be searched */
 /* Returns: Boolean: Does the tree contain the item? */
    /**
     * ***********************************************************
     */
    public boolean contains(Type target) {
        return contains(target, root);

    }

    /**
     * ***********************************************************
     */
    /* Method: contains */
 /* Purpose: Check if the item is on the tree */
 /* Parameters: */
 /* Type target: the Item to be searched */
 /* TreeNode current: the node to be examined */
 /* Returns: Boolean: Does the tree contain the item? */
    /**
     * ***********************************************************
     */
    public boolean contains(Type target, TreeNode<Type> current) {

        if (current == null) {
            return false;
        }

        //Check if it is equal
        if (current.getDatum().compareTo(target) == 0) {
            return true;
        }

        //Compare and decide which branch to follow
        if (current.getDatum().compareTo(target) < 0) {
            return contains(target, current.getRight());
        } else {
            return contains(target, current.getLeft());
        }

    }

    /**
     * ***********************************************************
     */
    /* Method: search */
 /* Purpose: Search the item on the tree */
 /* Parameters: */
 /* Type target: the item to be found */
 /* Returns: Type: the item found */
    /**
     * ***********************************************************
     */
    public Type search(Type target) {

        return search(target, root);

    }

    /**
     * ***********************************************************
     */
    /* Method: search */
 /* Purpose: Search the item on the tree */
 /* Parameters: */
 /* Type target: the item to be found */
 /* TreeNode current: the node to be examined */
 /* Returns: Type: the item found */
    /**
     * ***********************************************************
     */
    public Type search(Type target, TreeNode<Type> current) {

        if (current == null) {
            throw new NoSuchElementException();
        }

        //Check if it is equal
        if (current.getDatum().compareTo(target) == 0) {
            return current.getDatum();
        }

        //Compare and decide which branch to follow
        if (current.getDatum().compareTo(target) < 0) {
            return (Type) search(target, current.getRight());
        } else {
            return (Type) search(target, current.getLeft());
        }

    }

    /**
     * ***********************************************************
     */
    /* Method: add */
 /* Purpose: Add the item to the tree */
 /* Parameters: */
 /* Type target: the item to be stored */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void add(Type target) {

        //Add and update the root node
        this.root = add(target, this.root);

    }

    /**
     * ***********************************************************
     */
    /* Method: add */
 /* Purpose: Add the item to the tree */
 /* Parameters: */
 /* Type target: the item to be stored */
 /* TreeNode current: the node to be appended */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public TreeNode<Type> add(Type target, TreeNode<Type> current) {

        if (current == null) {

            //Create the new node and set attributes
            TreeNode<Type> leaf = new TreeNode<>();

            leaf.setDatum(target);
            leaf.setLeft(null);
            leaf.setRight(null);

            return leaf;
        }

        //Compare and decide which branch to add
        if (current.getDatum().compareTo(target) < 0) {
            current.setRight(add(target, current.getRight()));
        } else {
            current.setLeft(add(target, current.getLeft()));
        }
        return current;
    }

    /**
     * ***********************************************************
     */
    /* Method: size */
 /* Purpose: Get the tree size */
 /* Parameters: */
 /* Returns: Int: the tree size */
    /**
     * ***********************************************************
     */
    public int size() {
        return size(root);
    }

    /**
     * ***********************************************************
     */
    /* Method: size */
 /* Purpose: Get the tree size */
 /* Parameters: */
 /* TreeNode node: the node to be counted */
 /* Returns: Int: the tree size */
    /**
     * ***********************************************************
     */
    private int size(TreeNode node) {
        if (node == null) {
            return (0);
        } else {
            //Count all the branches
            return size(node.getLeft()) + 1 + size(node.getRight());
        }
    }

    /**
     * ***********************************************************
     */
    /* Method: remove */
 /* Purpose: Remove item from tree*/
 /* Parameters: */
 /* Type target: the target to be removed */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    public void remove(Type target) {

        //Remove and update the root node
        root = remove(target, root);

    }

    /**
     * ***********************************************************
     */
    /* Method: remove */
 /* Purpose: Remove item from tree*/
 /* Parameters: */
 /* Type target: the target to be removed */
 /* TreeNode current: the current node to be examined */
 /* Returns: Void */
    /**
     * ***********************************************************
     */
    private TreeNode<Type> remove(Type value, TreeNode<Type> current) {

        //Check if the node was found
        if (value.equals(current.getDatum())) {

            if (current.getLeft() == null) {
                current = current.getRight();
            } else {

                TreeNode<Type> righty = current.getLeft();

                while (righty.getRight() != null) {
                    righty = righty.getRight();
                }

                current.setDatum(righty.getDatum());

                current.setLeft(this.remove(current.getDatum(), current.getLeft()));
            }

            //Test which branch to follow
        } else if (this.contains(value, current.getLeft())) {
            current.setLeft(this.remove(value, current.getLeft()));
        } else {
            current.setRight(this.remove(value, current.getRight()));
        }

        return current;
    }

    /**
     * ***********************************************************
     */
    /* Method: iterator */
 /* Purpose: Creates a iterator for the tree*/
 /* Parameters: */
 /* Boolean type: the iterator type: PreOrder or InOrder */
 /* Returns: Iterator */
    /**
     * ***********************************************************
     */
    public Iterator iterator(boolean type) {

        //Create the iterator
        return new bstIterator(type);

    }

    /**
     * ***********************************************************
     */
    /* Class: bstIterator */
 /* Purpose: Represents the iterator itself */
    /**
     * ***********************************************************
     */
    private class bstIterator implements Iterator<Type> {

        //The iterator private variables
        private TreeNode<Type> node;
        private LinkedList<TreeNode> stack;

        /**
         * ***********************************************************
         */
        /* Method: bstIterator */
 /* Purpose: Constructor method */
 /* Parameters: */
 /* Boolean type: the iterator type */
        /**
         * ***********************************************************
         */
        public bstIterator(boolean type) {
            stack = new LinkedList<>();

            //Define the populate method
            if (type) {
                populatePreOrder(root);
            } else {
                populateInOrder(root);
            }

            //Find next node
            advance();

        }

        /**
         * ***********************************************************
         */
        /* Method: populatePreOrder */
 /* Purpose: Populate the linkedList in PreOrder*/
 /* Parameters: */
 /* TreeNode current: the next node to be examined */
 /* Returns: Void */
        /**
         * ***********************************************************
         */
        public void populatePreOrder(TreeNode<Type> current) {

            if (current == null) {
                return;
            }

            //Add the node to the linkedList
            stack.addLast(current);
            populateInOrder(current.getLeft());
            populateInOrder(current.getRight());

        }

        /**
         * ***********************************************************
         */
        /* Method: populateInOrder */
 /* Purpose: Populate the linkedList in InOrder*/
 /* Parameters: */
 /* TreeNode current: the next node to be examined */
 /* Returns: Void */
        /**
         * ***********************************************************
         */
        public void populateInOrder(TreeNode<Type> current) {

            if (current == null) {
                return;
            }

            populateInOrder(current.getLeft());

            //Add the node to the linkedList
            stack.addLast(current);
            populateInOrder(current.getRight());

        }

        /**
         * ***********************************************************
         */
        /* Method: next */
 /* Purpose: Get the next item*/
 /* Parameters: */
 /* Returns: Type: return the item itself */
        /**
         * ***********************************************************
         */
        public Type next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            //Get the datum
            Type result = node.getDatum();

            //Find next node
            advance();

            return result;
        }

        /**
         * ***********************************************************
         */
        /* Method: hasNext */
 /* Purpose: Check if the tree has more itens */
 /* Parameters: */
 /* Returns: Boolean: Does it have more itens? */
        /**
         * ***********************************************************
         */
        public boolean hasNext() {
            return node != null;
        }

        /**
         * ***********************************************************
         */
        /* Method: advance */
 /* Purpose: Find next node */
 /* Parameters: */
 /* Returns: Void */
        /**
         * ***********************************************************
         */
        private void advance() {

            //Check the list size
            if (stack.size() == 0) {
                node = null;
            } else {
                //Get the first item
                node = stack.pop();
            }

        }
    }
}
