package JavaOOP.hw_Hotel.hotel;
import JavaOOP.hw_Hotel.person.IAdmin;
import JavaOOP.hw_Hotel.person.IPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hotel implements IHotel {
    private List<IRoom> rooms;
    private IAdmin admin;
    private List<IPerson> persons;
    private List<IPerson> registrationPersons = new ArrayList<>( );
    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public void addCustomer(IPerson person) {
        this.registrationPersons.add(person);
        (admin).getChat( ).sendMessage(person, admin, " you successful registration!");
    }

    @Override
    public Hotel getHotel() {
        return this;
    }

    @Override
    public void setAdmin(IAdmin person) {
        this.admin = person;
    }

    @Override
    public List<IRoom> getRooms() {
        return this.rooms;
    }

    @Override
    public List<IPerson> getRegistrationPerson() {
        return this.registrationPersons;
    }

    @Override
    public void setRooms(List<IRoom> rooms) {
        if (this.rooms == null) {
            this.rooms = new ArrayList<>( );
            this.rooms = rooms;
        } else {
            this.rooms.addAll(rooms);
        }
    }
}
