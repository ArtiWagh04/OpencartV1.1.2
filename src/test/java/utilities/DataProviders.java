package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders{

@DataProvider(name="LoginData")
public String[][] getData() throws IOException {

    String path = System.getProperty("user.dir")
            + "/testData/opencart_login.xlsx";

    ExcelUtility ex = new ExcelUtility(path);

    int totalRows = ex.getRowCount("opencart_login");
    int totalCol = ex.getCelCount("opencart_login", 1);

    String[][] loginData = new String[totalRows-1][totalCol];

    for (int i = 1; i < totalRows; i++) {
        for (int j = 0; j < totalCol; j++) {
            loginData[i-1][j] = ex.getCellData("opencart_login", i, j);
        }
    }
    return loginData;
}
}

