package PS.machine_coding.ride_sharing.pojo;  
  /*   
   Bluemoon
   09/08/21 7:57 PM  
   */

import java.io.Serializable;

public class TotalRidesResponse implements Serializable {
    private static final long serialVersionUID = 995079626423668472L;
    int offered;
    int taken;

    public TotalRidesResponse(int offered, int taken) {
        this.offered = offered;
        this.taken = taken;
    }

    public TotalRidesResponse _setOffered(int offered) {
        this.offered = offered;
        return this;
    }

    public TotalRidesResponse _setTaken(int taken) {
        this.taken = taken;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TotalRidesResponse{");
        sb.append("offered=").append(offered);
        sb.append(", taken=").append(taken);
        sb.append('}');
        return sb.toString();
    }
}
