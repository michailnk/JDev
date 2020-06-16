package JavaOOP.hw_Hotel.person;

import JavaOOP.hw_Hotel.Infochat.IInfo;
import JavaOOP.hw_Hotel.hotel.IRoom;
import java.util.List;

public class Customer extends  Person {
    public Customer(String name, IInfo chat) {
        super(name, chat);
    }

    public Customer(String name) {
        super(name);
    }

    @Override
    public void sendMessage(IPerson receiver, String message) {
        chat.sendMessage(receiver,this,message);
    }

    @Override
    public void setChat(IInfo chat) {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                "} " + super.toString( );
    }

    @Override
    public List<IRoom> getListRooms() {
        return null;
    }
}
