package cartransport;

import static java.lang.Math.ceil;

public abstract class Car {
    protected int speed;                // 속도
    protected double fuelEfficiency;    // 연비
    protected int fuelTankSize;         // 연료탱크 크기
    protected int seatCount;            // 좌석 수
    protected String name;              // 차량 이름

    public Car(String name) {
        this.name = name;
    }

    /* 총 이동 횟수
    * ceil(승객 수 / 좌석 수)
    * */
    public int calculateTripCount(int passengerCount) {
        return (int)ceil((double)passengerCount / seatCount);
    }

    /* 총 이동 거리
    * 거리 x 횟수
    * */
    public double calculateTripDistance(int passengerCount,int distance) {
        return calculateTripCount(passengerCount) * distance;
    }

    /* 총 연료 소모량 계산
    * 이동거리 / 연비
    * */
    public double calculateFuelUsed(int passengerCount, int distance) {
        return calculateTripDistance(passengerCount, distance) / fuelEfficiency;
    }

    /* 주유 횟수 계산
    * 총 이동 거리 : 거리 x 횟수
    * 총 연료 소모량 : 이동 거리 / 연비
    * ceil(총 연료 소모량 / 연료탱크 크기)
    * */
    public int calculateRefuelCount(int passengerCount, int distance) {
        return (int) ceil(calculateFuelUsed(passengerCount, distance) / fuelTankSize);
    }

    /* 총 비용 계산
    * 총 연료 소모량 x 2000원
    * */
    public double calculateTotalCost(int passengerCount, int distance) {
        return calculateFuelUsed(passengerCount, distance) * 2000;
    }

    /* 총 이동 시간 계산
    * 거리 / 속도 x 횟수 x 날씨 보정계수 (1.0, 1.2, 1.4)
    * */
    public double calculateTotalTime(int passengerCount, int distance, double weatherRate) {
        return calculateTripDistance(passengerCount, distance) / speed * weatherRate;
    }

    /* 부가모드 설정
    *
    * */
    public abstract void setMode(boolean isOn);
}
