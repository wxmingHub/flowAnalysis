package com.wangxm.container;

/**
 * 作者: wangxm
 * 日期: 2021/8/20
 * 备注:
 */
public class BSortTree<K extends Comparable, T> {
    /**
     * KEY值
     */
    protected K key;
    /**
     * VALUE值
     */
    protected T value;
    /**
     * 父节点
     */
    protected BSortTree<K, T> parent;
    /**
     * 左子树
     */
    protected BSortTree<K, T> left;
    /**
     * 右子树
     */
    protected BSortTree<K, T> right;

    /**
     * 构造函数
     *
     * @param key
     * @param value
     */
    public BSortTree(K key, T value) {
        this(key, value, null, null, null);
    }

    /**
     * 构造函数
     *
     * @param key
     * @param value
     * @param parent
     * @param left
     * @param right
     */
    public BSortTree(K key, T value, BSortTree<K, T> parent, BSortTree<K, T> left, BSortTree<K, T> right) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    /**
     * 左旋
     *
     * @param bSortTree
     */
    protected void leftRotate(BSortTree<K, T> bSortTree) {
        BSortTree<K, T> rightBSortTree = bSortTree.right;

        bSortTree.right = rightBSortTree.left;
        if (rightBSortTree.left != null) {
            rightBSortTree.left.parent = bSortTree;
        }

        rightBSortTree.parent = bSortTree.parent;
        if (bSortTree.parent != null) {
            if (bSortTree.parent.left == bSortTree) {
                bSortTree.parent.left = rightBSortTree;
            } else {
                bSortTree.parent.right = rightBSortTree;
            }
        }

        rightBSortTree.left = bSortTree;
        bSortTree.parent = rightBSortTree;
    }

    /**
     * 右旋
     *
     * @param bSortTree
     */
    protected void rightRotate(BSortTree<K, T> bSortTree) {
        BSortTree<K, T> leftBSortTree = bSortTree.left;

        bSortTree.left = leftBSortTree.right;
        if (leftBSortTree.right != null) {
            leftBSortTree.right.parent = bSortTree;
        }

        leftBSortTree.parent = bSortTree.parent;
        if (bSortTree.parent != null) {
            if (bSortTree.parent.left == bSortTree) {
                bSortTree.parent.left = leftBSortTree;
            } else {
                bSortTree.parent.right = leftBSortTree;
            }
        }

        leftBSortTree.right = bSortTree;
        bSortTree.parent = leftBSortTree;
    }

    /**
     * 查找元素
     *
     * @param key
     * @return
     */
    public BSortTree<K, T> search(K key) {
        return search(this, key);
    }

    /**
     * 查找元素
     *
     * @param bSortTree
     * @param key
     * @return
     */
    protected BSortTree<K, T> search(BSortTree<K, T> bSortTree, K key) {
        if (bSortTree == null) {
            return null;
        }
        int result = bSortTree.key.compareTo(key);
        if (result > 0) {
            return search(bSortTree.left, key);
        } else if (result < 0) {
            return search(bSortTree.right, key);
        } else {
            return bSortTree;
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
        BSortTree<K, T> element = new BSortTree(key, value);
        // 插入元素
        insert(this, element);
    }

    /**
     * 插入元素
     *
     * @param bSortTree
     * @param element
     */
    protected BSortTree<K, T> insert(BSortTree<K, T> bSortTree, BSortTree<K, T> element) {
        if (bSortTree == null) {
            return element;
        }

        int result = bSortTree.key.compareTo(element.key);
        if (result > 0) {
            bSortTree.left = insert(bSortTree.left, element);
            bSortTree.left.parent = bSortTree;
        } else if (result < 0) {
            bSortTree.right = insert(bSortTree.right, element);
            bSortTree.right.parent = bSortTree;
        } else {
            element.parent = bSortTree.parent;
            element.left = bSortTree.left;
            element.right = bSortTree.right;
            bSortTree = element;
        }
        return bSortTree;
    }

    /**
     * 删除元素
     *
     * @param key
     */
    public void delete(K key) {
        delete(this, key);
    }

    /**
     * 删除元素
     *
     * @param bSortTree
     * @param key
     */
    protected void delete(BSortTree<K, T> bSortTree, K key) {
        BSortTree<K, T> deletedNode = search(bSortTree, key);
        if (deletedNode == null) {
            return;
        }

        if (deletedNode.left == null && deletedNode.right == null) {
            if (deletedNode.parent.left == deletedNode) {
                deletedNode.parent.left = null;
            } else {
                deletedNode.parent.right = null;
            }
        } else if (deletedNode.left != null && deletedNode.right != null) {
            BSortTree<K, T> minNode = findMinNode(deletedNode);
            delete(deletedNode, minNode.key);
        } else if (deletedNode.left != null) {
            if (deletedNode.parent.left == deletedNode) {
                deletedNode.parent.left = deletedNode.left;
            } else {
                deletedNode.parent.right = deletedNode.left;
            }
        } else {
            if (deletedNode.parent.left == deletedNode) {
                deletedNode.parent.left = deletedNode.right;
            } else {
                deletedNode.parent.right = deletedNode.right;
            }
        }
    }

    /**
     * 获取最大节点
     *
     * @param bSortTree
     * @return
     */
    protected BSortTree<K, T> findMaxNode(BSortTree<K, T> bSortTree) {
        if (bSortTree == null) {
            return null;
        }

        if (bSortTree.right != null) {
            return findMaxNode(bSortTree.right);
        } else {
            return bSortTree;
        }
    }

    /**
     * 获取最小节点
     *
     * @param bSortTree
     * @return
     */
    protected BSortTree<K, T> findMinNode(BSortTree<K, T> bSortTree) {
        if (bSortTree == null) {
            return null;
        }

        if (bSortTree.left != null) {
            return findMinNode(bSortTree.left);
        } else {
            return bSortTree;
        }
    }
}
