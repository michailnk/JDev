package JavaOOP.hw_Hotel.person;
import JavaOOP.hw_Hotel.Infochat.IInfo;
import JavaOOP.hw_Hotel.hotel.IRoom;

import java.util.List;

public interface IPerson {

    void getMessage(String receiver, String message);

    void sendMessage(IPerson receiver, String message);

    void registration();

    String getName();

    IInfo getChat();

    void setChat(IInfo chat);

    List<IRoom> getListRooms();

    void reactOnPay(double payment);

    double makePayment(IPerson p2);

}
