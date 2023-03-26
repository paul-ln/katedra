import api.MyApiVerticle;
import io.vertx.core.Vertx;

public class App {

    public static void main(String[] args)throws Exception{
        System.out.println("App...");
        final Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyApiVerticle());
        

    }

}

