
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<Car> carList = new ArrayList<>();

    public static void main(String[] args) {
        carList.add(new Car("Volvo s90", 2015, "x001xx"));
        carList.add(new Car("Lada Vesta", 2020, "x002xx"));
        carList.add(new Car("Kia Rio", 2012, "x003xx"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Работу выполнил Максимов Никита РИБО-05-22");
        int choice;

        do {

            System.out.println("Здравствуйте! Что нужно выполнить?");
            System.out.println("1. Добавить новый автомобиль");
            System.out.println("2. Удалить автомобиль по регистрационному номеру");
            System.out.println("3. Удалить все автомобили");
            System.out.println("0. Выйти из программы");
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCar(scanner);
                    break;
                case 2:
                    removeCar(scanner);
                    break;
                case 3:
                    removeAllCars();
                    break;
                case 0:
                    System.out.println("Программа завершена!");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова!");
            }

            if (choice !=0) {
                System.out.println("Список автомобилей: ");
                displayCarList();
            }
        } while (choice != 0);
    }

    private static void addCar(Scanner scanner) {
        System.out.print("Введите марку машины:");
        String brand = scanner.next();
        System.out.print("Введите год выпуска:");
        int year = scanner.nextInt();
        System.out.print("Введите регистрационный номер:");
        String regNumber = scanner.next();

        for (Car car : carList) {
            if (car.getRegistrationNumber().equals(regNumber)) {
                System.out.println("Автомобиль с таким регистрационным номером уже существует!");
                System.out.println("");
                return;
            }
        }

        carList.add(new Car(brand, year, regNumber));
        System.out.println("Автомобиль добавлен!");
        System.out.println("");
    }

    private static void removeCar(Scanner scanner) {
        System.out.print("Введите регистрационный номер автомобиля:");
        String regNumber = scanner.next();

        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getRegistrationNumber().equals(regNumber)) {
                carList.remove(i);
                System.out.println("Автомобиль удален!");
                System.out.println("");
                return;
            }
        }

        System.out.println("Автомобиль с указанным регистрационным номером не найден.");
        System.out.println("");
    }

    private static void removeAllCars() {
        carList.clear();
        System.out.println("Все автомобили удалены.");
        System.out.println("");
    }

    private static void displayCarList() {
        if (carList.isEmpty()) {
            System.out.println("Список автомобилей пуст.");
            System.out.println("");
        } else {
            for (Car car : carList) {
                System.out.println(car);
            }
        }
        System.out.println();
    }
}

