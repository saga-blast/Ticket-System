import java.util.*;

public class ParkingLot {
    private int capacity;
    private TreeMap<Integer, Car> slots;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        slots = new TreeMap<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int parkCar(Car car) {

        if(TicketSystemUtils.checkForDuplicateRegistrationNo(car,slots)){
            return -2;
        }
        // Check if there are any adjacent empty slots
        int nearestSlot = -1;
        TicketSystemUtils.calculateNearestVacantSpace(nearestSlot, capacity, slots);

        // If there are adjacent empty slots, park the car in the nearest one
        if (nearestSlot != -1) {
            slots.put(nearestSlot, car);
            return nearestSlot;
        } else {
            // If no adjacent empty slots, park the car in the first empty slot found
            for (int slotNumber = 1; slotNumber <= capacity; slotNumber++) {
                if (!slots.containsKey(slotNumber)) {
                    slots.put(slotNumber, car);
                    return slotNumber;
                }
            }
        }
        
        return -1; // Parking lot is full
    }

    public boolean leaveSlot(int slotNumber) {
        if (slots.containsKey(slotNumber)) {
            slots.remove(slotNumber);
            return true;
        } else {
            return false; // Slot was already empty
        }
    }

    public List<String> getRegistrationNumbersByColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        boolean found = false;
        String targetColorLower = color.toLowerCase(); // Convert target color to lowercase
        for (Car car : slots.values()) {
            String carColorLower = car.getColor().toLowerCase(); // Convert car's color to lowercase
            if (carColorLower.equals(targetColorLower)) {
                registrationNumbers.add(car.getRegistrationNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No " + color + " colour car is there in parking lot");
        }
        return registrationNumbers;
    }

    public int getSlotNumberByRegistrationNumber(String registrationNumber) {
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            if (entry.getValue().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return entry.getKey();
            }
        }
        return -1; // Car not found
    }

    public List<Integer> getSlotNumbersByColor(String color) {
        List<Integer> slotNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            if (entry.getValue().getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(entry.getKey());
            }
        }
        return slotNumbers;
    }

    public void printStatus() {
        System.out.println("Slot No. Registration No Colour");
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getRegistrationNumber() + " " + entry.getValue().getColor());
        }
    }

    public void vacancyStatus(){
        TicketSystemUtils.vacancyStatus(capacity,slots);
    }
}
