package com.testing.Comparator;

import java.util.Comparator;

/**
 * @author Artem Karnov @date 17.11.2016.
 *         artem.karnov@t-systems.com
 **/
public class MyCar implements Comparable<MyCar> {
    private static int counter = 0;
    private Integer id = 0;
    private String model;
    private double price;

    public MyCar(String model, double price) {
        this.model = model;
        this.price = price;
        id = counter;
        counter++;

    }

    public Integer getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    // TODO: 17.11.2016 add Lambdas

    @Override
    public String toString() {
        return "\nMyCar{" +
                "model='" + model + '\'' +
                ", price='" + price + '\'' +
                "}";
    }


    @Override
    public int compareTo(MyCar o) {
        return (int) (this.id - o.id);
    }

    public static Comparator<MyCar> SalaryComparator = new Comparator<MyCar>() {

        @Override
        public int compare(MyCar o1, MyCar o2) {
            return (int) (o2.id - o1.id);
        }
    };
}
