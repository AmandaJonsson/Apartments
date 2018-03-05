package Service;

import core.Rent;
import core.RentOut;
import java.util.ArrayList;
import java.util.List;

/**
 * Just to try
 * @author emilia
 */
public class DataSupplier {


    public static List<RentOut> getRentOuts() {
        List<RentOut> rentouts = new ArrayList<>();
        String[] rentoutsString = {
            "XX, XX, XX, XX, 11, XX, XX"
        };
        for (String s : rentoutsString) {
            String[] d = s.split(",");
            RentOut RO = new RentOut(d[0], d[1], d[2], d[3], Integer.parseInt(d[4]), d[5], d[6]);
            rentouts.add(RO);
        }
        return rentouts;
    }
    
    
    public static List<Rent> getRents() {
        List<Rent> rents = new ArrayList<>();
        String[] rentsString = {
            "XX, XX, XX, XX, 11"
        };
        for (String s : rentsString) {
            String[] d = s.split(",");
            Rent R = new Rent(d[0], d[1], d[2], d[3], Integer.parseInt(d[4]));
            rents.add(R);
        }
        return rents;
    }
    
    

}
