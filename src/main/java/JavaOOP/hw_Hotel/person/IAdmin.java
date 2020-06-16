package JavaOOP.hw_Hotel.person;

import JavaOOP.hw_Hotel.hotel.IRoom;
import JavaOOP.hw_Hotel.hotel.Model.SortType;

import java.util.List;
import java.util.Set;

public interface IAdmin extends IPerson {
    void setRooms(List<IRoom> rooms);

    void setAdmin(IAdmin admin);

    void setPersons(List<IPerson> persons);

    void setRegistrationPerson(List<IPerson> person);

    void registrationCustomer(IPerson person);

    List<IPerson> getRegistrationList();

    List<IRoom> getRooms();

    void bookRoom(int numberRoom, IPerson person, int days);

    void unBookRoom(int numberRoom, IPerson person);

    void prettyPrint(SortType conditional, IPerson person) throws CloneNotSupportedException;

    void addTempOrder(long daley);

    void removeTempOrder(IPerson personOrder);

}
