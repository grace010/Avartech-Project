package testcase.avartech;
//contractor mặc định: k có tham số, k có phần thân
//https://www.youtube.com/watch?v=WSdDCZ6QaDQ&list=PLMPBVRu4TjAxXA5KuqKFU7gwGiucyif_r

//biến global có giá trị mặc định, biến local trong hàm k có gia trị mặc định
//dung this để gọ qua 1 contractor khac thì phải dứng đầu tien
//Builder Pattern
//super gọi qua class cha

public abstract class learnJV {
    public long shortTimeout = 10;
    public long longTimeout = 15;

    abstract void sleep();
    public void test(){
        System.out.println("check out");
    }
    public learnJV(){
        System.out.println("contractor of class cha");
    }


    public static void main(String[] args) {

    }

}
