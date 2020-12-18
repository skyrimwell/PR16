package task4;

public class InternetOrder implements Order<RestaurantOrder> {
    private CircularDoublyLinkedList<RestaurantOrder> list = new CircularDoublyLinkedList<>();

    public InternetOrder() {
    }

    public InternetOrder(RestaurantOrder[] arr) {
        for(RestaurantOrder i: arr)
            list.insertEnd(i);
    }

    @Override
    public boolean add(RestaurantOrder order) {
        list.insertEnd(order);
        return true;
    }

    @Override
    public boolean remove(String name) {
        Node<RestaurantOrder> temp = list.start;

        while (temp.next != list.start)
        {
            if(temp.data.remove(name))
                return true;

            temp = temp.next;
        }
        return false;
    }

    @Override
    public boolean removeAll(String name) {
        Node<RestaurantOrder> temp = list.start;

        while (temp.next != list.start)
        {
            temp.data.remove(name);

            temp = temp.next;
        }
        return true;
    }

    @Override
    public int quantity() {
        return list.size();
    }

    @Override
    public RestaurantOrder[] getAll() {
        RestaurantOrder[] all = new RestaurantOrder[quantity()];

        Node<RestaurantOrder> temp = list.start;
        int count = 0;

        while (temp.next != list.start)
        {
           all[count] = temp.data;
            count++;
            temp = temp.next;
        }

        return all;
    }

    @Override
    public double costTotal() {
        Node<RestaurantOrder> temp = list.start;
        double total = 0;

        while (temp.next != list.start)
        {
            total += temp.data.costTotal();
            temp = temp.next;
        }
        return total;
    }

    @Override
    public int quantity(String name) {
        Node<RestaurantOrder> temp = list.start;
        int total = 0;

        while (temp.next != list.start)
        {
            String[] allD = temp.data.allNames();
            for(String i: allD) {
                if (i.equals(name))
                    total++;
            }
            temp = temp.next;
        }
        return total;
    }

    @Override
    public String[] allNames() {
        Node<RestaurantOrder> temp = list.start;
        int total = 0, counter = 0;

        while (temp.next != list.start)
        {
            total += temp.data.quantity();

            temp = temp.next;
        }

        temp = list.start;
        String[] allNames = new String[total];
        while (temp.next != list.start)
        {
            String[] tempD = temp.data.allNames();
            for(String i: tempD) {
                allNames[counter] = i;
                counter++;
            }
            temp = temp.next;
        }
        return allNames;
    }

    @Override
    public RestaurantOrder[] sortedByCostDesc() {
        RestaurantOrder[] all = getAll();

        for(RestaurantOrder i: all)
            i.sortedByCostDesc();

        return all;
    }

}
