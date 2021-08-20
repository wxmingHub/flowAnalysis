package com.wangxm.container;

/**
 * 作者: wangxm
 * 日期: 2021/8/18
 * 备注: 红黑树
 *
 * 红黑树的特性:
 * (1) 每个节点或者是黑色，或者是红色；
 * (2) 根节点是黑色；
 * (3) 所有叶结点的子结点（空）都是黑色的；
 * (4) 如果一个节点是红色的，则它的子节点必须是黑色的；
 * (5) 任意空结点到根结点的路径上的黑色结点数量相同。
 */
public class RBTree<K extends Comparable, T> {
    /**
     * KEY值
     */
    private K key;
    /**
     * VALUE值
     */
    private T value;
    /**
     * 颜色
     */
    private Color color;

    /**
     * 父节点
     */
    private RBTree parent;
    /**
     * 左子树
     */
    private RBTree left;
    /**
     * 右子树
     */
    private RBTree right;

    /**
     * 颜色
     */
    public enum Color {
        BLACK,
        RED,
    }

    /**
     * 构造函数
     *
     * @param key
     * @param value
     */
    public RBTree(K key, T value) {
        this(key, value, Color.BLACK, null, null, null);
    }

    /**
     * 构造函数
     *
     * @param key
     * @param value
     * @param color
     * @param parent
     * @param left
     * @param right
     */
    private RBTree(K key, T value, Color color, RBTree parent, RBTree left, RBTree right) {
        this.key = key;
        this.value = value;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    /**
     * 左旋
     *
     * @param rbTree
     */
    private void leftSpin(RBTree rbTree) {
        RBTree rightRBTree = rbTree.right;

        rbTree.right = rightRBTree.left;
        if (rightRBTree.left != null) {
            rightRBTree.left.parent = rbTree;
        }

        rightRBTree.parent = rbTree.parent;
        if (rbTree.parent != null) {
            if (rbTree.parent.left == rbTree) {
                rbTree.parent.left = rightRBTree;
            } else {
                rbTree.parent.right = rightRBTree;
            }
        }

        rightRBTree.left = rbTree;
        rbTree.parent = rightRBTree;
    }

    /**
     * 右旋
     *
     * @param rbTree
     */
    private void rightSpin(RBTree rbTree) {
        RBTree leftRBTree = rbTree.left;

        rbTree.left = leftRBTree.right;
        if (leftRBTree.right != null) {
            leftRBTree.right.parent = rbTree;
        }

        leftRBTree.parent = rbTree.parent;
        if (rbTree.parent != null) {
            if (rbTree.parent.left == rbTree) {
                rbTree.parent.left = leftRBTree;
            } else {
                rbTree.parent.right = leftRBTree;
            }
        }

        leftRBTree.right = rbTree;
        rbTree.parent = leftRBTree;
    }

    /**
     * 查找元素
     *
     * @param key
     * @return
     */
    public RBTree search(K key) {
        return search(this, key);
    }

    /**
     * 查找元素
     *
     * @param rbTree
     * @param key
     * @return
     */
    private RBTree search(RBTree rbTree, K key) {
        if (rbTree == null) {
            return null;
        }
        int result = rbTree.key.compareTo(key);
        if (result > 0) {
            return search(rbTree.left, key);
        } else if (result < 0) {
            return search(rbTree.right, key);
        } else {
            return rbTree;
        }
    }

    /**
     * 插入元素
     *
     * @param key
     * @param value
     */
    public void insert(K key, T value) {
        // 创建对象
        RBTree element = new RBTree(key, value);
        // 插入元素
        insert(this, element);
        // 颜色标记红色
        element.color = Color.RED;
        // 子节点颜色修正
        insertFixUp(element);
    }

    /**
     * 插入元素
     *
     * @param rbTree
     * @param element
     */
    private RBTree insert(RBTree rbTree, RBTree element) {
        if (rbTree == null) {
            return element;
        }

        int result = rbTree.key.compareTo(element.key);
        if (result > 0) {
            rbTree.left = insert(rbTree.left, element);
            rbTree.left.parent = rbTree;
        } else if (result < 0) {
            rbTree.right = insert(rbTree.right, element);
            rbTree.right.parent = rbTree;
        } else {
            element.parent = rbTree.parent;
            element.left = rbTree.left;
            element.right = rbTree.right;
            rbTree = element;
        }
        return rbTree;
    }

    /**
     * 插入修正
     *
     * @param rbTree
     */
    private void insertFixUp(RBTree rbTree) {

    }

    /**
     * 删除元素
     *
     * @param key
     */
    public void delete(K key) {

    }
}
