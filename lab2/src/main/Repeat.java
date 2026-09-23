package main;

import java.lang.annotation.*;

// Аннотация с целочисленным параметром
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Repeat {
    int value(); // сколько раз вызвать
}