package example;

import java.io.File;
import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import actor_interface.ActorApplication;
import gui.UserInterface;
import menu.MenuApplication;

public class ExampleSetup {
	public static void main(String[] args) {
		// Start ManuApplication for Pi
		String[] pi_args = { "pi", "9001" };
		MenuApplication.main(pi_args);

		// Start MenuApplication for the Main Restaurant
		String[] main_restaurant_args = { "main_restaurant", "9002" };
		MenuApplication.main(main_restaurant_args);

		// Start the Actor Interface for the iOS App
		ActorApplication.main(args);

		// Wait two seconds to ensure everything is running
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Check if menu files exist
		File pi_menu = new File("pi_menu.json");
		File main_restaurant_menu = new File("main_restaurant_menu.json");
		if(!pi_menu.exists() || !main_restaurant_menu.exists()) {
			// Connect to the Pi MenuService and upload a sample menu
			ClientResource pi = new ClientResource("http://localhost:9001/menu");
			pi.post("{\r\n" + 
					"         \"id\": 1,\r\n" + 
					"         \"title\": \"Pi\",\r\n" + 
					"         \"type\": \"Food and Coffee\",\r\n" + 
					"         \"logo_URL\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/1.jpg?alt=media&token=d8f3d3a2-78bf-44f7-947a-fa9c31f1ccbd\",\r\n" + 
					"         \"opening_hours\": \"2:30 - 5:30\",\r\n" + 
					"         \"opening_days\": \"Monday - Friday\",\r\n" + 
					"         \"menu\": [\r\n" + 
					"            {\r\n" + 
					"               \"name\": \"Spicy Rice with Tomato Sauce.\",\r\n" + 
					"               \"servedwith\": \"Servedwith: Oregano, Tomato, Olive, Feta Cheese\",\r\n" + 
					"               \"cost\": 5.95,\r\n" + 
					"               \"calories\": 550,\r\n" + 
					"               \"alergies\": [\r\n" + 
					"                  \"dary\",\r\n" + 
					"                  \"soy\",\r\n" + 
					"                  \"nuts\"\r\n" + 
					"               ]\r\n" + 
					"            },\r\n" + 
					"            {\r\n" + 
					"                \"name\": \"Cravey Roasted Beef\",\r\n" + 
					"                \"servedwith\": \"Servedwith: Stuffing & Cravy\",\r\n" + 
					"                \"cost\": 6.95,\r\n" + 
					"                \"calories\": 550,\r\n" + 
					"                \"alergies\": [\r\n" + 
					"                   \"dary\",\r\n" + 
					"                   \"soy\",\r\n" + 
					"                   \"nuts\"\r\n" + 
					"                ]\r\n" + 
					"             },\r\n" + 
					"             {\r\n" + 
					"                \"name\": \"Vegetarian Baked Aubergine\",\r\n" + 
					"                \"servedwith\": \"Servedwith: Feta Crust & Feta Cheese\",\r\n" + 
					"                \"cost\": 6.25,\r\n" + 
					"                \"calories\": 750,\r\n" + 
					"                \"alergies\": [\r\n" + 
					"                   \"dary\",\r\n" + 
					"                   \"soy\",\r\n" + 
					"                   \"nuts\"\r\n" + 
					"                ]\r\n" + 
					"             },\r\n" + 
					"             {\r\n" + 
					"                \"name\": \"Vegetarian Deep Fried Brie\",\r\n" + 
					"                \"servedwith\": \"Servedwith: Oregano, Tomato, Olive, Feta Cheese\",\r\n" + 
					"                \"cost\": 5.50,\r\n" + 
					"                \"calories\": 550,\r\n" + 
					"                \"alergies\": [\r\n" + 
					"                   \"soy\",\r\n" + 
					"                   \"nuts\"\r\n" + 
					"                ]\r\n" + 
					"             }\r\n" + 
					"         ]\r\n" + 
					"      }\r\n");

			// Connect to the Main Restaurant MenuService and upload a sample menu
			ClientResource main_restaurant = new ClientResource("http://localhost:9002/menu");
			main_restaurant.post("{\r\n" + 
					"         \"id\": 2,\r\n" + 
					"         \"title\": \"Main Resturant\",\r\n" + 
					"         \"type\": \"All Goodness\",\r\n" + 
					"         \"logo_URL\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/2.JPG?alt=media&token=432cc9e7-c2b8-4cf0-844e-7dc2fc0353b2\",\r\n" + 
					"         \"opening_hours\": \"2:30 - 5:30\",\r\n" + 
					"         \"opening_days\": \"Monday - Friday\",\r\n" + 
					"         \"menu\": [\r\n" + 
					"            {\r\n" + 
					"               \"name\": \"Shredded Pork\",\r\n" + 
					"               \"servedwith\": \"Servedwith: Fennel & Ginger\",\r\n" + 
					"               \"cost\": 5.95,\r\n" + 
					"               \"calories\": 400,\r\n" + 
					"               \"alergies\": [\r\n" + 
					"                  \"dary\",\r\n" + 
					"                  \"soy\",\r\n" + 
					"                  \"nuts\"\r\n" + 
					"               ]\r\n" + 
					"            },\r\n" + 
					"            {\r\n" + 
					"                \"name\": \"Spicy Rice with Tomato Sauce.\",\r\n" + 
					"                \"servedwith\": \"Servedwith: Oregano, Tomato, Olive, Feta Cheese\",\r\n" + 
					"                \"cost\": 5.95,\r\n" + 
					"                \"calories\": 550,\r\n" + 
					"                \"alergies\": [\r\n" + 
					"                   \"dary\",\r\n" + 
					"                   \"soy\",\r\n" + 
					"                   \"nuts\"\r\n" + 
					"                ]\r\n" + 
					"             },\r\n" + 
					"             {\r\n" + 
					"                \"name\": \"Baked Vegetarian Focaccia Pizza\",\r\n" + 
					"                \"servedwith\": \"Servedwith: Side Salad & Dressing\",\r\n" + 
					"                \"cost\": 5.50,\r\n" + 
					"                \"calories\": 850,\r\n" + 
					"                \"alergies\": [\r\n" + 
					"                   \"dary\",\r\n" + 
					"                   \"soy\",\r\n" + 
					"                   \"nuts\"\r\n" + 
					"                ]\r\n" + 
					"             },\r\n" + 
					"             {\r\n" + 
					"                \"name\": \"Ultimate Fry's\",\r\n" + 
					"                \"servedwith\": \"Servedwith: Beef Chilli & Feta Cheese\",\r\n" + 
					"                \"cost\": 4.95,\r\n" + 
					"                \"calories\": 650,\r\n" + 
					"                \"alergies\": [\r\n" + 
					"                   \"dary\",\r\n" + 
					"                   \"soy\",\r\n" + 
					"                   \"nuts\"\r\n" + 
					"                ]\r\n" + 
					"             }\r\n" + 
					"         ]\r\n" + 
					"      }");
		}

		// Start the GUI for adding a new item to the menu
		UserInterface.main(args);

		// Example connecting to the ActorApplication to show what the iOS app receives when polling the API
		ClientResource actor_interface = new ClientResource("http://localhost:9000/menus");
		try {
			String menu = actor_interface.get().getText();
			System.out.println(menu);
		} catch (ResourceException | IOException e) {
			e.printStackTrace();
		}
	}
}
