package JavaOOP.hw_Hotel.hotel;

import JavaOOP.hw_Hotel.person.IAdmin;
import JavaOOP.hw_Hotel.person.IPerson;

import java.util.List;
import java.util.Set;

public interface IHotel {


Hotel getHotel();
//void addCustomer(IPerson person);
    void setAdmin(IAdmin person);
    List<IRoom> getRooms();
    List<IPerson>getRegistrationPerson();
    void setRooms(List<IRoom> rooms);
}
