/**
 * Assignment #: 11
 * Name: Arnav Babel
 * StudentID: 1225345329
 * Lecture: MWF 12:20-1:10
 * Description: Represents a node in a binary search tree that stores a Game 
 *              object and has references to two child nodes (left and right)
 */

public class Node {
    // Declare instance variables
    private Game game;
    private Node left, right;

    // Define constructor
    public Node(Game game) {
        this.game = game;
        left = null;
        right = null;
    }

    // Define accessors/mutators
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }
}