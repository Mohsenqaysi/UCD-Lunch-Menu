package actor_interface;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class Master extends UntypedActor {
    ActorRef[] workers = null;
    int count;
    String json;

    @Override
    public void onReceive(Object message){
        if (message instanceof Init) {
            Init init = (Init) message;

            // Create the workers
            workers = new ActorRef[init.urls.length];
            for (int i=0; i<init.urls.length; i++) {
                workers[i] = getContext().actorOf(
                    Props.create(Worker.class), "worker_"+i);
            }              
            // Distribute the problems
            for (int i=0; i<workers.length; i++) {
                workers[i].tell(
                    new Query(((Init) message).urls[i]),
                    getSelf());
            }
            count = 0;
            json = "{\"services\":[";
        } 
        else if (message instanceof JsonResult) {
        	JsonResult result = (JsonResult) message;
        	json += result.json;
        	count++;
            if (count == workers.length) {
                json += "],\"alergies\": [\r\n" + 
                		"		{\r\n" + 
                		"			\"dary\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Fdary.png?alt=media&token=1f3a8c3a-04a5-4ded-90c7-3127c2aa09e9\",\r\n" + 
                		"			\"celery\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Fcelery.png?alt=media&token=40ea4034-755f-4bdd-8709-ffe5551f172b\",\r\n" + 
                		"			\"fish\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Ffish.png?alt=media&token=8e236fa5-43fb-450b-8133-85319e46c9e3\",\r\n" + 
                		"			\"nuts\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Fnuts.png?alt=media&token=ee18b428-22ed-42b8-87fc-b24f3eb6a202\",\r\n" + 
                		"			\"sesame\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Fsesame.png?alt=media&token=c30f2753-ef12-4106-9ee9-9389b58e7785\",\r\n" + 
                		"			\"wheat\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Fwheat.png?alt=media&token=e760d983-dd1f-4831-862b-c97fdd9c90a9\",\r\n" + 
                		"			\"soy\": \"https://firebasestorage.googleapis.com/v0/b/ucd-menu.appspot.com/o/allergies%2Fsoy.png?alt=media&token=4a6216d1-238f-4472-a227-70a8fcd27c92\"\r\n" + 
                		"		}\r\n" + 
                		"	]}";
                ActorApplication.jsonOutput = json;
                getContext().system().terminate();
            }
            else{
            	json += ",";
            }
        }
    }
}
