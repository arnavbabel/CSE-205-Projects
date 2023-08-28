/**
 * Assignment #: 11
 * Name: Arnav Babel
 * StudentID: 1225345329
 * Lecture: MWF 12:20-1:10
 * Description: Allows the user to add Game objects to a BST, with the game's 
 *              price used as the key to determine its position in the tree
 */

public class ZyBoxLiveStore {

    private Node root; // Binary Search Tree root node

    // Constructor
    public ZyBoxLiveStore() {
        this.root = null;
    }

    //method that adds a game to the store
    public Node addGameToStore(Node root, Game gameToAdd) {        
        if (root == null) { //checks to see if the tree is empty
            Node node = new Node(gameToAdd); //creates a new node
            return node; //returns null if true
        } 
        
        double price = root.getGame().getPrice();
        double newGame = gameToAdd.getPrice();

        if (newGame < price) { //checks to see if the price of the new game is less than the price of the current game
            root.setLeft(addGameToStore(root.getLeft(), gameToAdd)); //adds the new game to the left of the current game
        } else if (newGame > price) { //checks to see if the price of the new game is greater than the price of the current game
            root.setRight(addGameToStore(root.getRight(), gameToAdd)); //adds the new game to the right of the current game
        } else { 
            System.out.print("Game at this price is in store inventory already.\n"); //prints if the game already exists
        }
        return root; //returns the node of the new game
    }

    // * removeGameFromStore(...) METHOD PROVIDED AS PART OF TEMPLATE
    // Removes a game from the BST based on the game's price (the BST key)
    public Node removeGameFromStore(Node node, double price) {
        if (node == null) {
            return null;
        }

        double nodePrice = node.getGame().getPrice();

        if (price < nodePrice) {
            node.setLeft(removeGameFromStore(node.getLeft(), price));
        } else if (price > nodePrice) {
            node.setRight(removeGameFromStore(node.getRight(), price));
        } else {
            // Found the node to be removed
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                // Node has two children, find successor and replace node
                Node successor = findMinNode(node.getRight());
                node.setGame(successor.getGame());
                node.setRight(removeGameFromStore(node.getRight(), successor.getGame().getPrice()));
            }
        }
        return node;
    }

    //method that finds the smallest node in the tree
    private Node findMinNode(Node right) {
        if (right.getLeft() == null) { //returns the node if it is the leftmost (smallest) node
            return right; //returns the node
        }
        return findMinNode(right.getLeft()); //returns the smallest node
    }

    //method that counts the number of games in the store
    public int countGamesInStore(Node node) {
        int counter = 0;
        if (node == null) { //checks to see if there are no nodes in the BST
            return counter; //returns 0 if true
        } else {
            counter += countGamesInStore(node.getLeft()); //adds all the games in the left side of the BST to counter
            counter++; //increases the counter by 1
            counter += countGamesInStore(node.getRight()); //adds all the games in the right side of the BST to counter
        }
        return counter; //returns the number of games in the store
    }

    //method that lists the games by price in ascending order
    public void listGamesByPrice(Node node) {
        if (node == null) { //checks to see if the tree is empty
            return; //returns nothing
        }

        listGamesByPrice(node.getLeft()); //first prints the games with lower prices
        System.out.print(node.getGame().toString()); //prints the games
        listGamesByPrice(node.getRight()); //then prints the games with higher prices
    }

    //method that finds a specific game based off of its price
    public Game searchByPrice(Node root, double price) {
        if (root == null) { //checks to see if the BST is empty
            return null; //returns null if true;
        } 

        Game leftSide = searchByPrice(root.getLeft(), price);

        if (leftSide != null) { //checks to see if the leftSide is not null
            return leftSide; //returns the leftSide if true
        }
        if (root.getGame().getPrice() == price) { //checks to see if the price of the game at that root is equal to the price
            return root.getGame(); //returns the node of that game if true
        }
        Game rightSide = searchByPrice(root.getRight(), price);
        return rightSide; //returns the game if it is in the rightSide

    }

    //method that finds the most popular game in the store
    public Node searchMostPopularGame(Node node) {
        if (node == null) { //checks to see if the tree is empty
            return null; //returns null if true
        } 

        Node leftSide = searchMostPopularGame(node.getLeft());
        Node rightSide = searchMostPopularGame(node.getRight());

        if (rightSide != null && node.getGame().getDownloads() < rightSide.getGame().getDownloads()) { //checks to see if the game is in the right side
            node = rightSide; //sets the game to node
        } 
        if (leftSide != null && node.getGame().getDownloads() < leftSide.getGame().getDownloads()) { //checks to see if the game is in the left side
            node = leftSide; //sets the game to node
        }
        return node; //returns the node
    } 

    //method that calculates the cost of all the games in the store
    public double calculateStoreValue(Node node) {
        double totalValue = 0.0;
        if (node == null) { //checks to see if the tree is empty
            return totalValue; //returns 0.0 if true
        } else {
            totalValue += calculateStoreValue(node.getLeft()); //adds the cost of all the games in the left side of the BST
            totalValue += node.getGame().getPrice(); //calculates the cost
            totalValue += calculateStoreValue(node.getRight()); //adds the cost of all the games in the right side of the BST
        }
        return totalValue;
    }

    // * searchByName(...) METHOD PROVIDED AS PART OF TEMPLATE
    // Searches for a game (by name) in the store. Returns null if there are no
    // games in the store or the game was not found. Otherwise, returns the Game
    // object with the game's matching name
    public Game searchByName(Node node, String name) {
        if (node == null) {
            return null;
        }
        Game leftResult = searchByName(node.getLeft(), name);
        if (leftResult != null) {
            return leftResult;
        }
        if (node.getGame().getName().equals(name)) {
            return node.getGame();
        }
        Game rightResult = searchByName(node.getRight(), name);
        return rightResult;
    }

    // * get/setRoot(...) METHODS PROVIDED AS PART OF TEMPLATE
    // getters and setters for the BST root
    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

}