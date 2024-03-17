// Car.java
public class Car {
    private String brand;
    private int year;
    private String registrationNumber;

    public Car(String brand, int year, String registrationNumber) {
        this.brand = brand;
        this.year = year;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return brand + ", " + year + ", " + registrationNumber;
    }
}
