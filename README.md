# Ticket System CLI

## Instruction
- Configure vscode for java projects
- Java Configuration used :
openjdk version "17.0.10" 2024-01-16
OpenJDK Runtime Environment Temurin-17.0.10+7 (build 17.0.10+7)
OpenJDK 64-Bit Server VM Temurin-17.0.10+7 (build 17.0.10+7, mixed mode, sharing)
- Run the App.java file

## File Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `App.java` : file to run/debug for giving commands in Command Line Interface

## Commands 

- `create_parking_lot` : To create a Car Ticket Parking System.    
    parameter : no of parking spaces     
    Ex : create_parking_lot 7

- `park` : To park a vehicle in the Parking System.   
    parameters : Registration Number of vehicle , Colour of teh vehicle    
    Ex : park DL-12-AA-9999 White

- `leave` : To vacant a particular space in the Parking System.     
    parameters : slot of the no to be vacant    
    Ex : leave 2

- `registration_numbers_for_cars_with_colour` : To get all the registration numbers of a particular colour in the Parking System.    
    parameter : colour     
    Ex : registration_numbers_for_cars_with_colour White

- `slot_number_for_registration_number` : To get the slot where the car with given registration number is parked in the Parking System.     
    parameter : registration numbers DL-12-AA-9999    
    Ex : slot_number_for_registration_number 
    
- `slot_numbers_for_cars_with_colour` : To get all the slots of a particular colour in the Parking System.    
    parameter : colour     
    Ex : slot_numbers_for_cars_with_colour White
    
- `status` : To get the parking status in the Parking System

- `vacancy_status` : To get the slot occupied/vacant status of the Parking System.

- `exit` : To exit from the Parking System.
 
