
package lb3tareevamiroshnichencko;

import java.util.Scanner;


public class Mountain extends Elevation{
    final int MONTAIN_ID = 2;
    private boolean _isClimbed;
    
    // Конструктор по умолчанию
    public Mountain() {
        super(); // Вызов конструктора по умолчанию родительского класса
        this._isClimbed = false; // Устанавливаем значение по умолчанию
        this._idClass = MONTAIN_ID;
    }

    // Параметризованный конструктор
    public Mountain(String name, int age, String country, double latitude, double longitude, int height, boolean isClimbed) {
        super(name, age, country, latitude, longitude, height); // Передаем параметры родительскому классу
        this._isClimbed = isClimbed;
        this._idClass = MONTAIN_ID;
    }
    
        // Геттер для _isClimbed
    public boolean getClimbed() {
        return _isClimbed;
    }
    
    // Сеттер для _isClimbed
    public void setIsClimbed(boolean value) {
        this._isClimbed = value;
    }
    
    @Override
    public void printInfo() {
        super.printInfo(); // Выводим информацию из родительского класса
        System.out.println("На нее взбирались: " + (_isClimbed ? "Да" : "Нет"));
    }
    
    public void updateMountain(Scanner scanner){
        System.out.println("Выберите поле для обновления:");
        System.out.println("1. Название");
        System.out.println("2. Возраст");
        System.out.println("3. Страна");
        System.out.println("4. Широта");
        System.out.println("5. Долгота");
        System.out.println("6. Высота");
        System.out.println("7. Статус альпинизма (взобралась ли на гору)");

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
            case 7:
                System.out.println("Введите новый статус взобралась на гору (true/false):");
                this.setIsClimbed(scanner.nextBoolean());
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        
        System.out.println("Информация о горе успешно обновлена.");
    }
}
