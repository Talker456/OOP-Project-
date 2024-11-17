package main.manager;

import java.util.Scanner;

public interface Factory<T> {
    public T create(Scanner scanner);
}
