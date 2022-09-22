package training.busboard;

import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Postcode {

    private int status;
    private GetResult result;


    public void Postcode() {
    }

    public void setResult(GetResult result) {
        this.result = result;
    }


    // public int getStatus() {
    //     return this.status;
    // }

    public GetResult getResult() {
        return this.result;
    }
}
