import java.util.Map;
import java.util.TreeMap;
import java.util.regex.*;

public class TicketSystemUtils {
    
    public static Boolean checkForDuplicateRegistrationNo(Car car, TreeMap<Integer, Car> slots){
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            if (entry.getValue().getRegistrationNumber().equals(car.getRegistrationNumber())) {
                return true; // Car with the same registration number is already parked
            }
        }

        return false;
    }

    public static void calculateNearestVacantSpace(int nearestSlot,int capacity, TreeMap<Integer, Car> slots){
        for (int slotNumber = 1; slotNumber <= capacity; slotNumber++) {
            if (!slots.containsKey(slotNumber)) {
                nearestSlot = slotNumber;
                return;
            }
        }
    }

    public static boolean validateRegistrationNo(String registrationNo){
        // Regular expression to match the desired format
        String regex = "^[A-Z]{2}-\\d{1,2}-[A-Z]{1,2}-\\d{1,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(registrationNo);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

    public static void vacancyStatus(int capacity, TreeMap<Integer, Car> slots){
        int occupied = slots.size();
        int vacant = capacity - occupied;
        System.out.println("Occupied: " + occupied);
        System.out.println("Vacant: " + vacant);
    }
}
