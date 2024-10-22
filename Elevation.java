package lb3tareevamiroshnichencko;

import java.util.Scanner;


public class Elevation {
    final int ELEVATION_ID = 1;
    private String _name;
    private int _age;
    private String _country;
    private double _latitude;
    private double _longitude;
    private int _height;
    protected int _idClass;
    
    
    // Конструктор по умолчанию
    public Elevation() {
        this._name = "";
        this._age = 0;
        this._country = "";
        this._latitude = 0.0;
        this._longitude = 0.0;
        this._height = 0;
        this._idClass = ELEVATION_ID;
    }
    
    // Конструктор с параметрами
    public Elevation(String name, int age, String country, double latitude, double longitude, int height) {
        this._name = name;
        this._age = age;
        this._country = country;
        this._latitude = latitude;
        this._longitude = longitude;
        this._height = height;
        this._idClass = ELEVATION_ID;
    }
    
    // Геттер для _name
    public String getName() {
        return _name;
    }
    
    // Геттер для _age
    public int getAge() {
        return _age;
    }
    
    // Геттер для _country
    public String getCountry() {
        return _country;
    }
    
    // Геттер для _latitude
    public double getLatitude() {
        return _latitude;
    }
    
    // Геттер для _longitude
    public double getLongitude() {
        return _longitude;
    }
    
    // Геттер для _height
    public int getHeight() {
        return _height;
    }
    
    // Геттер для _idClass
    public int getIdClass() {
        return _idClass;
    }
    
    // Сеттер для _name
    public void setName(String value) {
        this._name = value;
    }
    
    // Сеттер для _age
    public void setAge(int value) {
        this._age = value;
    }
    
        // Сеттер для _country
    public void setCountry(String value) {
        this._country = value;
    }
    
        // Сеттер для _latitude
    public void setLatitude(double value) {
        this._latitude = value;
    }
    
            // Сеттер для _longitude
    public void setLongitude(double value) {
        this._longitude = value;
    }
    
        // Сеттер для _height
    public void setHeight(int value) {
        this._height = value;
    }
    
    //Метод про проверки высота больше 1000(1000 изменить на константу или переменной из функций для массива   )
    public boolean isMoreThousandHeight(){
        if(_height>1000){
            return true;
        }
        return false;     
    }
    public void updateElevation(Scanner scanner){
        System.out.println("Выберите поле для обновления:");
        System.out.println("1. Название");
        System.out.println("2. Возраст");
        System.out.println("3. Страна");
        System.out.println("4. Широта");
        System.out.println("5. Долгота");
        System.out.println("6. Высота");

        int fieldOption = scanner.nextInt();
        scanner.nextLine(); // Потребляем символ новой строки

        switch (fieldOption) {
            case 1:
                System.out.println("Введите новое название:");
                String newName = scanner.nextLine();
                this.setName(newName);
                break;
            case 2:
                System.out.println("Введите новый возраст:");
                this.setAge(scanner.nextInt());
                break;
            case 3:
                System.out.println("Введите новую страну:");
                String newCountry = scanner.nextLine();
                this.setCountry(newCountry);
                break;
            case 4:
                System.out.println("Введите новую широту:");
                this.setLatitude(scanner.nextDouble());
                break;
            case 5:
                System.out.println("Введите новую долготу:");
                this.setLongitude(scanner.nextDouble());
                break;
            case 6:
                System.out.println("Введите новую высоту:");
                this.setHeight(scanner.nextInt());
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        
        System.out.println("Информация о горе успешно обновлена.");
    
    }
    
    public void printInfo() {
        System.out.println("Имя: " + _name +
                           ",\n Высота: " + _height +
                           ",\n Возраст: " + _age +
                           ",\n Страна: " + _country +
                           ",\n Широта: " + _latitude +
                           ",\n Долгота: " + _longitude);
    }

     
}
