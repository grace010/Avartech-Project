package testcase.avartech;

import org.openqa.selenium.WebDriver;
//dung super se goi đên bien cua class cha, k dung super se goi đên bien của class con (neu class cha và con cung bien)
public class learnJV1 extends learnJV{
    public long timeOut = super.shortTimeout;


    public void setTimeout(){
        test();

    }
    @Override
    public void sleep(){
        System.out.println("");
    }

    public learnJV1(){
      super();// luon goi qua contractor của class cha
        System.out.println("contractor con");
    }
    @Override
    public void test(){
        System.out.println("check out of me");
    }
    public static void main(String[] args) {
        learnJV1 learn = new learnJV1();
        learn.test();
    }

}
