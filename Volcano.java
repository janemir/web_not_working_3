
package lb3tareevamiroshnichencko;

import java.time.Year;
import java.util.Scanner;


public class Volcano extends Mountain{
    final int VOLCANO_ID = 3;
    
    private int _lastErmulationYear;
    private boolean _isActive;
    
    // Конструктор по умолчанию
    public Volcano() {
        super(); // Вызов конструктора по умолчанию родительского класса
        this._lastErmulationYear = 0; // Устанавливаем значение по умолчанию
        this._isActive = false;
        this._idClass = VOLCANO_ID;
    }

    // Параметризованный конструктор
    Volcano(String name, int age, String country, double latitude, double longitude, int height, boolean isClimbed, int lastErmulationYear, boolean active) {
        super(name, age, country, latitude, longitude, height, isClimbed ); // Передаем параметры родительскому классу
        this._lastErmulationYear = lastErmulationYear;
        this._isActive = active;
        this._idClass = VOLCANO_ID;
    }


    
    // Геттер для _isActive
    public boolean getIsActive() {
        return _isActive;
    }
    
    // Геттер для _lastErmulationYear
    public int getLastErmulationYear() {
        return _lastErmulationYear;
    }
    
    // Сеттер для _isActive
    public void setIsActive(boolean value) {
        this._isActive = value;
    }
    
    // Сеттер для _lastErmulationYear
    public void setLastErmulationYear(int value) {
        this._lastErmulationYear = value;
    }
    
    private boolean isActive(){
        int currentYear = Year.now().getValue();
        if (currentYear-_lastErmulationYear<1000000){
            return true;
        }
        return false;
    }
    
    @Override
    public void printInfo() {
        super.printInfo(); // Выводим информацию из родительского класса
        System.out.println("Год последнего извержения: " + _lastErmulationYear);
        System.out.println("Активен: " + (_isActive?"Да":"Нет"));
        
    }
    
    public void updateVolcano(Scanner scanner){
        System.out.println("Выберите поле для обновления:");
        System.out.println("1. Название");
        System.out.println("2. Возраст");
        System.out.println("3. Страна");
        System.out.println("4. Широта");
        System.out.println("5. Долгота");
        System.out.println("6. Высота");
        System.out.println("7. Статус альпинизма (взобралась ли на гору)");
        System.out.println("8. Год последнего извержения");
        System.out.println("9. Статус (активен или нет)");
        

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
            case 8:
                System.out.println("Введите год последнего извержения:");
                this.setLastErmulationYear(scanner.nextInt());
                break;                
             case 9:
                System.out.println("Введите новый статус активен или нет (true/false):");
                this.setIsActive(scanner.nextBoolean());
                break;
            default:
                System.out.println("Неверный выбор.");
        }
        
        System.out.println("Информация о горе успешно обновлена.");
    }
}
