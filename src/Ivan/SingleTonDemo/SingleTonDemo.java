package Ivan.SingleTonDemo;

public class SingleTonDemo {
    public static void main(String[] args) {
        President p1 = President.getInstance();
        p1.getName();
        President p2 = President.getInstance();
        p2.getName();
        if (p1 == p2) {
            System.out.println("他们是同一个人");
        } else {
            System.out.println("他们不是同一个人！");
        }
    }

}

//懒汉式
//类加载时没有生成单例，只有在调用getInstance的时候才会创建
//非线程安全的
class singleTon1 {
    private static singleTon1 instance = null;

    private singleTon1() {

    }

    public static singleTon1 getInstance() {
        if (instance == null) {
            instance = new singleTon1();
        }
        return instance;
    }
}

//线程安全的懒汉式
//双重锁——synchronized + volatile
class singleTon2 {
    private static volatile singleTon2 instance = null;

    private singleTon2() {

    }

    public static synchronized singleTon2 getInstance() {
        if (instance == null) {
            instance = new singleTon2();
        }
        return instance;
    }
}

//饿汉式
//在加载类的时候就已经生成了单例
//饿汉式单例在类创建时就已经创建好一个静态的对象供系统使用，以后不再改变
//达到线程安全
class singleTon3 {
    private static singleTon3 instance = new singleTon3();

    private singleTon3() {

    }

    public static singleTon3 getInstance() {
        return instance;
    }
}

//Holder模式
//由JVM来保证线程安全
class singleTon4 {
    private static class singleTonHolder {

        private static singleTon4 instance = new singleTon4();

    }

    private singleTon4() {

    }

    public static singleTon4 getInstance() {
        return singleTonHolder.instance;
    }
}

//Test
//用懒汉式+DCL锁
class President {
    private static volatile President president = null;

    private President() {
        System.out.println("产生一个总统！");
    }

    public static synchronized President getInstance() {
        if (president == null) {
            president = new President();
        } else {
            System.out.println("已经有一个总统!");
        }
        return president;
    }

    public void getName() {
        System.out.println("我是美国总统：特朗普!");
    }
}