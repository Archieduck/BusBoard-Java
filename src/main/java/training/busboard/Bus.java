package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bus {
    private int timeToStation;
    private String lineId;
    private String destinationName;


    public void Bus() {
        // this.timeToStation = timeToStation;
        // this.lineId = lineId;
        // this.destinationName = destinationName;
    }

    public void setTimeToStation(int timeToStation) {
        this.timeToStation = timeToStation;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public void setDestinationName(String destinationName){
        this.destinationName = destinationName;
    }

    public int getTimeToStation() {
        return this.timeToStation;
    }

    public String getLineId() {
        return this.lineId;
    }

    public String getDestinationName(){
        return this.destinationName;
    }

}
