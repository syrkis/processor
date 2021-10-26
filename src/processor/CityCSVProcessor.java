package processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CityCSVProcessor {

	public void readAndProcess(File file) {
		//Try with resource statement (as of Java 8)
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			//Discard header row
			br.readLine();
			
			String line;

			Map<String, List<CityRecord>> map = new HashMap<String, List<CityRecord>>();

			while ((line = br.readLine()) != null) {
				// Parse each line
				String[] rawValues = line.split(",");
				
				int id = convertToInt(rawValues[0]);
				int year = convertToInt(rawValues[1]);
				String city = convertToString(rawValues[2]);
				int population = convertToInt(rawValues[3]);
				
				//TODO: Extend the program to process entries!
				CityRecord cityRecord = new CityRecord(id, year, population);
				if (!map.containsKey(city))  {
					map.put(city, new ArrayList<>());
				}
				map.get(city).add(cityRecord);
			}

			for (Entry<String, List<CityRecord>> entry : map.entrySet()) {
				int population = 0;
				for (CityRecord e : entry.getValue()) {
					population += e.population;
				}
				System.out.println("Avg. pop. in " + entry.getKey() + " (" + entry.getValue().size() + " entries) " + population / entry.getValue().size());
			}

		} catch (Exception e) {
			System.err.println("An error occurred:");
			e.printStackTrace();
		}
	}
	
	private String cleanRawValue(String rawValue) {
		return rawValue.trim();
	}
	
	private int convertToInt(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		return Integer.parseInt(rawValue);
	}
	
	private String convertToString(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		
		if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
			return rawValue.substring(1, rawValue.length() - 1);
		}
		
		return rawValue;
	}
	
	public static final void main(String[] args) {
		CityCSVProcessor reader = new CityCSVProcessor();
		
		File dataDirectory = new File("data/");
		File csvFile = new File(dataDirectory, "Cities.csv");
		
		reader.readAndProcess(csvFile);
	}
}
