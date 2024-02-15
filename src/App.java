

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ParkingSystem parkingSystem = null;
            while (true) {
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                String command = parts[0];
                switch (command) {
                    case "create_parking_lot":
                        int capacity = Integer.parseInt(parts[1]);
                        parkingSystem = new ParkingSystem(capacity);
                        System.err.println();
                        break;

                    case "park":
                        if(TicketSystemUtils.validateRegistrationNo(parts[1])){
                            parkingSystem.parkCar(parts[1], parts[2]);
                        }else{
                            System.err.println("Enter a valid Registration No ");
                        }
                        System.err.println();
                        break;

                    case "leave":
                        int slotNumber = Integer.parseInt(parts[1]);
                        parkingSystem.leaveSlot(slotNumber);
                        System.err.println();
                        break;

                    case "registration_numbers_for_cars_with_colour":
                        parkingSystem.getRegistrationNumbersByColor(parts[1]);
                        System.err.println();
                        break;

                    case "slot_number_for_registration_number":
                        if(TicketSystemUtils.validateRegistrationNo(parts[1])){
                            parkingSystem.getSlotNumberByRegistrationNumber(parts[1]);
                        }else{
                            System.err.println("Enter a valid Registration No ");
                        }
                        System.err.println();
                        break;
                        
                    case "slot_numbers_for_cars_with_colour":
                        parkingSystem.getSlotNumbersByColor(parts[1]);
                        System.err.println();
                        break;

                    case "status":
                        parkingSystem.printStatus();
                        System.err.println();
                        break;

                    case "vacancy_status":
                        parkingSystem.vacancyStatus();
                        break;

                    case "exit":
                        System.err.println("Thanks for using Ticket System");
                        return;
                        
                    default:
                        System.out.println("Invalid command");
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


