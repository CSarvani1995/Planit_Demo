package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	/**
	 * this method is used to read data from property file.
	 * @paramKey
	 * @return
	 * @throws Throwable
	 */
	
	public String getKeyandValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		Properties pro=new Properties();
		pro.load(fis); 
		String value =pro.getProperty(Key);
		return value;
	}

}
