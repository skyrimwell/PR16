package task4;

import task2.Dish;

public class RestaurantOrder implements Order<Dish> {
    private int size = 0;
    private Dish[] dishes;

    @Override
    public boolean add(Dish e) {
        dishes[size] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(String dishName) {
        for(int i = 0; i < size + 1; i++) {
            if(dishes[i].getName().equals(dishName)) {
                if (size - i >= 0)
                    System.arraycopy(dishes, i + 1, dishes, i, size - i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(String dishName) {
        boolean b = false;

        for(int i = 0; i < size + 1; i++) {
            if(dishes[i].getName().equals(dishName)) {
                if (size - i >= 0) {
                    System.arraycopy(dishes, i + 1, dishes, i, size - i);
                    b = true;
                }
            }
        }
        return b;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public int quantity(String dishName) {
        for(int i = 0; i < size + 1; i++) {
            if (dishes[i].getName().equals(dishName))
                return i;
        }
        return -1;
    }

    @Override
    public Dish[] getAll() {
        return dishes;
    }

    @Override
    public double costTotal() {
        double total = 0;

        for(Dish i: dishes)
            total += i.getCost();

        return total;
    }

    @Override
    public String[] allNames() {
        String[] names = new String[size];

        for(int i = 0; i < size + 1; i++) {
            names[i] = dishes[i].getName();
        }

        return names;
    }

    @Override
    public Dish[] sortedByCostDesc() {
        for (int i = 0; i < size-1; i++)
            for (int j = 0; j < size-i-1; j++)
                if (dishes[j].getCost() > dishes[j+1].getCost()) {
                    Dish temp = dishes[j];
                    dishes[j] = dishes[j+1];
                    dishes[j+1] = temp;
                }

        return dishes;
    }
}
