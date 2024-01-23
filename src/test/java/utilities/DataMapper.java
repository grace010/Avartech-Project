package utilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.GlobalVariables;

import java.io.File;

public class DataMapper {
    @JsonProperty("userName")
    private String userName;

    @JsonProperty("passWord")
    private String password;


    public static DataMapper getUserData()  {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalVariables.PROJECT_PATH + File.separator + "DataTest" + File.separator + "adminData.json"), DataMapper.class);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
