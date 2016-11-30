package com.testing.Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<MyCar> cars = new ArrayList<>();
        cars.add(new MyCar("BMW", 10));
        cars.add(new MyCar("Mersedes", 5));
        cars.add(new MyCar("Lamborgigini", 10000));
        cars.add(new MyCar("Zhigul", -5));
        main.lowestToHighestPriceSort(cars);
        main.highestToLowestPriceSort(cars);
        main.alphabeticModelSort(cars);
        main.idLowestToHighestSort(cars);
        main.idHighestToLowestSort(cars);
    }

    //отдельный компаратор для строк
    public void alphabeticModelSort(List<MyCar> cars) {
        System.out.println();
        System.out.println("alphabeticModelSort");
        Collections.sort(cars, new ModelComparator());
        System.out.println(cars);
    }

    //отдельный компаратор для цены
    public void lowestToHighestPriceSort(List<MyCar> cars) {
        System.out.println();
        System.out.println("lowestToHighestPriceSort");
        Collections.sort(cars, new PriceComparator());
        System.out.println(cars);
    }

    //отдельный компаратор для цены в обертке реверсного компаратора
    public void highestToLowestPriceSort(List<MyCar> cars) {
        System.out.println();
        System.out.println("highestToLowestPriceSort");
        Collections.sort(cars, Collections.reverseOrder(new PriceComparator()));
        System.out.println(cars);
    }

    //внутренний compareTo
    public void idLowestToHighestSort(List<MyCar> cars) {
        System.out.println();
        System.out.println("idLowestToHighestSort");
        Collections.sort(cars);
        System.out.println(cars);
    }

    //использую лямбду (иннер класс)
    public void idHighestToLowestSort(List<MyCar> cars) {
        System.out.println();
        System.out.println("idHighestToLowestSort");
        Collections.sort(cars, MyCar.SalaryComparator);
        System.out.println(cars);
    }

}
