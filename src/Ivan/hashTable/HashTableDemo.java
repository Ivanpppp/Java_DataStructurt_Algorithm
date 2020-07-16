package Ivan.hashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        //创建hash表
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add:添加雇员");
            System.out.println("list:显示雇员");
            System.out.println("exit:退出程序");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }

    }
}

//创建hashtab，管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    //构造器
    public HashTab(int size) {
        //初始化
        this.size = size;
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);

    }

    //遍历所有链表
    public void list() {
        for (int i = 0; i <size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //编写一个散列函数，使用取模法
    public int hashFun(int id) {
        return id % size;
    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;    //next默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建EmpLinkedList
class EmpLinkedList {
    //头指针，执行第一个Emp，因此我们这个链表的head是直接指向第一个Emp
    private Emp head;   //默认为null

    //添加雇员到链表
    //添加雇员时，id是自增长，即id的分配总是从小到大
    //因此把雇员直接添加到本链表最后即可
    public void add(Emp emp) {
        if (head == null) {
            //链表为空是，直接把emp加到链表中即可
            head = emp;
            return;
        }
        Emp curEmp = head;
        while (true) {
            //不为空时，用while循环找到最后一个的位置
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        //把需要插入的查到最后即可
        curEmp.next = emp;
    }


    //遍历雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("链表"+no+"为空");
            return;
        }
        System.out.println("第"+no+"链表信息为");
        Emp curEmp = head;
        while (true) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }
}