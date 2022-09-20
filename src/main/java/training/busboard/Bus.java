package training.busboard;

public class Bus {
    private int timeToStation;
    private String busNumber;
    private String destinationName;


    public void setBus(int timeToStation, String busNumber, String destinationName) {
        this.timeToStation = timeToStation;
        this.busNumber = busNumber;
        this.destinationName = destinationName;
    }

    public int getTimeToStation() {
        return this.timeToStation;
    }

    public String getBusNumber() {
        return this.busNumber;
    }

    public String getDestinationName(){
        return this.destinationName;
    }

}
