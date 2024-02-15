import java.util.*;

public class ParkingSystem {
    private ParkingLot parkingLot;

    public ParkingSystem(int capacity) {
        parkingLot = new ParkingLot(capacity);
        System.out.println("Created a parking lot with " + capacity + " slots");
    }

    public void parkCar(String registrationNumber, String color) {
        Car car = new Car(registrationNumber, color);
        int slotNumber = parkingLot.parkCar(car);
        if (slotNumber == -1) {
            System.out.println("Sorry, parking lot is full");
        } else if(slotNumber == -2){
            System.out.println( registrationNumber + " is already there in parking.");
        }else {
            System.out.println("Allocated slot number: " + slotNumber);
        }
    }

    public void leaveSlot(int slotNumber) {
        boolean success = parkingLot.leaveSlot(slotNumber);
        if (success) {
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already empty");
        }
    }

    public void getRegistrationNumbersByColor(String color) {
        List<String> registrationNumbers = parkingLot.getRegistrationNumbersByColor(color);
        System.out.println(String.join(", ", registrationNumbers));
    }

    public void getSlotNumberByRegistrationNumber(String registrationNumber) {
        int slotNumber = parkingLot.getSlotNumberByRegistrationNumber(registrationNumber);
        if (slotNumber != -1) {
            System.out.println(slotNumber);
        } else {
            System.out.println("Not found");
        }
    }

    public void getSlotNumbersByColor(String color) {
        List<Integer> slotNumbers = parkingLot.getSlotNumbersByColor(color);
        System.out.println(slotNumbers.isEmpty() ? "Not found" : slotNumbers.stream().map(Object::toString).reduce((s1, s2) -> s1 + ", " + s2).get());
    }

    public void printStatus() {
        parkingLot.printStatus();
    }

    public void vacancyStatus(){
        parkingLot.vacancyStatus();
    }
}
