package cartransport;

public class Sedan extends Car implements Aircon, Audio, AutoPilot{
    private static final int BASE_SEAT = 4;
    private static final int BASE_FUEL_EFFICIENCY = 12;
    private static final int BASE_SPEED = 200;
    private boolean audioOn;
    private boolean airconOn;
    private boolean autoPilotOn;
    public Sedan(String name) {
        super(name);

        speed = BASE_SPEED;
        fuelEfficiency = BASE_FUEL_EFFICIENCY;
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
