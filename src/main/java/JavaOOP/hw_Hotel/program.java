package JavaOOP.hw_Hotel;

import JavaOOP.hw_Hotel.Infochat.Chat;
import JavaOOP.hw_Hotel.Infochat.IBookRoom;
import JavaOOP.hw_Hotel.hotel.*;
import JavaOOP.hw_Hotel.hotel.Model.*;
import JavaOOP.hw_Hotel.person.*;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class program {

    public static void main(String[] args) throws CloneNotSupportedException {

        IHotel local = new Hotel("local");
        IAdmin admin = new Admin("Alex", local);
        Chat simpleChat = new Chat("chatHotel", new BookRoom(admin), new UnBookRoom(admin));

        admin.setChat(simpleChat);
        IPerson p1 = new Customer("Tom", simpleChat);
        IPerson p2 = new Customer("Petrov", simpleChat);

        simpleChat.addPerson(admin);
        simpleChat.addPerson(p1);
        simpleChat.addPerson(p2);

        admin.sendMessage(p1, "Tom hi!");
        p1.sendMessage(admin, "hi ");
        admin.sendMessage(p2, "What wrong?");

        local.setAdmin(admin);
        p1.registration( );


        IRoom r1 = new Room(1, 2, ClassRoom.studio, 100d, Status.FREE);
        IRoom r2 = new Room(2, 4, ClassRoom.luxe, 105d, Status.BUSY);
        IRoom r3 = new Room(3, 3, ClassRoom.typeC, 95d, Status.BUSY);
        List<IRoom> ls = new ArrayList<>( );
        ls.add(r1);
        ls.add(r2);
        ls.add(r3);

        List<IRoom> list = List.of(r1, r2, r3);
        admin.setRooms(ls);
//        Model m = new Model(list);
//        System.out.println(m.sortByPrice(list) );
//        System.out.println(m.sortByPlaces(list) );
//        System.out.println( );
//        System.out.println(m.sortByStatus(list) );
//        System.out.println(m.sortByClass(list) );

        p2.getChat( ).pushOrder(1, p2, 2);

        p1.getChat( ).pushOrder(1, p1, 3);

        simpleChat.setLsRoom(new ListRoom(admin));
        p1.getChat( ).showListRooms(SortType.IN_CLASS, p1);


        TimerTask ts = new TimerTask( ) {
            @Override
            public void run() {
                System.out.println(" human ");
            }
        };
        Timer t = new Timer( );
        t.schedule(ts, 3000);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException exc) {
        }
        t.cancel( );

    }
}
