package ru.siksmfp.spring.play.chapter3.replacing;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class StudentServices {

    @Lookup
    public SchoolNotification getNotification() {
        return null;
    }
}
