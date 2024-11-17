package main.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager<T extends Manageable>{

    protected ArrayList<T> list = new ArrayList<>();

    public void readAll(String path,Factory<T> factory) {
        Scanner s = openFile(path);
        while (s.hasNext()) {
            T t = factory.create(s);
            t.read(s);
            list.add(t);
        }
    }

    public void printAll() {
        for (T t : list) {
            t.print();
        }
    }


    public Scanner openFile(String path) {
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("not found " + path);
        }
        return s;
    }
}
