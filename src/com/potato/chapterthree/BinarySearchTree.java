package com.potato.chapterthree;


/**
 * Created by AllstarVirgo on 2017/5/10.
 */
public class BinarySearchTree<AnyType extends Comparable> {
    private BinaryNode<AnyType> root;

    private static class BinaryNode<AnyType> {
        AnyType element;

        BinaryNode left;

        BinaryNode right;

        public BinaryNode(AnyType element, BinaryNode left, BinaryNode right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public BinaryNode(AnyType element) {
            this(element, null, null);
        }
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return new BinaryNode<AnyType>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) t.left = insert(x, t.left);
        else if (compareResult > 0) t.right = insert(x, t.right);
        else ;
        return t;
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    /**
     * 删除以t为根结点的键x
     *
     * @param x
     * @param t
     * @return
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) return t;
        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) t.left = remove(x, t.left);
        else if (compareResult > 0) t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = (AnyType) findMin(t.right).element;

            t.right = remove(t.element, t.right);//删除右子树中键值为t.element的结点
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }


    private BinaryNode findMin(BinaryNode t) {
        if (t == null) return null;
        else if (t.left == null) return t;
        return findMin(t.left);
    }
}
