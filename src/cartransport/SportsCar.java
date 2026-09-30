package cartransport;

public class SportsCar extends Car {
    private static final int BASIC_SPEED = 250;

    public SportsCar(String name) {
        super(name);

        speed = BASIC_SPEED;
        fuelEfficiency = 8;
        fuelTankSize = 30;
        seatCount = 2;

    }

    @Override
    public void setMode(boolean isOn) {

        if (isOn) {
            speed = (int)(BASIC_SPEED * 1.2);
        } else {
            speed = BASIC_SPEED;
        }
    }
}
