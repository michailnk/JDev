package JavaOOP.hw_Hotel.hotel.Model;

import JavaOOP.hw_Hotel.Infochat.IBookRoom;
import JavaOOP.hw_Hotel.person.IAdmin;
import JavaOOP.hw_Hotel.person.IPerson;
import org.junit.Ignore;

import java.beans.Transient;

public class BookRoom implements IBookRoom {
    private IAdmin manager;

    public BookRoom(IAdmin adm) {
        this.manager = adm;
    }

    @Override
    public void bookRoom(int numberRoom, IPerson person, int days) {
        manager.bookRoom(numberRoom, person, days);
    }

    @Ignore
    public void bookRoom(int numberRoom, IPerson person) {
        //manager.bookRoom(numberRoom, person);
    }
}
