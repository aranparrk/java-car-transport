package cartransport;

public class Sedan extends Car {
    private static final int BASE_SEAT = 4;
    public Sedan(String name) {
        super(name);

        speed = 200;
        fuelEfficiency = 12;
        fuelTankSize = 45;
        seatCount = BASE_SEAT;
    }

    @Override
    public void setMode(boolean isOn){
        if (isOn) {
            seatCount = BASE_SEAT + 1;
        } else {
            seatCount = BASE_SEAT;
        }
    }
}
