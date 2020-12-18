package task6;

public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException(String message) {
        super(message);
    }
}
//throw new OrderAlreadyAddedException("С этим столиком или адресатом уже связан заказ!");