package menu;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.routing.Router;

public class MenuApplication extends Application {
	private MenuService restaurant;
	
	public MenuApplication(String name) {
		restaurant = new MenuService(name);
	}
	
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/menu", new Restlet() {
			public void handle(Request request, Response response) {
				if(request.getMethod().equals(Method.GET)) {
					// GET request returns menu
					
					// Get the menu string
					String menu = restaurant.getMenu();
					
					// Check for valid menu
					if(menu.length() > 0) {
						// Set the response and status to success
						response.setEntity(restaurant.getMenu(), MediaType.APPLICATION_JSON);
						response.setStatus(Status.SUCCESS_OK);
					} else {
						// Set status to not found
						response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);
					}
				} else if(request.getMethod().equals(Method.POST)) {
					// POST request updates the menu
					
					// Get the menu from the request
					String menu = request.getEntityAsText();
					
					// Attempt to update the menu
					if(restaurant.setMenu(menu)) {
						// Set the status to success
						response.setStatus(Status.SUCCESS_OK);
					} else {
						// Set the status to internal error (file couldn't be written)
						response.setStatus(Status.SERVER_ERROR_INTERNAL);
					}
				} else {
					// Invalid HTTP method
					response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
				}
			}
		});
		
		return router;
	}
	
	/**
	 * 	args[0] -> Name of the restaurant
	 * 	args[1] -> Port for the restaurant to be accessed at
	 */
	public static void main(String[] args) {
		if(args.length >= 2) {
			Component component = new Component();
			component.getServers().add(Protocol.HTTP, Integer.parseInt(args[1]));
			component.getDefaultHost().attach("", new MenuApplication(args[0]));
			try {
				component.start();
			} catch(Exception ex) {
				System.err.println("Failed to start RestaurantApplication!");
			}
		} else {			
		     System.err.println("Invalid Arguements!");
		}
	}
}
