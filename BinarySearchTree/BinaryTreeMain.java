package BinarySearchTree;

public class BinaryTreeMain {

    public static void main(String[] args){

        Tree tree = new Tree();

        tree.insert(5);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(12);
        tree.insert(7);
        tree.insert(3);

        System.out.println("First tree");
        tree.printTree();
        System.out.println("\nSecond tree");
        tree.printTreeVisual();

        System.out.println("\nTree contains 11: " + tree.containsNode(11));
        System.out.println("Tree contains 9: " + tree.containsNode(9));

        tree.delete(9);
        tree.delete(1);

        System.out.println("\nThird tree");
        tree.printTree();
    }
}
