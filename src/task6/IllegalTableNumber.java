package task6;

public class IllegalTableNumber extends RuntimeException {
    public IllegalTableNumber(String message) {
        super(message);
    }
}
//throw new IllegalTableNumber("Номер столика с таким номером не существует!");