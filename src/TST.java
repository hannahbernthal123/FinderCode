public class TST {

    // Automatically set the root to m because it is in the middle of the dictionary.
    TSTNode root = new TSTNode('4');

    public void insert(String word, String value) {
        TSTNode current = root;
        for (int i = 0; i < word.length(); i++) {

            // When the letter in word does not match the current node's letter value, we move left or right.
            while (word.charAt(i) != current.getNum()) {
                // When the value is less than the node we're looking at, we go left.
                if (word.charAt(i) < current.getNum()) {
                    // If the left node is null, fill it with the current letter.
                    if (current.getLeft() == null) {
                        // Set the left node to the current letter we are looking at.
                        current.setLeft(new TSTNode(word.charAt(i)));
                    }
                    // Otherwise, we move down the TST.
                    current = current.getLeft();
                }

                // When we go right, we do the same thing.
                else {
                    // If the right node is null, fill it with the current letter.
                    if (current.getRight() == null) {
                        // Set the right node to the current letter we are looking at.
                        current.setRight(new TSTNode(word.charAt(i)));
                    }
                    current = current.getRight();
                }
            }

            // Here, we know the letter does match the current node's letter value, so we move down.
            if (current.getCenter() == null) {
                current.setCenter(new TSTNode(word.charAt(i)));
            }
            current = current.getCenter();
        }
        // Set the boolean to true so you know it is the final node of a word.
        current.setVal(value);
    }

    public String find(String word) {
        TSTNode current = root;
        for (int i = 0; i < word.length(); i++) {
            // While the current node's letter does not equal the letter in the word, we keep looking through the TST.
            while ((int) word.charAt(i) != current.getNum()) {
                if ((int) word.charAt(i) < current.getNum()) {
                    // When the path to the left doesn't exist (the left node is null), we return false.
                    if (current.getLeft() == null) {
                        return "invalid";
                    }
                    // If we do not return false, there is a path, so we continue down it.
                    current = current.getLeft();
                }

                // Same for the right side.
                if ((int) word.charAt(i) > current.getNum()) {
                    // When the path to the left doesn't exist (the left node is null), we return false.
                    if (current.getRight() == null) {
                        return "invalid";
                    }
                    // If we do not return false, there is a path, so we continue down it.
                    current = current.getRight();
                }
            }

            // Here, we know the letter does match the current node's letter value, so we check the center for a path.
            if (current.getCenter() == null) {
                return "invalid";
            }
            else {
                current = current.getCenter();
            }
        }

        return current.getValue();
    }
}

