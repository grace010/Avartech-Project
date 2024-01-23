package common;

import java.io.File;

public class GlobalVariables {
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String DATA_TEST = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator + "DataTest.xlsx";
    public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator + "uploadFiles"+ File.separator;
    public static final String UPLOAD_FILE_BUTTON = "//input[@type = 'file']";
}
