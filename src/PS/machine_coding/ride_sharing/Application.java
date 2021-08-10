package PS.machine_coding.ride_sharing;  
  /*   
   Bluemoon
   09/08/21 5:10 PM  
   */

import PS.machine_coding.ride_sharing.entities.Ride;
import PS.machine_coding.ride_sharing.entities.User;
import PS.machine_coding.ride_sharing.enums.Gender;
import PS.machine_coding.ride_sharing.enums.RideType;
import PS.machine_coding.ride_sharing.pojo.AddVehicleRequest;
import PS.machine_coding.ride_sharing.pojo.GetRideRequest;
import PS.machine_coding.ride_sharing.pojo.OfferRideRequest;
import PS.machine_coding.ride_sharing.pojo.TotalRidesResponse;
import PS.machine_coding.ride_sharing.repositories.RideHistoryRepository;
import PS.machine_coding.ride_sharing.repositories.RideRepository;
import PS.machine_coding.ride_sharing.repositories.UserRepository;
import PS.machine_coding.ride_sharing.repositories.VehicleRepository;
import PS.machine_coding.ride_sharing.services.RideHistoryService;
import PS.machine_coding.ride_sharing.services.RideRequestHandlingService;
import PS.machine_coding.ride_sharing.services.RideService;
import PS.machine_coding.ride_sharing.services.UserService;
import PS.machine_coding.ride_sharing.services.VehicleService;
import PS.machine_coding.ride_sharing.services.impl.EarliestRideHandlingService;
import PS.machine_coding.ride_sharing.services.impl.FastestRideHandlingService;
import PS.machine_coding.ride_sharing.services.impl.RideHistoryServiceImpl;
import PS.machine_coding.ride_sharing.services.impl.RideServiceImpl;
import PS.machine_coding.ride_sharing.services.impl.UserServiceImpl;
import PS.machine_coding.ride_sharing.services.impl.VehicleServiceImpl;
import PS.machine_coding.ride_sharing.utilities.IdGenerator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        IdGenerator idGenerator = new IdGenerator();

        RideHistoryRepository rideHistoryRepository = new RideHistoryRepository();
        RideRepository rideRepository = new RideRepository();
        UserRepository userRepository = new UserRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        UserService userService = new UserServiceImpl(idGenerator, userRepository, rideHistoryRepository);
        VehicleService vehicleService = new VehicleServiceImpl(idGenerator, vehicleRepository, userRepository);
        RideHistoryService rideHistoryService = new RideHistoryServiceImpl(idGenerator, rideHistoryRepository, userRepository);

        RideRequestHandlingService fastestRideRequesthandlingService = new FastestRideHandlingService(rideRepository);
        RideRequestHandlingService earliestRideRequestHandlingService = new EarliestRideHandlingService(rideRepository);

        List<RideRequestHandlingService> rideRequestHandlingServiceList = new ArrayList<>();
        rideRequestHandlingServiceList.add(fastestRideRequesthandlingService);
        rideRequestHandlingServiceList.add(earliestRideRequestHandlingService);

        RideService rideService = new RideServiceImpl(rideRequestHandlingServiceList, rideHistoryService, userRepository, vehicleRepository, idGenerator, rideRepository);

        // add user

        userService.addUser(new User()._setAge(36)._setGender(Gender.M)._setName("Rohan"));
        userService.addUser(new User()._setAge(29)._setGender(Gender.M)._setName("Shashank"));
        userService.addUser(new User()._setAge(29)._setGender(Gender.F)._setName("Nandini"));
        userService.addUser(new User()._setAge(27)._setGender(Gender.F)._setName("Shipra"));
        userService.addUser(new User()._setAge(29)._setGender(Gender.M)._setName("Gaurav"));

        // add vehicle

        vehicleService.addVehicle(new AddVehicleRequest()._setVehicleName("Swift")._setVehicleNumber("KA-01-12345")._setName("Rohan"));
        vehicleService.addVehicle(new AddVehicleRequest()._setVehicleName("Baleno")._setVehicleNumber("TS-05-62395")._setName("Shashank"));
        vehicleService.addVehicle(new AddVehicleRequest()._setVehicleName("Polo")._setVehicleNumber("KA-05-41491")._setName("Shipra"));
        vehicleService.addVehicle(new AddVehicleRequest()._setVehicleName("Scooty")._setVehicleNumber("KA-12-12332")._setName("Shipra"));

        //Offer rideGaurav
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 8, 11, 12, 30, 20);
        rideService.offerRide(new OfferRideRequest("Rohan", "Hyderabad", "Bangalore", "Swift", "KA-01-12345", calendar.getTime(), 13, 1));
        calendar.set(2021, 8, 12, 10, 30, 20);
        rideService.offerRide(new OfferRideRequest("Shipra", "Bangalore", "Mysore", "Polo", "KA-05-41491", calendar.getTime(), 10, 1));

        calendar.set(2021, 8, 14, 10, 30, 20);
        rideService.offerRide(new OfferRideRequest("Shipra", "Bangalore", "Mysore", "Scooty", "KA-12-12332", calendar.getTime(), 4, 2));

        calendar.set(2021, 8, 13, 16, 30, 20);
        rideService.offerRide(new OfferRideRequest("Shashank", "Hyderabad", "Bangalore", "Baleno", "TS-05-62395", calendar.getTime(), 14, 2));

        // get ride
        Ride ride = rideService.getRide(new GetRideRequest("Nandini", "Bangalore", "Mysore", RideType.FASTEST));
        System.out.println(ride);
        Ride ride1 = rideService.getRide(new GetRideRequest("Gaurav", "Bangalore", "Mysore", RideType.EARLIEST));
        System.out.println(ride1);
        Ride ride2 = rideService.getRide(new GetRideRequest("Shashank", "Mumbai", "Mysore", RideType.FASTEST));
        System.out.println(ride2);
        Ride ride3 = rideService.getRide(new GetRideRequest("Rohan", "Hyderabad", "Bangalore", RideType.FASTEST));
        System.out.println(ride3);
        //
        TotalRidesResponse totalRidesResponse = userService.getTotalTides("Nandini");
        System.out.println(totalRidesResponse);
        TotalRidesResponse totalRidesResponse1 = userService.getTotalTides("Rohan");
        System.out.println(totalRidesResponse1);
        TotalRidesResponse totalRidesResponse2 = userService.getTotalTides("Shashank");
        System.out.println(totalRidesResponse2);
        TotalRidesResponse totalRidesResponse3 = userService.getTotalTides("Gaurav");
        System.out.println(totalRidesResponse3);

    }
}
