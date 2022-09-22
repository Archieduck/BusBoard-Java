package training.busboard;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetLocationObject {

    private List<StopPoints> stopPoints;


    public GetLocationObject() {

    }

    public void setBusStops(List<StopPoints> stopPoints){
        this.stopPoints = stopPoints;
    }

    public List<StopPoints> getStopPoints(){
        return this.stopPoints;
    }
    
}
