package task2;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    Map<Integer, Order> orders = new HashMap<>();

    public void add(Order order, int tableNumber) {
        orders.put(tableNumber, order);
    }

    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public void addDish(Dish dish, int tableNumber) {
        if (orders.containsKey(tableNumber)) {
            Order temp = orders.get(tableNumber);
            temp.add(dish);
            orders.remove(tableNumber);
            orders.put(tableNumber, temp);
        }
        else {
            Order newOrder = new Order();
            newOrder.add(dish);
            orders.put(tableNumber, newOrder);
        }
    }

    public void removeOrder(int tableNumber) {
        orders.remove(tableNumber);
    }

    public int freeTableNumber() {
        return -1;
    }

    public int[] freeTableNumbers() {
        return new int[]{-1};
    }

    public Order[] getOrders() {
        return orders.values().toArray(new Order[0]);
    }

    public double ordersCostSummary() {
        double total = 0;

        for(Order i: getOrders())
            total += i.costTotal();

        return total;
    }

    public int dishQuantity() {
        int total = 0;

        for(Order i: getOrders())
            total += i.dishQuantity();

        return total;
    }
}
