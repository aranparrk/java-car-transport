package cartransport;

public class SportsCar extends Car implements Aircon, Audio {
    private static final int BASE_SPEED = 250;
    private static final int BASE_FUEL_EFFICIENCY = 8;
    private boolean audioOn;
    private boolean airconOn;

    public SportsCar(String name) {
        super(name);

        speed = BASE_SPEED;
        fuelEfficiency = BASE_FUEL_EFFICIENCY;
        fuelTankSize = 30;
        seatCount = 2;

    }

    @Override
    public void setMode(boolean isOn) {

        if (isOn) {
            speed = (int)(BASE_SPEED * 1.2);
        } else {
            speed = BASE_SPEED;
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
    public void audioOn() {
        System.out.println("Audio On");
        audioOn = true;
    }

    @Override
    public void audioOff() {
        System.out.println("Audio Off");
        audioOn = false;
    }

    @Override
    public boolean isAudioOn() {
        return audioOn;
    }
}
