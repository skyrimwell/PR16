package task4;

class Node<E>
{
    E data;
    Node<E> next;
    Node<E> prev;
}

public class CircularDoublyLinkedList<E> {
    Node<E> start;

    void insertEnd(E value)
    {
        if (start == null)
        {
            Node<E> new_node = new Node<>();
            new_node.data = value;
            new_node.next = new_node.prev = new_node;
            start = new_node;
            return;
        }

        Node<E> last = (start).prev;

        Node<E> new_node = new Node<>();
        new_node.data = value;

        new_node.next = start;

        (start).prev = new_node;

        new_node.prev = last;

        last.next = new_node;
    }

    void insertBegin(E value)
    {
        Node<E> last = (start).prev;

        Node<E> new_node = new Node<>();
        new_node.data = value;

        new_node.next = start;
        new_node.prev = last;

        last.next = (start).prev = new_node;

        start = new_node;
    }

    void insertAfter(E value1, E value2)
    {
        Node<E> new_node = new Node<>();
        new_node.data = value1;

        Node<E> temp = start;
        while (temp.data != value2)
            temp = temp.next;
        Node<E> next = temp.next;

        temp.next = new_node;
        new_node.prev = temp;
        new_node.next = next;
        next.prev = new_node;
    }

    public int size() {
        int count = 0;
        Node<E> temp = start;

        while (temp.next != start)
            count++;
        count++;

        return count;
    }

    @Override
    public String toString() {
        Node<E> temp = start;

        while (temp.next != start)
        {
            System.out.print(" " + temp.data);
            temp = temp.next;
        }
        System.out.print(" " + temp.data);
        return "";
    }
}
