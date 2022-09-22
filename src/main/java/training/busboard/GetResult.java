package training.busboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetResult {

    private Double longitude;
    private Double latitude;
    
    public GetResult (){
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude){
        this.longitude = longitude;
    }

    public Double getLatitude(){
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }
}
