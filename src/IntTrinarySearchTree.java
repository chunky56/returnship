import java.util.LinkedList;

/**
 * Created by chunky15 on 3/19/15.
 */
public class IntTrinarySearchTree {
    TreeNode head;

    IntTrinarySearchTree() {
        head = null;
    }

    public void insert(int value) {
        if (head == null) {
            head = new TreeNode(value);
        } else {
            head.insert(value);
        }
    }

    public void delete(int value) {
        if (head != null) {
            head = head.delete(value);
        }
    }

    /*
     * BFS String representation, delimited by commas.
     */
    public String toString() {

        if (head == null) {
            return "";
        }

        String s = "";
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            s += node.value + ",";
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.middleChild != null) {
                queue.add(node.middleChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }

        return s;
    }

    private class TreeNode {
        int value;
        TreeNode leftChild;
        TreeNode middleChild;
        TreeNode rightChild;

        TreeNode(int value) {
            this.value = value;
            this.leftChild = null;
            this.middleChild = null;
            this.rightChild = null;
        }

        /*
         * Recursively traverse tree until we hit a leaf, then insert node there.
         */
        void insert(int value) {
            if (value < this.value) {
                if (this.leftChild != null) {
                    this.leftChild.insert(value);
                } else {
                    this.leftChild = new TreeNode(value);
                }
            } else if (value > this.value) {
                if (this.rightChild != null) {
                    this.rightChild.insert(value);
                } else {
                    this.rightChild = new TreeNode(value);
                }
            } else {
                if (this.middleChild != null) {
                    this.middleChild.insert(value);
                } else {
                    this.middleChild = new TreeNode(value);
                }
            }
        }

        /*
         * Recursive traverse tree until we find value. If so, check cases:
         * 1) Leaf: return null, so parent's child assigned null
         * 2) One child: return subtree, so parent's child assigned that subtree
         * 3) Two children: find successor and copy it to current node, then recursively delete successor
         * 4) If duplicates, recursively traverse middleChild until we hit leaf, then do leaf case
         *
         * If value not found, return tree unchanged.
         */
        TreeNode delete(int value) {
            if (value < this.value && this.leftChild != null) {
                this.leftChild = this.leftChild.delete(value);
            } else if (value > this.value && this.rightChild != null) {
                this.rightChild = this.rightChild.delete(value);
            } else if (value == this.value) {
                if (this.leftChild == null && this.rightChild == null && this.middleChild == null) { // Leaf node
                    // Parent assigned null, effectively deleting this node
                    return null;
                }

                if (this.middleChild != null) { // Has duplicates, delete last duplicate
                    this.middleChild = this.middleChild.delete(value);
                } else {
                    if (this.leftChild != null && this.rightChild != null) { // Has both children
                        // Find successor and copy node info to this node, including middleChild (duplicates)
                        // Remove successor duplicates and delete successor
                        TreeNode successor = this.rightChild.findMin();
                        this.value = successor.value;
                        this.middleChild = successor.middleChild;
                        successor.middleChild = null;
                        this.rightChild = this.rightChild.delete(successor.value);
                    } else if (this.leftChild != null) { // Has left child
                        // Parent assigned left subtree, effectively deleting this node
                        return this.leftChild;
                    } else { // Has right child
                        // Parent assigned right subtree, effectively deleting this node
                        return this.rightChild;
                    }
                }
            }

            return this;
        }

        /*
         * Helper function for delete(). Recursively traverse leftChild until null.
         */
        TreeNode findMin() {
            if (this.leftChild == null) {
                return this;
            } else {
                return this.leftChild.findMin();
            }
        }
    }
}
