package cartransport;

import java.util.Scanner;

public class CarMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int distance = selectCity(sc);
        int passengerCount = inputPassengerCount(sc);
        Car car = selectCar(sc);

        selectMode(sc, car);

        double weatherRate = selectWeather(sc);

        selectAircon(sc, car);
        selectAudio(sc, car);
        selectAutoPilot(sc, car);

        printResult(car, passengerCount, distance, weatherRate);
    }

    // 1. 지역 선택
    public static int selectCity(Scanner sc) {
        while (true) {
            System.out.print("이동할 지역 선택 [1]부산 [2]대전 [3]강릉 [4]광주 : ");
            String moveCityStr = sc.nextLine();

            try {
                int moveCity = Integer.parseInt(moveCityStr);

                switch (moveCity) {
                    case 1:
                        return 400;
                    case 2:
                        return 150;
                    case 3:
                        return 200;
                    case 4:
                        return 300;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해 주세요.");
            }
        }
    }

    // 2. 승객 수 입력
    public static int inputPassengerCount(Scanner sc) {
        while (true) {
            System.out.print("이동할 승객 수 입력 : ");
            String passengerCountStr = sc.nextLine();

            try {
                int passengerCount = Integer.parseInt(passengerCountStr);

                if (passengerCount < 1) {
                    System.out.println("1명 이상 입력해주세요.");
                    continue;
                }

                if (passengerCount > 100) {
                    System.out.println("탑승 불가합니다.");
                    continue;
                }

                return passengerCount;

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    // 3. 이동할 차량 선택
    public static Car selectCar(Scanner sc) {
        while (true) {
            System.out.print("이동할 차량 선택 [1]스포츠카 [2]승용차 [3]버스 : ");
            String carStr = sc.nextLine();

            try {
                int carNum = Integer.parseInt(carStr);

                switch (carNum) {
                    case 1:
                        return new SportsCar("포르쉐");
                    case 2:
                        return new Sedan("소나타");
                    case 3:
                        return new Bus("버스");
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    // 4. 부가 기능 설정
    public static void selectMode(Scanner sc, Car car) {
        while (true) {
            System.out.print("부가 기능 [1]ON [2]OFF : ");
            String isOnStr = sc.nextLine();

            try {
                int isOn = Integer.parseInt(isOnStr);

                switch (isOn) {
                    case 1:
                        car.setMode(true);
                        return;
                    case 2:
                        car.setMode(false);
                        return;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    // 5. 날씨 선택
    public static double selectWeather(Scanner sc) {
        while (true) {
            System.out.print("날씨 [1]맑음 [2]비 [3]눈 : ");
            String weatherStr = sc.nextLine();

            try {
                int weather = Integer.parseInt(weatherStr);

                switch (weather) {
                    case 1:
                        return 1.0;
                    case 2:
                        return 1.2;
                    case 3:
                        return 1.4;
                    default:
                        System.out.println("잘못 입력하셨습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }

    // 6. 에어컨 ON/OFF
// 6. 에어컨 ON/OFF
    public static void selectAircon(Scanner sc, Car car) {

        if (car instanceof Aircon) {
            while (true) {
                System.out.print(car.name + " 에어컨 [1]ON [2]OFF : ");
                String airconStr = sc.nextLine();

                try {
                    int airconNum = Integer.parseInt(airconStr);

                    Aircon aircon = (Aircon) car;

                    switch (airconNum) {
                        case 1:
                            aircon.airconOn();
                            return;
                        case 2:
                            aircon.airconOff();
                            return;
                        default:
                            System.out.println("잘못 입력하셨습니다.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        }
    }

    // 7. 오디오 ON/OFF
// 7. 오디오 ON/OFF
    public static void selectAudio(Scanner sc, Car car) {

        if (car instanceof Audio) {

            while (true) {
                System.out.print(car.name + " 오디오 [1]ON [2]OFF : ");
                String audioStr = sc.nextLine();

                try {
                    int audioNum = Integer.parseInt(audioStr);

                    Audio audio = (Audio) car;

                    switch (audioNum) {
                        case 1:
                            audio.audioOn();
                            return;
                        case 2:
                            audio.audioOff();
                            return;
                        default:
                            System.out.println("잘못 입력하셨습니다.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        }
    }

    // 8. 자율주행 ON/OFF
    public static void selectAutoPilot(Scanner sc, Car car) {

        if (car instanceof AutoPilot) {

            while (true) {
                System.out.print(car.name + " 자율주행 [1]ON [2]OFF : ");
                String autoPilotStr = sc.nextLine();

                try {
                    int autoPilotNum = Integer.parseInt(autoPilotStr);

                    AutoPilot autoPilot = (AutoPilot) car;

                    switch (autoPilotNum) {
                        case 1:
                            autoPilot.autoPilotOn();
                            return;
                        case 2:
                            autoPilot.autoPilotOff();
                            return;
                        default:
                            System.out.println("잘못 입력하셨습니다.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }
            }
        }
    }

    // 결과 출력
    public static void printResult(Car car, int passengerCount, int distance, double weatherRate) {
        double totalCost = car.calculateTotalCost(passengerCount, distance);
        int refuelCount = car.calculateRefuelCount(passengerCount, distance);
        double totalTime = car.calculateTotalTime(passengerCount, distance, weatherRate);

        int hour = (int) totalTime;
        int minute = (int) ((totalTime - hour) * 60);

        System.out.println("=======" + car.name + "=======");
        System.out.printf("총 비용 : %,.0f원%n", totalCost);
        System.out.println("총 주유 횟수 : " + refuelCount + "회");
        System.out.println("총 이동 시간 : " + hour + "시간 " + minute + "분");

        if (car instanceof Aircon) {
            Aircon aircon = (Aircon) car;
            System.out.println(car.name + " 에어컨 : " + (aircon.isAirconOn() ? "ON" : "OFF"));
        }

        if (car instanceof Audio) {
            Audio audio = (Audio) car;
            System.out.println(car.name + " 오디오 : " + (audio.isAudioOn() ? "ON" : "OFF"));
        }

        if (car instanceof AutoPilot) {
            AutoPilot autoPilot = (AutoPilot) car;
            System.out.println(car.name + " 자율주행 : " + (autoPilot.isAutoPilotOn() ? "ON" : "OFF"));
        }
    }
}