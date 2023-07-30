package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop ;
public static void ReadProp(String filePath){
		
		
		
		try {
			FileInputStream	fs = new FileInputStream(filePath);
			 prop = new Properties();
			prop.load(fs);
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
}
