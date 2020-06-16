package JavaOOP.hw_Hotel.Infochat;
import JavaOOP.hw_Hotel.person.IPerson;

public interface IBookRoom {

//    boolean isRegistration(IPerson person);

    void bookRoom(int numberRoom, IPerson person, int days);
    void bookRoom(int numberRoom,IPerson person);
}
