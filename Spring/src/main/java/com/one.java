package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Karnov 11.11.2016.
 *         artem.karnov@t-systems.com
 **/
class two {
    private final List<Integer> array = new ArrayList();

    public final List<Integer> getArray() {
        return new ArrayList<>(array);
    }


    @Override
    public String toString() {
        return "two{" +
                "array=" + array +
                '}';
    }
}

public class one {
    public static void main(String[] args) {
        two tw = new two();
        System.out.println(tw);
        tw.getArray().add(1);
        tw.getArray().add(2);
        tw.getArray().add(3);
        System.out.println(tw);

    }
}
