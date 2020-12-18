package task2;

public class Order {
    private int size = 0;
    private Dish[] dishes;

    public boolean add(Dish dish) {
        dishes[size] = dish;
        size++;
        return true;
    }

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

    public int dishQuantity() {
        return size;
    }

    public int dishQuantity(String dishName) {
        for(int i = 0; i < size + 1; i++) {
            if (dishes[i].getName().equals(dishName))
                return i;
        }
        return -1;
    }

    public Dish[] getDishes() {
        return dishes;
    }

    public double costTotal() {
        double total = 0;

        for(Dish i: dishes)
            total += i.getCost();

        return total;
    }

    public String[] dishesNames() {
        String[] names = new String[size];

        for(int i = 0; i < size + 1; i++) {
            names[i] = dishes[i].getName();
        }

        return names;
    }

    public Dish[] sortedDishesByCostDesc() {
        for (int i = 0; i < size-1; i++)
            for (int j = 0; j < size-i-1; j++)
                if (dishes[j].getCost() < dishes[j+1].getCost()) {
                    Dish temp = dishes[j];
                    dishes[j] = dishes[j+1];
                    dishes[j+1] = temp;
                }

        return dishes;
    }
}
