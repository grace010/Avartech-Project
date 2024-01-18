package admin.pageuis;

public class ProjectManagementPageUI {
    public static final String EDIT_BUTTON = "//div[text()='Edit']";
    //  public static final String SHADOW_ROOT_PROJECT_NAME_TEXT_BOX = "//div[@placeholder='Enter Project name']/following-sibling::div";
    // public static final String PROJECT_NAME_TEXT_BOX = "//div[@placeholder='Enter Project name']/following-sibling::div";
    public static final String PROJECT_NAME_TEXT_BOX = "//input[@placeholder = 'Enter Project name']";
    public static final String CONFIRM_BUTTON = "//button[text()='Confirm']";
    //public static final String ROW_TABLE = "//tbody/tr[1]";
   // public static final String ROW_TABLE = "//tbody/tr[1]/td[2]";
    public static final String COLUMN_INDEX_BY_NAME = "//span[text()='%s']/parent::div/parent::th//preceding-sibling::th";
    public static final String COLUMN_ROW_INDEX_TEXT_BOX = "//tbody/tr[%s]/td[%s]";
    public static final String PROJECT_NAME = "//div[text()='Summary']/parent::div/parent::div/preceding-sibling::div[contains(@class,'flex')]//span[@class='max-w-full inline-block break-all relative']";
}