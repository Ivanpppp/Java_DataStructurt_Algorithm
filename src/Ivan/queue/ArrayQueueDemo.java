package Ivan.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args){
        //测试。创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出队列");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接受用户输入命令
            switch (key){
                case 's':       //显示数据
                    arrayQueue.showQueue();
                    break;
                case 'a':       //添加数据
                    try {
                        System.out.println("请输入一个数字");
                        int value = scanner.nextInt();
                        arrayQueue.addQueue(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':       //取出数据
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':       //查看队列头部的数据e
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头部数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':       //退出命令
                    System.out.println("程序退出");
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
    }
}

//使用数组模拟队列
class ArrayQueue{
    private int maxSize;    //表示最大容量
    private int front;      //表示头指针
    private int rear;       //表示尾指针
    private int[] arr;      //用于存放数据，模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        rear = -1;     //指向队列尾部，指向队列尾部的数据
        front = -1;    //指向队列头部,front是指向队列头部的前一个位置，之后取数据需要先+1
        arr = new int[maxSize];
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否未满
        if (isFull()){
            throw new RuntimeException("队列已经满了");
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }
}