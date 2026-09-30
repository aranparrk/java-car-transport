package cartransport;

public class Bus extends Car {
    private static final int BASE_TANK_SIZE = 100;
    public Bus(String name) {
        super(name);

        speed = 150;
        fuelEfficiency = 5;
        fuelTankSize = BASE_TANK_SIZE;
        seatCount = 20;
    }

    @Override
    public void setMode(boolean isOn) {
        if (isOn) {
            fuelTankSize = BASE_TANK_SIZE + 30;
        } else {
            fuelTankSize = BASE_TANK_SIZE;
        }
    }
}
