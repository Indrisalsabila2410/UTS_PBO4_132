import java.util.Scanner;

public class CarRemoteControl {
    private boolean engineOn;
    private int gear;

    public CarRemoteControl() {
        this.engineOn = false;
        this.gear = 0;
    }

    public void turnOn() {
        if (!this.engineOn) {
            System.out.println("Engine is turning on...");
            this.engineOn = true;
        } else {
            System.out.println("Engine is already on!");
        }
    }

    public void turnOff() {
        if (this.engineOn) {
            System.out.println("Engine is turning off...");
            this.engineOn = false;
            this.gear = 0;
        } else {
            System.out.println("Engine is already off!");
        }
    }

    public void shiftGear(int gear) {
        if (this.engineOn) {
            switch (gear) {
                case 0:
                    System.out.println("Neutral gear");
                    this.gear = 0;
                    break;
                case 1:
                    System.out.println("First gear");
                    this.gear = 1;
                    break;
                case 2:
                    System.out.println("Second gear");
                    this.gear = 2;
                    break;
                case 3:
                    System.out.println("Third gear");
                    this.gear = 3;
                    break;
                case 4:
                    System.out.println("Fourth gear");
                    this.gear = 4;
                    break;
                case 5:
                    System.out.println("Fifth gear");
                    this.gear = 5;
                    break;
                default:
                    System.out.println("Invalid gear!");
                    break;
            }
        } else {
            System.out.println("Engine is off!");
        }
    }

    public void drive(int speed) {
        if (this.engineOn) {
            if (speed > 0) {
                System.out.println("Driving at " + speed + " km/h in gear " + this.gear);
            } else {
                System.out.println("Invalid speed!");
            }
        } else {
            System.out.println("Engine is off!");
        }
    }

    public void stop() {
        if (this.engineOn) {
            System.out.println("Stopping the car...");
            this.gear = 0;
        } else {
            System.out.println("Engine is off!");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CarRemoteControl car = new CarRemoteControl();

            while (true) {
                System.out.println();
                System.out.println("on");
                System.out.println("off");
                System.out.println("drive");
                System.out.println("shift gear");
                System.out.println("stop");
                System.out.println("exit");
                System.out.println("Enter your command:");
                String command = scanner.nextLine();

                switch (command) {
                    case "on":
                        car.turnOn();
                        break;
                    case "off":
                        car.turnOff();
                        break;
                    case "shift":
                        System.out.println("Enter gear:");
                        int gear = scanner.nextInt();
                        scanner.nextLine();
                        car.shiftGear(gear);
                        break;
                    case "drive":
                        System.out.println("Enter speed:");
                        int speed = scanner.nextInt();
                        scanner.nextLine();
                        car.drive(speed);
                        break;
                    case "stop":
                        car.stop();
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid command!");
                        break;
                }
            }
        }
    }
}
