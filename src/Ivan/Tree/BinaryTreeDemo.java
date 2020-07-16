package Ivan.Tree;

import java.util.*;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //手动创建该二叉树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(node1);

        //测试
        //前序遍历
        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println();
        //中序遍历
        System.out.println("中序遍历");
        binaryTree.midOrder();
        System.out.println();
        //后序遍历
        System.out.println("后序遍历");
        binaryTree.lastOrder();
        System.out.println();

        System.out.println("请输入需要查询的节点编号");
        Scanner scanner = new Scanner(System.in);
        int no = scanner.nextInt();

        //前序遍历查找
        HeroNode heroNode = binaryTree.preOrderSearch(no);
        if (heroNode != null) {
            System.out.println(heroNode);
        } else {
            System.out.println("未找到" + no);
        }

        //删除节点
        System.out.println("请输入需要删除的节点编号");
        no = scanner.nextInt();
        binaryTree.delNode(no);
        scanner.close();

        //展示删除后的树
        System.out.println("删除以后的树");
        binaryTree.preOrder();
    }
}

//定义一个二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root == null) {
            System.out.println("当前节点为空");
        } else {
            this.root.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root == null) {
            System.out.println("当前节点为空");
        } else {
            this.root.midOrder();
        }
    }

    //后序遍历
    public void lastOrder() {
        if (this.root == null) {
            System.out.println("当前节点为空");
        } else {
            this.root.lastOrder();
        }
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序遍历查找
    public HeroNode midOrderSearch(int no) {
        if (this.root != null) {
            return this.root.midOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序遍历查找
    public HeroNode lastOrderSearch(int no) {
        if (this.root != null) {
            return this.root.lastOrderSearch(no);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
                return;
            }
            root.delNode(no);
        } else {
            System.out.println("已经是空树");
        }
    }

}


//先创建HeroNode节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;      //默认null
    private HeroNode right;     //默认null

    public HeroNode(int no, String name) {
        super();
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        //向左子树递归
        if (this.left != null) {
            this.left.preOrder();
        }
        //向右子树递归
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void lastOrder() {
        if (this.left != null) {
            this.left.lastOrder();
        }

        if (this.right != null) {
            this.right.lastOrder();
        }
        System.out.println(this);
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    //中序遍历查找
    public HeroNode midOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }

    //后序遍历查找
    public HeroNode lastOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.lastOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.lastOrderSearch(no);
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //递归删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //递归
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }

    }
}