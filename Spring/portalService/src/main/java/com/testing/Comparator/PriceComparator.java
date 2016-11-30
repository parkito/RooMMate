package com.testing.Comparator;

import java.util.Comparator;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/

/*
* Принимает два объекта в качестве аргумента
* и должен быть реализован таким образом,
* чтобы возвращать отрицательное число — если первый аргумент меньше второго,
* ноль — если они равны и положительное число,
* если первый аргумент больше, чем второй.
*/
public class PriceComparator implements Comparator<MyCar> {

    @Override
    public int compare(MyCar o1, MyCar o2) {
        //По-умному
        return (int) (o1.getPrice() - o2.getPrice());
        //Классика
//        if (o1.getPrice() > o2.getPrice())
//            return 1;
//        else if (o1.getPrice() < o2.getPrice())
//            return -1;
//        else return 0;
    }
}
