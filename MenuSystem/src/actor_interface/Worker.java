package actor_interface;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import akka.actor.UntypedActor;

public class Worker extends UntypedActor {
    @Override
    public void onReceive(Object message){
        if (message instanceof Query) {
            Query query = (Query) message;

            // Query the Application for JSON string
            ClientResource restaurant = new ClientResource(query.url);
            String menu = "";
            try {
    			menu = restaurant.get().getText();
    		} catch (ResourceException | IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            // Send the result
            getSender().tell(new JsonResult(menu), getSelf());
        }
    }
}
