package DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class testNg_ReadWrtieToExcel {

	@DataProvider(name = "fetchDataFromExcel")
	public Object[][] exceldata() throws IOException {
		Object[][] data = fetchDataFromExcel.gettestdata();
		System.out.println(data);

		return data;

	}
}
