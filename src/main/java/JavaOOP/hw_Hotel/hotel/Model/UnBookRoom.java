package JavaOOP.hw_Hotel.hotel.Model;

import JavaOOP.hw_Hotel.Infochat.IBookRoom;
import JavaOOP.hw_Hotel.person.IAdmin;
import JavaOOP.hw_Hotel.person.IPerson;

public class UnBookRoom implements IBookRoom {
    private IAdmin manager;

    public UnBookRoom(IAdmin manager) {
        this.manager = manager;
    }

    @Override
    public void bookRoom(int numberRoom, IPerson person, int days) {
        this.bookRoom(numberRoom, person);
    }

    @Override
    public void bookRoom(int numberRoom, IPerson person) {
        manager.unBookRoom(numberRoom, person);
    }
}
