package JavaOOP.hw_Hotel.Infochat;

import JavaOOP.hw_Hotel.hotel.Model.IListRoom;
import JavaOOP.hw_Hotel.hotel.Model.SortType;
import JavaOOP.hw_Hotel.person.Customer;
import JavaOOP.hw_Hotel.person.IAdmin;
import JavaOOP.hw_Hotel.person.IPerson;
import java.util.ArrayList;
import java.util.List;

public class Chat implements IInfo {
    private IBookRoom order;
    private IBookRoom unOrder;

    private IListRoom lsRoom;
    private List<IPerson> persons;
    private IPerson admin;
    private String name;

    public Chat(String name, IBookRoom order, IBookRoom unOrder) {
        this.order = order;
        this.unOrder = unOrder;
        persons = new ArrayList<>( );
        this.name = name;
    }

    public void setLsRoom(IListRoom ls) {
        this.lsRoom = ls;
    }

    public void pushOrder(int numberRoom, IPerson person, int days) {
        order.bookRoom(numberRoom, person, days);
    }

    public void popOrder(int numRoom, IPerson per) {
        unOrder.bookRoom(numRoom, per);
    }

    @Override
    public void addPerson(IPerson person) {
        if (persons.size( ) == 0 && person instanceof IAdmin) {
            admin = person;
        } else if (admin != null) {
            persons.add(person);
        }
    }

    @Override
    public void registration(IPerson person) {
        if (person instanceof Customer) {

            ((IAdmin) this.admin).registrationCustomer(person);
        }
    }

    @Override
    public void sendMessage(IPerson receiver, IPerson source, String message) {
        receiver.getMessage(" :" + source.getName( ), message);
    }

    public void showListRooms(SortType st, IPerson person) {
        lsRoom.print(st, person);
    }

    @Override
    public void reactOnPay(IPerson p, double pay) {
        p.reactOnPay(pay);
    }

    @Override
    public double makePayment(IPerson p, IPerson to) {
        return 0;
    }
}
