package JavaOOP.hw_Hotel.hotel;

import java.util.Comparator;

public enum Status {

    FREE(1),
    RESERVED(2),
    BUSY(3),
    UNAVAILABLE(4);

    private int val;

    private Status(int value) {
        this.val = val;
    }

}
