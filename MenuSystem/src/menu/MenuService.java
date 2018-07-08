package menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MenuService {
	private String name;
	
	public MenuService(String name) {
		this.name = name;
	}
	
	
	public boolean setMenu(String menuJson) {
		try {
			FileWriter menuFile = new FileWriter(new File(name + "_menu.json"));
			menuFile.write(menuJson);
			menuFile.flush();
			menuFile.close();
		} catch(IOException ex) {
			System.err.println(name + "'s menu not written!");
			
			return false;
		}
		
		return true;
	}
	
	public String getMenu() {
		String menu = new String("");
		try {
			menu = new String(Files.readAllBytes(Paths.get(name + "_menu.json")), StandardCharsets.UTF_8);
		} catch(IOException ex) {
			System.err.println(name + "'s menu file not found!");
		}
		return menu;
	}
}
