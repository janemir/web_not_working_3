package lb3tareevamiroshnichencko;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MountainArray {
    private List<Elevation> mountains;

    public MountainArray() {
        this.mountains = new ArrayList<>();
    }

    public List<Elevation> getMountains(){
        return mountains;
    }
    
    // Геттер для получения горы по индексу
    public Elevation getMountainByIndex(int index) {
        if (index >= 0 && index < mountains.size()) {
            return mountains.get(index);
        }
        return null;
    }
    
    
    // Метод для добавления новой горы
    public void addMountain(Elevation mountain) {
        mountains.add(mountain);
    }

    // Определение самой высокой вершины
    public Elevation getHighestMountain() {
        return mountains.stream()
            .max(Comparator.comparingInt(Elevation::getHeight))
            .orElse(null);
    }

    // Определение вершин с высотой более 1000 м
    public List<Elevation> getMountainsOver1000() {
        List<Elevation> result = new ArrayList<>();
        for (Elevation mountain : mountains) {
            if (mountain.isMoreThousandHeight()) {
                result.add(mountain);
            }
        }
        return result;
    }

    // Упорядочивание массива по возрастанию высот
    public void sortMountainsByHeight() {
        mountains.sort(Comparator.comparingInt(Elevation::getHeight));
    }
    
    

    // Вывод всей информации о вершинах
    public void printAllMountains() {
        for (Elevation mountain : mountains) {
            mountain.printInfo(); // Используем метод printInfo
            
        }
    }
}
