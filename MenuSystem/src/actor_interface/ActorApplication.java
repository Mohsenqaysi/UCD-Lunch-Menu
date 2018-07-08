package actor_interface;

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

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorApplication extends Application {
	public static String jsonOutput = "";
	
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/menus", new Restlet() {
			public void handle(Request request, Response response) {
				if(request.getMethod().equals(Method.GET)) {
					// GET request returns menus
					
					ActorSystem system = 
				            ActorSystem.create("ContentSystem");
				 
					final ActorRef master =
							system.actorOf(
									Props.create(Master.class),
									"master");

					String[] urls = {"http://localhost:9001/menu", "http://localhost:9002/menu"};

					master.tell(new Init(urls), ActorRef.noSender());

					while(!system.whenTerminated().isCompleted()){
					}
					if(jsonOutput.length() > 1){
						response.setEntity(jsonOutput, MediaType.APPLICATION_JSON);
						response.setStatus(Status.SUCCESS_OK);
					} else{
						response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);
					}
					
					
				} else {
					// Invalid HTTP method
					response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
				}
			}
		});
		
		return router;
	}
	
	public static void main(String[] args) {
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, 9000);
		component.getDefaultHost().attach("", new ActorApplication());
		try {
			component.start();
		} catch(Exception ex) {
			System.err.println("Failed to start RestaurantApplication!");
		}
	}
}