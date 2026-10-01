package cartransport;

public class Bus extends Car implements Aircon, AutoPilot {
    private static final int BASE_TANK_SIZE = 100;
    private static final int BASE_SPEED = 150;
    private static final int BASE_FUEL_EFFICIENCY = 5;
    private boolean airconOn;
    private boolean autoPilotOn;
    public Bus(String name) {
        super(name);

        speed = BASE_SPEED;
        fuelEfficiency = BASE_FUEL_EFFICIENCY;
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

    @Override
    public void airconOn() {
        System.out.println("Aircon On");
        fuelEfficiency = (int)(BASE_FUEL_EFFICIENCY * 0.95);
        airconOn = true;
    }

    @Override
    public void airconOff() {
        System.out.println("Aircon Off");
        fuelEfficiency = BASE_FUEL_EFFICIENCY;
        airconOn = false;
    }

    @Override
    public boolean isAirconOn() {
        return airconOn;
    }

    @Override
    public void autoPilotOn() {
        System.out.println("Auto Pilot On");
        speed =  (int)(BASE_SPEED * 0.9);
        autoPilotOn = true;
    }

    @Override
    public void autoPilotOff() {
        System.out.println("Auto Pilot Off");
        speed = BASE_SPEED;
        autoPilotOn = false;
    }

    @Override
    public boolean isAutoPilotOn() {
        return autoPilotOn;
    }
}
