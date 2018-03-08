package Service;

import core.Rent;
import core.RentOut;
import java.util.ArrayList;
import java.util.List;

/**
 * The class add some data to the tables after you recreate the database
 * Person responsible for class: Emilia Vestlund
 */
public class DataSupplier {

    /* We are Adding some data to the rent out table */
    public static List<RentOut> getRentOuts() {
        List<RentOut> rentouts = new ArrayList<>();
        String[] rentoutsString = {
            "XX, XX, XX, XX, 11, XX, XX",
            "YY, YY, YY, YY, 22, YY, YY"
        };
        for (String s : rentoutsString) {
            String[] d = s.split(",");
            RentOut RO = new RentOut(d[0], d[1], d[2], d[3], Integer.parseInt(d[4]), d[5], d[6]);
            rentouts.add(RO);
        }
        return rentouts;
    }
    
    /* We are Adding some data to the rent table */
    public static List<Rent> getRents() {
        List<Rent> rents = new ArrayList<>();
        String[] rentsString = {
            "XX, XX,22,33, XX, XX, 11",
            "YY, YY, 22,33, YY, YY, 22"
        };
        for (String s : rentsString) {
            String[] d = s.split(",");
            Rent R = new Rent(d[0], d[1],Integer.parseInt(d[2]), Integer.parseInt(d[3]),  d[4], d[5], Integer.parseInt(d[6]));
            rents.add(R);
        }
        return rents;
    }
    
}
