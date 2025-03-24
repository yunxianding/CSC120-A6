Use this file to record your reflection on this assignment.

What are your initial impressions of how `Unit Testing` affects your programming?
I think it's really helpful for debugging. It consists of small units and is easier to use than writing out a long main().

What worked, what didn't, what advice would you give someone taking this course in the future?
Here is a summary of the tests I implemented and their purpose:

Engine Tests
1. testEngineConstructor: Verifies that the Engine constructor initializes the fuel type, current fuel level, and maximum fuel level correctly.
2. testEngineGo: Tests the go() method to ensure it reduces the fuel level correctly and stops working when the fuel is depleted. It also verifies that the refuel() method restores the fuel level to its maximum.

Car Tests
1. testCarAddPassenger: Ensures that passengers can be added to the car only if there is space and they are not the same person.
2. testCarRemovePassenger: Tests that a passenger can be removed from the car only when the passenger is already in the car.

Passenger Tests
1. testPassengerBoardCarWithSpace: Verifies that a passenger can board a car with available seats.
2. testPassengerBoardCarFull: Ensures that a passenger cannot board a car that is already full.

Train Tests
1. testTrainConstructor: Verifies that the `Train` constructor initializes the engine and cars correctly.
2. testTrainPassengerCount: Tests that the total passenger count updates correctly as passengers board and leave cars.
3. testTrainGetCar: Ensures that the `getCar()` method returns the correct car for a valid index and `null` for an invalid index.
4. testTrainPrintManifest: Verifies that the `printManifest()` method correctly lists passengers in each car or indicates when a car is empty.

I really get the usefulness of unit testing through this assignment. My intial A4 program runs perfectly without error. However, I wouldn't have noticed the problem without unit testing. In my first trail, I passed all the tests expect for the test for addPassenger. I found out that in my initial program, the Passenger objects are compared by reference (not by their name attribute), so two Passenger objects with the same name are treated as different objects. Thus, I can add two passengers with the same name (in fact they are the same person) to the train as long as there are still seats remaining. Now I realized the problem and fixed the issues. It can pass all the tests now. I definitely suggest write unit testing for every java program!