package Ivan.LinkedList;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //创建几个节点
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        //创建列表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入节点
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);


        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.add(hero4);

        //测试修改名字
        HeroNode newHeroNode = new HeroNode(5,"小卢","玉麒麟");
        singleLinkedList.update(newHeroNode);

        //测试删除节点
        singleLinkedList.delete(5);

        //显示列表
        singleLinkedList.list();
        System.out.println();

        //测试题目，求单链表中的有效节点个数
        System.out.println("有效的节点个数为 : "+getLength(singleLinkedList.getHead()));
        System.out.println();

        //测试题目，求单链表中倒数第k个节点
        System.out.println("倒数第k个节点为");
        System.out.println("k = 3");
        //遍历
        System.out.println("倒数第k个节点为--遍历法");
        HeroNode res = findIndexNode1(singleLinkedList.getHead() ,3);
        System.out.println(res);
        System.out.println();
        //快慢指针
        System.out.println("倒数第k个节点为--快慢指针法");
        HeroNode res2 = findIndexNode2(singleLinkedList.getHead() ,3);
        System.out.println(res2);
        System.out.println();

    }

    //获取到单链表的节点个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        HeroNode cur = head.next;
        int count = 0;
        while (cur!=null){
            count+=1;
            cur = cur.next;
        }
        return count;
    }

    //查找单链表的倒数第k个节点
    //遍历的解法
    public static HeroNode findIndexNode1(HeroNode head,int index){
        if (head == null){
            return null;
        }
        int size = getLength(head);
        if (index <=0 || index >size){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    //快慢指针的解法
    public static HeroNode findIndexNode2(HeroNode head,int index){
        if (head == null){
            return null;
        }
        HeroNode fast = head.next;
        HeroNode slow = head.next;
        for (int i = 0; i < index; i++) {
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //单链表的反转（腾讯面试题）
    public static void reverseList(HeroNode head){
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助的指针
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，并把每个节点取出放在reverseHead的前面
        while (cur!=null){
            next = cur.next;        //暂时保存当前节点的下一个节点
            cur.next = reverseHead.next;        //将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }

}


//定义SingleLinkedList管理heroes
class SingleLinkedList{
    //先初始化头节点，头节点不能动
    private HeroNode head = new HeroNode(0,"","");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单链表
    //思路：当不考虑编号顺序时
        //1.找到当前链表的最后节点
        //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        //遍历链表找到最后
        while(true){
            if(temp.next == null){
                break;
            }
            //如果不为空则指向下一个，指导为空为止
            temp = temp.next;
        }
        //退出循环时，temp指向链表的最后
        temp.next = heroNode;
    }

    //按照顺序添加
    public void addByOrder(HeroNode heroNode) {
        //添加一个辅助变量temp
        HeroNode temp = head;
        boolean flag = false;       //flag标识添加的序号是否存在
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no > heroNode.no){    //找到需要插入的位置
                break;
            }
            else if (temp.next.no == heroNode.no){      //判断插入的节点是否已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断flag的值
        if (flag == true){
            System.out.println("准备插入的英雄编号已经存在。不能添加!");
        }
        else{
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //遍历链表&&显示
    public void list(){
        if (head.next == null){     //链表为空，退出
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            //判断是否到链表最后
            if (temp == null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //后移
            temp = temp.next;
        }
    }

    //修改节点信息，根据no来修改，no不能改变
    //1.根据newHeroNode的no来修改

    public void update(HeroNode newHeroNode) {
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //先遍历
        HeroNode temp = head.next;
        boolean flag = false;       //表示是否找到该节点
        while (true){
            if (temp == null){
                //遍历完还没有找到，执行添加语句
                addByOrder(newHeroNode);
                break;
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag == true){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }
    }
    
    //节点的删除
    //根据no来匹配
    public void delete(int no){
        boolean flag = false;       //判断是否找到该节点
        HeroNode temp = head;
        //进行遍历
        while (true){
            if (temp.next == null){     //等于空
                System.out.println("未找到该节点");
                return;
            }
            if (temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }
    }


}

//定义heronode，每个heronode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public  HeroNode next;

    //构造器
    public HeroNode(int hNo,String hName,String hNickName){
        this.name = hName;
        this.no = hNo;
        this.nickname = hNickName;
    }

    //为了显示方法，重新定义toString
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}