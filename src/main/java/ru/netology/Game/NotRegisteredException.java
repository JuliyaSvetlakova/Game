package ru.netology.Game;

public class NotRegisteredException  extends RuntimeException {
    public NotRegisteredException (String n) {
        super(n);
    }
}
