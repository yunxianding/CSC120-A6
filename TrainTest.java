import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine engine = new Engine(FuelType.ELECTRIC, 50.0, 100.0);
        assertEquals(FuelType.ELECTRIC, engine.getFuelType());
        assertEquals(50.0, engine.getCurrentFuel(), 0.01);
        assertEquals(100.0, engine.getMaxFuel(), 0.01);
    }

    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.STEAM, 1.0, 100.0);
        assertTrue(engine.go());
        assertEquals(0.0, engine.getCurrentFuel(), 0.01);
        assertFalse(engine.go()); // Should fail because fuel is now 0
        engine.refuel();
        assertEquals(100.0, engine.getCurrentFuel(), 0.01); // Verify fuel is refilled
        assertTrue(engine.go()); 
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car car = new Car(2);
        Passenger p1 = new Passenger("Yunxian");
        assertTrue(car.addPassenger(p1));
        assertEquals(1, car.seatsRemaining());
        assertFalse(car.addPassenger(p1)); // Should fail because Yunxian is already in the car
        assertEquals(1, car.seatsRemaining());
        Passenger p2 = new Passenger("Yunxian");
        assertFalse(car.addPassenger(p2)); // Should fail because Yunxian is already in the car
        assertEquals(1, car.seatsRemaining());
        Passenger p3 = new Passenger("Ding");
        assertTrue(car.addPassenger(p3));
        assertEquals(0, car.seatsRemaining());
        Passenger p4 = new Passenger("YD");
        assertFalse(car.addPassenger(p4)); // Should fail because car is full
        assertEquals(0, car.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
        Car car = new Car(2);
        Passenger p1 = new Passenger("Yunxian");
        Passenger p2 = new Passenger("Ding");
        car.addPassenger(p1);
        assertTrue(car.removePassenger(p1));
        assertEquals(2, car.seatsRemaining());
        assertFalse(car.removePassenger(p1)); // Should fail because p1 is no longer in the car
        assertFalse(car.removePassenger(p2)); // Should fail because p2 is never in the car
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car = new Car(1);
        Passenger p1 = new Passenger("Yunxian");
        p1.boardCar(car);
        assertEquals(0, car.seatsRemaining());
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car car = new Car(1);
        Passenger p1 = new Passenger("Yunxian");
        Passenger p2 = new Passenger("Ding");
        p1.boardCar(car);
        p2.boardCar(car); // Should fail because the car is full
        assertEquals(0, car.seatsRemaining());
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 50.0, 100.0, 2, 3);
        assertEquals(FuelType.ELECTRIC, train.getEngine().getFuelType());
        assertEquals(2, train.getMaxCapacity() / 3); // 2 cars with 3 capacity each
    }

    @Test
    public void testTrainPassengerCount() {
        Train train = new Train(FuelType.ELECTRIC, 50.0, 100.0, 2, 2);
        Passenger p1 = new Passenger("Yunxian");
        Passenger p2 = new Passenger("Ding");
        p1.boardCar(train.getCar(0));
        p2.boardCar(train.getCar(1));
        assertEquals(2, train.seatsRemaining());
        assertEquals(2, train.getMaxCapacity() - train.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Train train = new Train(FuelType.STEAM, 50.0, 100.0, 2, 3);
        assertNotNull(train.getCar(0));
        assertNull(train.getCar(2)); // Invalid car index
    }

    @Test
    public void testTrainPrintManifest() {
        Train train = new Train(FuelType.ELECTRIC, 50.0, 100.0, 1, 2);
        Passenger p1 = new Passenger("Yunxian");
        p1.boardCar(train.getCar(0));
        train.printManifest(); // Should print manifest with Yunxian in Car 0
        Passenger p2 = new Passenger("Ding");
        p2.boardCar(train.getCar(0));
        train.printManifest(); // Should print manifest with Yunxian and Ding in Car 0
    }
    
}
