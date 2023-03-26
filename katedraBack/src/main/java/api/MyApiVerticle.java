package api;
import java.util.List;



import dao.userDAO;
import dao.visitedDAO;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import model.user;
import model.visited;
public class MyApiVerticle extends AbstractVerticle {
  private static final Logger LOGGER = LoggerFactory.getLogger(MyApiVerticle.class);
  @Override
  public void start() throws Exception {
    LOGGER.info("Dans le start...");
    
    Router router = Router.router(vertx);

    router.route().handler(routingContext -> {
      HttpServerResponse response = routingContext.response();
      response.putHeader("access-control-allow-origin", "*");
      response.putHeader("access-control-allow-methods", "GET, POST, PUT, DELETE, OPTIONS");
      response.putHeader("access-control-allow-headers", "Content-Type, Authorization");
      response.putHeader("access-control-max-age", "86400");
      routingContext.next();
  });
    
    router.get("/api/users").handler(this::getAllUsersAPI);
    router.get("/api/user/:id").handler(this::getUserAPI);
    router.get("/api/userPseudo/:pseudo").handler(this::getUserByPseudoAPI);
    router.get("/api/visited").handler(this::getAllVisitedAPI);
    router.get("/api/visiteduser/:id").handler(this::getAllVisitedUserAPI);
    router.post("/api/visited").handler(this::addVisitedAPI);
    
    
    vertx.createHttpServer()
    .requestHandler(router)
    .listen(8080);
  }
  
  private void getAllVisitedAPI(RoutingContext routingContext) {
	  LOGGER.info("Dans getAllusers...");
	 visitedDAO dao = new visitedDAO();
	  List<visited> visiteds = dao.getAllVisited();
      JsonArray jsonArray = new JsonArray();
      final JsonObject jsonResponse = new JsonObject();
	    for (visited s : visiteds) {
	        JsonObject jsonObject = new JsonObject();
	        jsonObject.put("id", s.getId());
	        jsonObject.put("user", s.getUser().getPseudo());
	        jsonObject.put("departement", s.getDepartement());
	        jsonArray.add(jsonObject);
        }
	  jsonResponse.put("visited", jsonArray);
	  routingContext.response()
      .setStatusCode(200)
      .putHeader("content-type", "application/json")
      .end(Json.encodePrettily(jsonResponse));
	  
	  dao.close();
	}
  
  private void getAllVisitedUserAPI(RoutingContext routingContext) {
	  LOGGER.info("Dans getAllusers...");
	 visitedDAO dao = new visitedDAO();
	  final String id = routingContext.request().getParam("id");
	  List<visited> visiteds = dao.getVisitedByUserId(Integer.parseInt(id));
      JsonArray jsonArray = new JsonArray();
      final JsonObject jsonResponse = new JsonObject();
	    for (visited s : visiteds) {
	        JsonObject jsonObject = new JsonObject();
	        jsonObject.put("departement", s.getDepartement());
	        jsonArray.add(jsonObject);
        }
	  jsonResponse.put("visited", jsonArray);
	  routingContext.response()
      .setStatusCode(200)
      .putHeader("content-type", "application/json")
      .end(Json.encodePrettily(jsonResponse));
	  
	  dao.close();
	}
  
  
  private void getAllUsersAPI(RoutingContext routingContext) {
	  LOGGER.info("Dans getAllusers...");
	  userDAO dao = new userDAO();
	  List<user> users = dao.getAllUsers();
      JsonArray jsonArray = new JsonArray();
      final JsonObject jsonResponse = new JsonObject();
	    for (user s : users) {
	        JsonObject jsonObject = new JsonObject();
	        jsonObject.put("id", s.getId());
	        jsonObject.put("pseudo", s.getPseudo());
	        jsonObject.put("password", s.getPassword());
	        jsonArray.add(jsonObject);
        }
	  jsonResponse.put("users", jsonArray);
	  routingContext.response()
      .setStatusCode(200)
      .putHeader("content-type", "application/json")
      .end(Json.encodePrettily(jsonResponse));
	  
	  dao.close();
	}
  
  private void getUserAPI(RoutingContext routingContext) {
	  LOGGER.info("Dans getUser...");
	  userDAO dao = new userDAO();
	  // Param id de la requête
	  final String id = routingContext.request().getParam("id");
	  
	  
	  // Recherche du chien correspondant à l'id
	  final user s = dao.getUserById(Integer.parseInt(id));
	  
	  if (s == null) {
		  final JsonObject errorJsonResponse = new JsonObject();
		  errorJsonResponse.put("error", "No user can be found for the specified id:" + id);
		  // Envoi de la réponse avec erreur 404
		  routingContext.response()
		      .setStatusCode(404)
		      .putHeader("content-type", "application/json")
		      .end(Json.encode(errorJsonResponse));
		  return;
		}
      JsonObject jsonObject = new JsonObject();
      jsonObject.put("id", s.getId());
      jsonObject.put("pseudo", s.getPseudo());
      jsonObject.put("password", s.getPassword());
	  // Envoi de la réponse
	  routingContext.response()
	      .setStatusCode(200)
	      .putHeader("content-type", "application/json")
	      .end(Json.encode(jsonObject));
  }
  
  private void addVisitedAPI(RoutingContext routingContext) {
	    LOGGER.info("Dans addVisitedAPI...");

	    JsonObject body = routingContext.getBodyAsJson();
	    if (body == null) {
	        routingContext.response().setStatusCode(400).end();
	        return;
	    }

	    visited visited = new visited();
	    visited.setUser(body.getInteger("userId"));
	    visited.setDepartement(body.getString("departement"));

	    visitedDAO dao = new visitedDAO();
	    dao.addVisited(visited);
	    dao.close();

	    routingContext.response().setStatusCode(201).end();
	}
  
  
  private void getUserByPseudoAPI(RoutingContext routingContext) {
	  LOGGER.info("Dans getUser...");
	  userDAO dao = new userDAO();
	  // Param id de la requête
	  final String pseudo = routingContext.request().getParam("pseudo");
	  
	  
	  // Recherche du chien correspondant à l'id
	  final user s = dao.getUserByPseudo(pseudo);
	  
	  if (s == null) {
		  final JsonObject errorJsonResponse = new JsonObject();
		  errorJsonResponse.put("error", "No user can be found for the specified pseudo:" + pseudo);
		  // Envoi de la réponse avec erreur 404
		  routingContext.response()
		      .setStatusCode(404)
		      .putHeader("content-type", "application/json")
		      .end(Json.encode(errorJsonResponse));
		  return;
		}
      JsonObject jsonObject = new JsonObject();
      jsonObject.put("id", s.getId());
      jsonObject.put("pseudo", s.getPseudo());
      jsonObject.put("password", s.getPassword());
	  // Envoi de la réponse
	  routingContext.response()
	      .setStatusCode(200)
	      .putHeader("content-type", "application/json")
	      .end(Json.encode(jsonObject));
  }
  
  
  @Override
  public void stop() throws Exception {
    LOGGER.info("Dans le stop...");
  }
  
  
}