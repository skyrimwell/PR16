package task4;

import task2.Dish;

public interface Order<E> {
    boolean add(E e);
    boolean remove(String name);
    boolean removeAll(String name);
    int quantity();
    int quantity(String name);
    E[] getAll() ;
    double costTotal();
    String[] allNames();
    E[] sortedByCostDesc();
}
