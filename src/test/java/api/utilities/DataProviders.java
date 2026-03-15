package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	ReadExcelFile readExcelFile = new ReadExcelFile();
	int ttlRowCount = readExcelFile.findRowCount();
	int ttlColCount = readExcelFile.findColumnCount();

	@DataProvider(name = "AllDataPvdr")
	public String[][] allDataProvider() throws IOException {

		System.out.println("Total number of Rows and Columns: " + ttlRowCount + "  , " + ttlColCount);
		String[][] userData = new String[ttlRowCount][ttlColCount];

		for (int rowNum = 1; rowNum <= ttlRowCount; rowNum++) {
			for (int colNum = 0; colNum < ttlColCount; colNum++) {
				userData[rowNum - 1][colNum] = readExcelFile.ReadExcelData(rowNum, colNum);
			}
		}
		
		return userData;
	}

	@DataProvider(name = "UsernameDataPvdr")
	public String[] usernamedataProvider() throws IOException {
		String[] userNameData = new String[ttlRowCount];
		for (int rowNum = 1; rowNum <= ttlRowCount; rowNum++) {
			userNameData[rowNum - 1] = readExcelFile.ReadExcelData(rowNum, 1);
		}

		return userNameData;

	}
}
