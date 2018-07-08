package gui;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.google.gson.Gson;

public class MenuManager {
	Gson gson = new Gson();
	private ClientResource restaurant;
	private Menu menu = new Menu();
	
	public void loadMenu(String url) {
		restaurant = new ClientResource(url);
		try {
			menu = gson.fromJson(restaurant.get().getText(), Menu.class);
		} catch (ResourceException | IOException e) {
			System.err.println("Failed to load menu!");
			menu = null;
		}
	}
	
	public void addItem(MenuItem item) {
		if(restaurant != null && menu != null) {
			menu.menu.add(item);
			restaurant.post(gson.toJson(menu));
		} else {
			System.err.println("You must load a menu first!");
		}
	}
}
