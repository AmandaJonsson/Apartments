package Rest;


import Service.DataSupplier;
import com.google.gson.Gson;
import core.RentOut;
import dao.RentOutCollection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("db")
public class DatabaseResource {
    
    @EJB
    private RentOutCollection rocoll;

    private final Gson gson = new Gson();

    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response recreateDatabase() {
        rocoll.clear();
        
        for (RentOut ro : DataSupplier.getRentOuts()) {
            rocoll.create(ro);
        }
        
        return Response.ok(gson.toJson("Database recreated")).build();
    }
    
    
}
