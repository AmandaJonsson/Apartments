package Service;

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
            String[] d = s.split(";");
            RentOut RO = new RentOut(d[0], d[1], d[2], d[3], 2, d[5], d[6]);
            rentouts.add(RO);
        }
        return rentouts;
    }

}
