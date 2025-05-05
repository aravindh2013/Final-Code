package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Test_Configuration {

	public static Properties prop;

	public Test_Configuration() throws IOException {

               // File f = new File("File Path of Configuration.properties");
		
		File f = new File("C:\\Users\\pdine\\eclipse-workspace\\Assessmen\\Configuration.properties");

		FileInputStream fi = new FileInputStream(f);

		prop = new Properties();

		prop.load(fi);

	}

	public String getUrl() {
		String url = prop.getProperty("Url");
		return url;
	}

}
