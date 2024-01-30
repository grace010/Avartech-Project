package testcase.avartech;
//file text and binary
//b1: mo file
//b2: read and write dư lieu
//dong ket noi file

import common.GlobalVariables;

import java.io.File;

public class files extends GlobalVariables {
    public static void main(String[] args) {
        File file = new File(PROJECT_PATH + "\\src\\test\\java\\testcase\\avartech\\file.txt");
        if (file.isFile()){
            System.out.println("File");
        }

    }
}
