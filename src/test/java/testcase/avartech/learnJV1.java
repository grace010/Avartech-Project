package testcase.avartech;

import org.openqa.selenium.WebDriver;
//dung super se goi đên bien cua class cha, k dung super se goi đên bien của class con (neu class cha và con cung bien)
public class learnJV1 extends learnJV{
    public long timeOut = super.shortTimeout;


    public void setTimeout(){
        test();

    }
    public static void main(String[] args) {

    }

}
