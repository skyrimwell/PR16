package task5;

import task2.Dish;
import task2.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderManager {
    Map<Integer, Order> orders = new HashMap<>();
    Map<String, Order> ordersAddress = new HashMap<>();

    public void add(Order order, int tableNumber) {
        orders.put(tableNumber, order);
    }

    public void add(String address ,Order order) {
        ordersAddress.put(address, order);
    }

    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public Order getOrder(String address) {
        return ordersAddress.get(address);
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

    public void addDish(String address, Dish dish) {
        if (ordersAddress.containsKey(address)) {
            Order temp = ordersAddress.get(address);
            temp.add(dish);
            ordersAddress.remove(address);
            ordersAddress.put(address, temp);
        }
        else {
            Order newOrder = new Order();
            newOrder.add(dish);
            ordersAddress.put(address, newOrder);
        }
    }

    public void removeOrder(int tableNumber) {
        orders.remove(tableNumber);
    }

    public void removeOrder(String address) {
        ordersAddress.remove(address);
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

    public Order[] getInternetOrders() {
        return ordersAddress.values().toArray(new Order[0]);
    }

    public double ordersCostSummary() {
        double total = 0;

        for(Order i: getOrders())
            total += i.costTotal();

        return total;
    }

    public double internetOrdersCostSummary() {
        double total = 0;

        for(Order i: getInternetOrders())
            total += i.costTotal();

        return total;
    }

    public int dishQuantity() {
        int total = 0;

        for(Order i: getOrders())
            total += i.dishQuantity();

        return total;
    }

    public int totalInternetOrderDishByName(String name) {
        Order[] totalD = getInternetOrders();
        int total = 0;

        for(Order i: totalD) {
            String[] dNames = i.dishesNames();
            for(String k: dNames) {
                if(k.equals(name))
                    total++;
            }
        }
        return total;
    }
}
