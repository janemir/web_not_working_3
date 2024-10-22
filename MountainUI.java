package lb3tareevamiroshnichencko;


import java.util.Scanner;
import java.util.InputMismatchException;


public class MountainUI {
    private MountainArray mountainArray;

    public MountainUI() {
        mountainArray = new MountainArray();
    }

    public void start() {

        Elevation peak1 = new Elevation();
        peak1.setName("Эльбрус");
        peak1.setHeight(5642);
        peak1.setCountry("Россия");
        peak1.setLatitude(43.3499);
        peak1.setLongitude(42.4453);
        peak1.setAge(10000);

        Mountain mountain1 = new Mountain();
        mountain1.setName("Монблан");
        mountain1.setHeight(4807);
        mountain1.setCountry("Франция");
        mountain1.setLatitude(45.8326);
        mountain1.setLongitude(6.8652);
        mountain1.setAge(10000);
        mountain1.setIsClimbed(true);

        Volcano volcano1 = new Volcano();
        volcano1.setName("Килиманджаро");
        volcano1.setHeight(5895);
        volcano1.setCountry("Танзания");
        volcano1.setLatitude(-3.0674);
        volcano1.setLongitude(37.3556);
        volcano1.setAge(750000);
        volcano1.setIsActive(true);

        Volcano volcano2 = new Volcano();
        volcano2.setName("Везувий");
        volcano2.setHeight(1281);
        volcano2.setCountry("Италия");
        volcano2.setLatitude(40.8222);
        volcano2.setLongitude(14.4260);
        volcano2.setAge(2000);
        volcano2.setIsActive(false);

        // Добавление объектов в массив
        mountainArray.addMountain(peak1);
        mountainArray.addMountain(mountain1);
        mountainArray.addMountain(volcano1);
        mountainArray.addMountain(volcano2);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите опцию:");
            System.out.println("1. Добавить гору");
            System.out.println("2. Получить самую высокую вершину");
            System.out.println("3. Получить вершины выше 1000 м");
            System.out.println("4. Упорядочить массив по высоте");
            System.out.println("5. Обновить информацию о горе по имени");
            System.out.println("6. Вывести информацию о всех вершинах");
            System.out.println("7. Выйти");

            try {
                int option = scanner.nextInt();
                scanner.nextLine(); // Потребляем символ новой строки

                switch (option) {
                    case 1:
                        addMountain(scanner);
                        break;
                    case 2:
                        getHighestMountain();
                        break;
                    case 3:
                        getMountainsOver1000();
                        break;
                    case 4:
                        sortMountains();
                        break;
                    case 5:
                        updateMountains(scanner);
                        break;
                    case 6:
                        printAllMountains();
                        break;
                    case 7:
                        System.out.println("Выход...");
                        return;
                    default:
                        System.out.println("Неверный выбор, попробуйте снова.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Неверный выбор, попробуйте снова.");
                scanner.nextLine(); // Очищаем буфер после ошибки
            }
        }
    }

    private void addMountain(Scanner scanner) {
    System.out.println("Введите номер типа: 1.Возвышенность  2.Гора  3.Вулкан");
    String type = scanner.nextLine();
    
    System.out.println("Введите имя:");
    String name = scanner.nextLine();
    
    System.out.println("Введите возраст:");
    int age = scanner.nextInt();
    scanner.nextLine(); // Потребляем символ новой строки
    
    System.out.println("Введите страну:");
    String country = scanner.nextLine();
    
    System.out.println("Введите широту:");
    double latitude = scanner.nextDouble();
    
    System.out.println("Введите долготу:");
    double longitude = scanner.nextDouble();
    
    System.out.println("Введите высоту:");
    int height = scanner.nextInt();
    scanner.nextLine(); // Потребляем символ новой строки

    if (type.equals("1")) {
        // Elevation
        Elevation elevation = new Elevation(name, age, country, latitude, longitude, height);
        mountainArray.addMountain(elevation);
        System.out.println("Возвышенность добавлена.");
        
    } else if (type.equals("2")||type.equals("3")) {
        // Mountain
        System.out.println("Введите, было ли восхождение (true/false):");
        boolean isClimbed = scanner.nextBoolean();
        Mountain mountain = new Mountain(name, age, country, latitude, longitude, height, isClimbed);
        mountainArray.addMountain(mountain);
        System.out.println("Гора добавлена.");
        
    if (type.equals("3")) {
        // Volcano
        System.out.println("Введите год последнего извержения:");
        int lastErmulationYear = scanner.nextInt();
        System.out.println("Введите, активен ли вулкан (true/false):");
        boolean isActive = scanner.nextBoolean();
        Volcano volcano = new Volcano(name, age, country, latitude, longitude, height, isClimbed, lastErmulationYear, isActive);
        mountainArray.addMountain(volcano);
        System.out.println("Вулкан добавлен.");
        
    }
    }else {
        System.out.println("Неверный тип.");
    }
    
}


    private void getHighestMountain() {
        Elevation highestMountain = mountainArray.getHighestMountain();
        if (highestMountain != null) {
            System.out.println("Самая высокая гора: " + highestMountain.getName() + " высотой " + highestMountain.getHeight() + " м.");
        } else {
            System.out.println("Список гор пуст.");
        }
    }

    private void getMountainsOver1000() {
        var mountains = mountainArray.getMountainsOver1000();
        if (mountains.isEmpty()) {
            System.out.println("Нет вершин выше 1000 м.");
            return;
        }
        System.out.println("Вершины выше 1000 м:");
        for (Elevation mountain : mountains) {
            System.out.println(mountain.getName() + " высотой " + mountain.getHeight() + " м.");
        }
    }

    private void sortMountains() {
        mountainArray.sortMountainsByHeight();
        System.out.println("Горы отсортированы по высоте.");
    }

    private void updateMountains(Scanner scanner) {

        int index;
        System.out.println("Введите название горы, которую хотите обновить:");
        String name = scanner.nextLine();

        Elevation mountain = mountainArray.getMountains().stream()
            .filter(m -> m.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);

        if (mountain == null) {
            System.out.println("Гора не найдена.");
            return;
        }
        try {
            int type = mountain.getIdClass(); 
            
            switch (type) {
                case 1:
                    mountain.updateElevation(scanner);;
                    break;
                case 2:
                    Mountain mountain_1 = (Mountain)mountain;
                    mountain_1.updateMountain(scanner);
                    break;
                case 3:
                    Volcano mountain_2 = (Volcano)mountain;
                    mountain_2.updateVolcano(scanner);
                    break;
                
            }
            
            
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода, пожалуйста, введите целое число для высоты.");
            scanner.nextLine(); // Очистка буфера в случае ошибки
        }
    
        System.out.println("Обновленная информация:");
        mountain.printInfo(); // Используем метод printInfo 
    }
    
    
    private void printAllMountains() {
        mountainArray.printAllMountains();
        
    }

}
