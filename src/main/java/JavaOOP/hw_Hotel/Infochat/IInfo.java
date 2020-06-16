package JavaOOP.hw_Hotel.Infochat;

import JavaOOP.hw_Hotel.hotel.Model.SortType;
import JavaOOP.hw_Hotel.person.IPerson;
import java.util.List;

public interface IInfo {

    void sendMessage(IPerson receiver, IPerson of, String message);

    void addPerson(IPerson person);

    void registration(IPerson person);

    void pushOrder(int numberRoom, IPerson person, int days);

    void popOrder(int numRoom, IPerson per);

    void showListRooms(SortType st, IPerson person);

    void reactOnPay(IPerson p, double pay);

    double makePayment(IPerson p, IPerson to);
}
