package training.busboard;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StopPoints {

    private String naptanId;
    private String indicator;
    private String commonName;


    public void StopPoints(){

    }

    public void setNaptanId(String naptanId){
        this.naptanId = naptanId;
    }

    public String getNaptanID(){
        return this.naptanId;
    }

    public String getIndicator(){
        return this.indicator;
    }

    public void setIndicator(String indicator){
        this.indicator = indicator;
    }
    
    public String getCommonName(){
        return this.commonName;
    }

    public void setCommonName(String commonName){
        this.commonName = commonName;
    }
}
