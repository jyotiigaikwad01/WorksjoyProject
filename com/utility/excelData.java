package LoginFunctionality.com.utility;

import LoginFunctionality.com.Xls_Reader;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class excelData {

    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel() {

        ArrayList<Object[]> myExcelData = new ArrayList<Object[]>();

        reader = new Xls_Reader("C:/Users/Admin.DESKTOP-6CD7RG7/IdeaProjects/Worksjoy Project/src/LoginFunctionality/WorksjoyLoginData.xlsx");
        int rowCount = reader.getRowCount("LoginData");

        for (int i = 2; i < rowCount; i++) {
            String username = reader.getCellData("LoginData", "username", i);

            String password = reader.getCellData("LoginData", "password", i);

            Object [] obj = {username,password};
            myExcelData.add(obj);


        }

        return myExcelData;


    }

}
