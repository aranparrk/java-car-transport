package cartransport;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int distance; // 거리
        int passengerCount; // 승객수
        Car car;
        double weatherRate; // 날씨

        // 1. 지역 선택 메뉴
        while (true){
            System.out.print("이동할 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
            String moveCityStr =  sc.nextLine();

            try {
                int moveCity = Integer.parseInt(moveCityStr);

                switch (moveCity) {
                    case 1:
                        distance = 400;
                        break;
                    case 2:
                        distance = 150;
                        break;
                    case 3:
                        distance = 200;
                        break;
                    case 4:
                        distance = 300;
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해 주세요.");
            }
        }

        // 승객수 입력
        while (true) {
            System.out.print("이동할 승객 수 입력 : ");
            String passengerCountStr = sc.nextLine();

            try {
                passengerCount = Integer.parseInt(passengerCountStr);

                if  (passengerCount < 1) {
                    System.out.println("1명 이상 입력해주세요.");
                    continue;
                }

                if (passengerCount > 100) {
                    System.out.println("탑승 불가합니다.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

        // 이동할 차량 선택
        while(true) {
            System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 :");
            String carStr = sc.nextLine();

            try {
                int carNum =  Integer.parseInt(carStr);

                switch (carNum) {
                    case 1:
                        car = new SportsCar("포르쉐");
                        break;
                    case 2:
                        car = new Sedan("소나타");
                        break;
                    case 3:
                        car = new Bus("버스");
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요.");
            }
        }

        // 부가 기능
        while (true) {
            System.out.print("부가 기능 [1]ON [2]OFF : ");
            String isOnStr = sc.nextLine();
            try {
                int isOn = Integer.parseInt(isOnStr);

                switch (isOn) {
                    case 1:
                        car.setMode(true);
                        break;
                    case 2:
                        car.setMode(false);
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        continue;
                }
                break;
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }

        // 날씨
        while(true) {
            System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
            String weatherStr = sc.nextLine();
            try {
                int weather = Integer.parseInt(weatherStr);

                switch (weather) {
                    case 1:
                        weatherRate = 1.0;
                        break;
                    case 2:
                        weatherRate = 1.2;
                        break;
                    case 3:
                        weatherRate = 1.4;
                        break;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                        continue;

                }
                break;
            }catch (NumberFormatException e){
                System.out.println("숫자를 입력해주세요.");
            }
        }

        double totalCost = car.calculateTotalCost(passengerCount, distance);
        int refuelCount = car.calculateRefuelCount(passengerCount, distance);
        double totalTime = car.calculateTotalTime(passengerCount, distance, weatherRate);

        int hour = (int) totalTime;
        int minute = (int) ((totalTime - hour) * 60);

        System.out.println("=======" + car.name + "=======");
        System.out.printf("총 비용 : %,.0f원%n", totalCost);
        System.out.println("총 주유 횟수 : " + refuelCount + "회");
        System.out.println("총 이동 시간 : " + hour + "시간 " + minute + "분");
    }
}
