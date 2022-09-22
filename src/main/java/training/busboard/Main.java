package training.busboard;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.message.internal.SourceProvider.SourceWriter;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import scala.collection.concurrent.Map;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String args[]) {

        String postcode;

        System.out.println("Enter postcode: ");//postcode
        TakeUserInPut userI = new TakeUserInPut();
        postcode = userI.takeUserInput();
        getPostcode(postcode);
        //getNextFive(busStopCode);
    
    }


    public static void getNextFive(String busStopCode) {
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

        List<Bus> newBusTimes = client
                .target("https://api.tfl.gov.uk/StopPoint/" + busStopCode + "/Arrivals?app_id=be4b299f49ba4450b6404938f09423cb&app_key=e26ed466765b411d804f501b49df1a6c")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Bus>>() {});
        
        //newBusTimes.stream().forEach((bus) -> System.out.println(bus.getLineId()));
        

        List<Bus> nextFiveBus = newBusTimes.stream()
        .sorted(Comparator.comparing(Bus::getTimeToStation))
        .limit(5)
        .collect(Collectors.toList());


        // System.out.println(newBusTimes.getStationName());
        nextFiveBus.forEach((bus) -> System.out.println(bus.getLineId() + " -- " + (bus.getTimeToStation()/60)));

    }

    public static void getPostcode(String postcode){
        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();

        Postcode postcodeInfo = new Postcode();
        postcodeInfo = client
                .target("http://api.postcodes.io/postcodes/" + postcode)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<Postcode>() {});

        Double retrievedLatitude = postcodeInfo.getResult().getLatitude();
        Double retrievedLongitude = postcodeInfo.getResult().getLongitude();
        
        //gets the whole object from the tfl API
        GetLocationObject locationObject = client
                .target("https://api.tfl.gov.uk/StopPoint/?lat=" + retrievedLatitude + "&lon=" + retrievedLongitude + "&stopTypes=NaptanPublicBusCoachTram&radius=200&modes=bus")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<GetLocationObject>() {});

        //list of stoppoints within the set radius
        List<StopPoints> stopPointsInRadius = locationObject.getStopPoints()
        .stream()
        .limit(2)
        .collect(Collectors.toList());
        //to get the stop ID for each stoppoint
       stopPointsInRadius.forEach((stop) -> {System.out.println(stop.getIndicator()); getNextFive(stop.getNaptanID());} );
       

     }
}