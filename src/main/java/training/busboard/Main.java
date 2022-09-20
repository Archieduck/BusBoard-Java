package training.busboard;

import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        Client client = ClientBuilder.newBuilder().register(JacksonFeature.class).build();
//        client.target("https://api.tfl.gov.uk/StopPoint/490008660N/Arrivals?app_id=be4b299f49ba4450b6404938f09423cb&app_key=e26ed466765b411d804f501b49df1a6c")
//                .request(MediaType.TEXT_PLAIN)
//                .get(String.class);
//        System.out.println(busTimes);
        List<Widget> widgets = client
                .path("/widgets")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<List<Widget>>() {});
    }



}