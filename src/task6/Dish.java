package task6;

public class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public Dish(String name, String description) {
        if (name.equals(""))
            throw new IllegalArgumentException("Название не может быть пустым!");
        else if (description.equals(""))
            throw new IllegalArgumentException("Описание не может быть пустым!");
        else {
            this.name = name;
            this.description = description;
            cost = 0;
        }
    }

    public Dish(double cost, String name, String description) {
        if (name.equals(""))
            throw new IllegalArgumentException("Название не может быть пустым!");
        else if (description.equals(""))
            throw new IllegalArgumentException("Описание не может быть пустым!");
        else if (cost < 0)
            throw new IllegalArgumentException("Цена не может быть меньше нуля!");
        else {
            this.cost = cost;
            this.name = name;
            this.description = description;
        }
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
