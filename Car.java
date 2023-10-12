import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    public static List<Car> filterCarsByBrand(Car[] cars, String brand) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car != null && car.getMake().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }
        return result;
    }
    
    public static List<Car> filterCarsByModelAndYears(Car[] cars, String model, int years) {
        List<Car> result = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (Car car : cars) {
            if (car != null && car.getModel().equalsIgnoreCase(model) && (currentYear - car.getYearOfManufacture()) > years) {
                result.add(car);
            }
        }
        return result;
    }
    
    public static List<Car> filterCarsByYearAndPrice(Car[] cars, int year, double price) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car != null && car.getYearOfManufacture() == year && car.getPrice() > price) {
                result.add(car);
            }
        }
        return result;
    }
    

    public static void saveToFile(List<Car> cars, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Car car : cars) {
            writer.write(car.toString() + "\n");
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        Car[] cars = new Car[5];

        cars[0] = new Car(1, "Toyota", "Camry", 2010, "Red", 5000, "ABC123");
        cars[1] = new Car(2, "Honda", "Accord", 2012, "Blue", 7000, "DEF456");
        // Similarly create more Car objects...

        List<Car> toyotaCars = filterCarsByBrand(cars, "Toyota");
        saveToFile(toyotaCars, "toyotaCars.txt");

        List<Car> oldModelCars = filterCarsByModelAndYears(cars, "Camry", 5);
        saveToFile(oldModelCars, "oldModelCars.txt");

        List<Car> expensiveCars = filterCarsByYearAndPrice(cars, 2015, 10000);
        saveToFile(expensiveCars, "expensiveCars.txt");
    }
}
