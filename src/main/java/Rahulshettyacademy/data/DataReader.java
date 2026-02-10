package Rahulshettyacademy.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//Read Josn to String
		String jsonContent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				"\\src\\main\\java\\Rahulshettyacademy\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//String to HasMap - Jackson Databind
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data =
		        mapper.readValue(
		            jsonContent,
		            new TypeReference<List<HashMap<String, String>>>() {}
		        );
		return data;
					
	}

}
