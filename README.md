# 🚗 Java Car Transport

Java 객체지향 문법을 활용하여 자동차 운송 시스템을 구현한 실습 프로젝트입니다.

추상 클래스와 상속을 이용해 차량별 공통 기능을 분리하고,  
인터페이스를 이용해 에어컨, 오디오, 자율주행처럼 차량마다 다른 기능을 구현했습니다.

사용자가 선택한 지역, 승객 수, 차량, 부가 기능, 날씨를 기준으로  
이동 횟수, 주유 횟수, 비용, 이동 시간을 계산합니다.

---

## 🛠 Tech Stack

- Java 21
- IntelliJ IDEA

---

## 📂 프로젝트 구조

```text
cartransport
├── Car.java
├── SportsCar.java
├── Sedan.java
├── Bus.java
├── Aircon.java
├── Audio.java
├── AutoPilot.java
└── CarMain.java
```

---

## 🚘 클래스 구성

### Car

자동차의 공통 속성과 계산 기능을 정의한 추상 클래스입니다.

공통 속성

- 차량 이름
- 속도
- 연비
- 연료탱크 크기
- 좌석 수

공통 기능

- 총 이동 횟수 계산
- 총 이동 거리 계산
- 총 연료 소모량 계산
- 총 주유 횟수 계산
- 총 비용 계산
- 총 이동 시간 계산

추상 메서드

```java
public abstract void setMode(boolean isOn);
```

각 차량은 `Car`를 상속받아 차량별 부가 기능을 오버라이딩하여 구현합니다.

---

## 🔌 인터페이스 구성

차량마다 지원하는 기능이 다르기 때문에 각각의 기능을 인터페이스로 분리했습니다.

### Aircon

```java
void airconOn();
void airconOff();
boolean isAirconOn();
```

에어컨 ON/OFF 및 현재 상태 확인 기능을 정의합니다.

### Audio

```java
void audioOn();
void audioOff();
boolean isAudioOn();
```

오디오 ON/OFF 및 현재 상태 확인 기능을 정의합니다.

### AutoPilot

```java
void autoPilotOn();
void autoPilotOff();
boolean isAutoPilotOn();
```

자율주행 ON/OFF 및 현재 상태 확인 기능을 정의합니다.

---

## 🚙 차량별 기능

### SportsCar

구현 인터페이스

- Aircon
- Audio

부가 기능

- 부가 기능 ON 시 기본 속도 20% 증가
- 에어컨 ON 시 연비 감소
- 오디오 ON/OFF 지원

### Sedan

구현 인터페이스

- Aircon
- Audio
- AutoPilot

부가 기능

- 부가 기능 ON 시 좌석 수 1개 증가
- 에어컨 ON 시 연비 감소
- 오디오 ON/OFF 지원
- 자율주행 ON 시 기본 속도 10% 감소

### Bus

구현 인터페이스

- Aircon
- AutoPilot

부가 기능

- 부가 기능 ON 시 연료탱크 크기 30 증가
- 에어컨 ON 시 연비 감소
- 자율주행 ON 시 기본 속도 10% 감소

---

## 🔄 다형성과 인터페이스 처리

사용자가 선택한 차량은 부모 타입인 `Car`로 관리합니다.

```java
Car car = selectCar(sc);
```

실제로 생성되는 객체는 사용자의 선택에 따라 달라집니다.

```java
new SportsCar(...)
new Sedan(...)
new Bus(...)
```

차량별로 지원하는 인터페이스가 다르기 때문에 `instanceof`를 이용하여 기능 지원 여부를 확인합니다.

```java
if (car instanceof Audio) {
    Audio audio = (Audio) car;
}
```

이를 통해 하나의 `Car` 타입으로 여러 차량 객체를 관리하면서,  
실제 객체가 지원하는 기능만 선택적으로 사용할 수 있도록 구현했습니다.

---

## ⌨️ 사용자 입력

프로그램 실행 시 다음 정보를 순서대로 입력받습니다.

1. 이동 지역
2. 승객 수
3. 차량 종류
4. 차량별 부가 기능 ON/OFF
5. 날씨
6. 에어컨 ON/OFF
7. 오디오 ON/OFF
8. 자율주행 ON/OFF

차량이 지원하지 않는 기능은 입력 과정에서 제외됩니다.

잘못된 입력은 `try-catch`, `switch`, `while`을 이용해 다시 입력하도록 처리했습니다.

---

## 🧮 계산 항목

```text
총 이동 횟수
= ceil(승객 수 / 좌석 수)

총 이동 거리
= 이동 횟수 × 거리

총 연료 소모량
= 총 이동 거리 / 연비

총 주유 횟수
= ceil(총 연료 소모량 / 연료탱크 크기)

총 비용
= 총 연료 소모량 × 2,000원

총 이동 시간
= 총 이동 거리 / 속도 × 날씨 보정계수
```

날씨 보정계수

```text
맑음 : 1.0
비   : 1.2
눈   : 1.4
```

---

## 🖥 실행 결과 예시

```text
=======소나타=======
총 비용 : 480,000원
총 주유 횟수 : 2회
총 이동 시간 : 9시간 35분
에어컨 : OFF
오디오 : ON
자율주행 : ON
```

---

## 📚 학습 내용

- 추상 클래스
- 상속
- 생성자와 `super()`
- 메서드 오버라이딩
- 다형성
- 인터페이스
- `instanceof`
- 다운캐스팅
- 참조변수와 객체의 관계
- Getter를 이용한 상태 확인
- `static final`
- `Scanner`
- 매개변수를 통한 객체 전달
- `switch`
- `try-catch`
- 메서드 분리 및 공통 로직 재사용
