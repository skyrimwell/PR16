package task3;

import task2.Dish;
import task2.Order;

public class InternetOrder {
    private CircularDoublyLinkedList<Order> list = new CircularDoublyLinkedList<>();

    public InternetOrder() {
    }

    public InternetOrder(Order[] arr) {
        for(Order i: arr)
            list.insertEnd(i);
    }

    public boolean add(Order order) {
        list.insertEnd(order);
        return true;
    }

    public boolean remove(String name) {
        Node<Order> temp = list.start;

        while (temp.next != list.start)
        {
            if(temp.data.remove(name))
                return true;

            temp = temp.next;
        }
        return false;
    }

    public int removeAll(String name) {
        Node<Order> temp = list.start;
        int count = 0;

        while (temp.next != list.start)
        {
            if(temp.data.remove(name))
                count++;

            temp = temp.next;
        }
        return count;
    }

    public int size() {
        return list.size();
    }

    public Order[] getAll() {
        Order[] all = new Order[size()];

        Node<Order> temp = list.start;
        int count = 0;

        while (temp.next != list.start)
        {
           all[count] = temp.data;
            count++;
            temp = temp.next;
        }

        return all;
    }

    public double costTotal() {
        Node<Order> temp = list.start;
        double total = 0;

        while (temp.next != list.start)
        {
            total += temp.data.costTotal();
            temp = temp.next;
        }
        return total;
    }

    public int totalNameSize(String name) {
        Node<Order> temp = list.start;
        int total = 0;

        while (temp.next != list.start)
        {
            String[] allD = temp.data.dishesNames();
            for(String i: allD) {
                if (i.equals(name))
                    total++;
            }
            temp = temp.next;
        }
        return total;
    }

    public String[] ordersNames() {
        Node<Order> temp = list.start;
        int total = 0, counter = 0;

        while (temp.next != list.start)
        {
            total += temp.data.dishQuantity();

            temp = temp.next;
        }

        temp = list.start;
        String[] allNames = new String[total];
        while (temp.next != list.start)
        {
            String[] tempD = temp.data.dishesNames();
            for(String i: tempD) {
                allNames[counter] = i;
                counter++;
            }
            temp = temp.next;
        }
        return allNames;
    }

    public Order[] ordersDescendingSort() {
        Order[] all = getAll();

        for(Order i: all)
            i.sortedDishesByCostDesc();

        return all;
    }

}
