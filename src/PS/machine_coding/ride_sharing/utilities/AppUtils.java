package PS.machine_coding.ride_sharing.utilities;  
  /*   
   Bluemoon
   09/08/21 5:05 PM  
   */

public class AppUtils {
    public static String geVehicleId(String vehicleNumber,String vehicleType){
        return vehicleType+"~"+vehicleNumber;
    }
}
