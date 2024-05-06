package Lab8;

import Lab7.BinarySearchTree;
import Lab7.TNode;

public class AVL<T extends Comparable<T>> extends BinarySearchTree<T> {

    public AVL() {
        root = null;
    }

    public AVL(T data) {
        root = new TNode<>(data);
    }

    @Override
    public void insert(T data) {
        if(isEmpty()) root = new TNode<>(data);
        else {
            TNode<T> rootNode = root;
            addEntry(data, rootNode);
            root = rebalance(rootNode);
        }
    }

    @Override
    public TNode<T> delete(T data) {
        TNode<T> temp = super.delete(data);
        if(temp != null){
            TNode<T> rootNode = root;
            root = rebalance(rootNode);
        }
        return temp;
    }

    public void addEntry(T data, TNode<T> rootNode){
        assert rootNode != null;
        if(data.compareTo((T)rootNode.getData()) < 0){ // right into left subtree
            if(rootNode.hasLeft()){
                TNode<T> leftChild = rootNode.getLeft();
                addEntry(data, leftChild);
                rootNode.setLeft(rebalance(leftChild));
            }
            else rootNode.setLeft(new TNode<T>(data));
        }
        else { // right into right subtree
            if(rootNode.hasRight()){
                TNode<T> rightChild = rootNode.getRight();
                addEntry(data, rightChild);
                rootNode.setRight(rebalance(rightChild));
            }
            else rootNode.setRight(new TNode<T>(data));
        }
    }

    private TNode<T> rebalance(TNode<T> nodeN){
        int diff = getHeightDifference(nodeN);
        if ( diff > 1) { // addition was in node's left subtree
            if(getHeightDifference(nodeN.getLeft())>0)
                nodeN = rotateRight(nodeN);
            else
                nodeN = rotateLeftRight(nodeN);
        }
        else if ( diff < -1){ // addition was in node's right subtree
            if(getHeightDifference(nodeN.getRight())<0)
                nodeN = rotateLeft(nodeN);
            else
                nodeN = rotateRightLeft(nodeN);
        }
        return nodeN;
    }

    private int getHeightDifference(TNode<T> node){
        return height(node.getLeft()) - height(node.getRight());
    }

    private TNode<T> rotateRight(TNode<T> nodeN){
        TNode<T> nodeC = nodeN.getLeft();
        nodeN.setLeft(nodeC.getRight());
        nodeC.setRight(nodeN);
        return nodeC;
    }

    private TNode<T> rotateLeft(TNode<T> nodeN){
        TNode<T> nodeC = nodeN.getRight();
        nodeN.setRight(nodeC.getLeft());
        nodeC.setLeft(nodeN);
        return nodeC;
    }

    private TNode<T> rotateRightLeft(TNode<T> nodeN){
        TNode<T> nodeC = nodeN.getRight();
        nodeN.setRight(rotateRight(nodeC));
        return rotateLeft(nodeN);
    }

    private TNode<T> rotateLeftRight(TNode<T> nodeN){
        TNode<T> nodeC = nodeN.getLeft();
        nodeN.setLeft(rotateLeft(nodeC));
        return rotateRight(nodeN);
    }

}