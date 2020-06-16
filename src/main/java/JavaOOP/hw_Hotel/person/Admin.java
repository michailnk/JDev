package JavaOOP.hw_Hotel.person;

import JavaOOP.hw_Hotel.Infochat.IInfo;
import JavaOOP.hw_Hotel.hotel.IHotel;
import JavaOOP.hw_Hotel.hotel.IRoom;
import JavaOOP.hw_Hotel.hotel.Model.Model;
import JavaOOP.hw_Hotel.hotel.Model.SortType;
import JavaOOP.hw_Hotel.hotel.Model.TaskTimer;
import JavaOOP.hw_Hotel.hotel.Model.UnBookRoom;
import JavaOOP.hw_Hotel.hotel.Status;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Double.*;

public class Admin extends Person implements IAdmin {

    IHotel hotel;
    double tempPayment;

    public IHotel getHotel() {
        return hotel;
    }

    public void setHotel(IHotel hotel) {
        this.hotel = hotel;
    }


    public Admin(String name) {
        super(name);
    }

    @Override
    public IInfo getChat() {
        return super.getChat( );
    }

    @Override
    public String getName() {
        return super.getName( );
    }

    @Override
    public void getMessage(String receiver, String message) {
        super.getMessage(receiver, message);
    }

    @Override
    public void sendMessage(IPerson receiver, String message) {
        chat.sendMessage(receiver, this, message);
    }

    public Admin(String name, IInfo chat, String name1, IInfo chat1) {
        super(name, chat);
    }

    public Admin(String name, IInfo chat, IHotel hotel) {
        super(name, chat);
        this.hotel = hotel;
    }

    public Admin(String name, IHotel hotel) {
        super(name);
        this.hotel = hotel;
    }

    @Override
    public void setRooms(List<IRoom> rooms) {
        hotel.setRooms(rooms);
    }

    @Override
    public void setAdmin(IAdmin admin) {
        this.hotel = hotel;
    }

    @Override
    public void setPersons(List<IPerson> persons) {

    }

    @Override
    public void setRegistrationPerson(List<IPerson> person) {

    }

    @Override
    public void registrationCustomer(IPerson person) {
        this.hotel.getHotel( ).addCustomer(person);
    }

    @Override
    public List<IPerson> getRegistrationList() {
        return hotel.getRegistrationPerson( );
    }

    @Override
    public List<IRoom> getRooms() {
        return hotel.getRooms( );
    }

    @Override
    public void bookRoom(int numberRoom, IPerson person, int days) {
        IRoom orderRoom = Model.getRoonByNubmer(numberRoom, this.hotel.getRooms( ));
        if (checkRegistration(person)) {
            if (orderRoom != null && orderRoom.getStatus( ) == Status.FREE) {
                orderRoom.setStatus(Status.RESERVED);
                orderRoom.orderedByPerson(person);
                chat.sendMessage(person, this, "you order is complited\n to make a payment in 2 days ");
                //this.addTempOrder(numberRoom, person, orderRoom.getPrice( ) * days);
                this.addTempOrder(2000);
                tempPayment = orderRoom.getPlaces( ) * days;
            } else {
                chat.sendMessage(person, this, " You can't order this namber couse it's " + orderRoom.getStatus( ));
            }
        } else {
            chat.sendMessage(person, this, "you need to register ");
        }
    }

    @Override
    public void setChat(IInfo chat) {
        this.chat = chat;
    }

    @Override
    public List<IRoom> getListRooms() {
        return null;
    }

    @Override
    public double makePayment(IPerson p2) {
        return 0;
    }

    private boolean checkRegistration(IPerson person) {
        return hotel.getRegistrationPerson( ).contains(person);
    }

    public void unBookRoom(int numberRoom, IPerson person) {
        if (hotel.getRooms( ) != null) {
            IRoom unOrder = Model.getRoonByNubmer(numberRoom, hotel.getRooms( ));
            if (unOrder != null) {
                unOrder.setStatus(Status.FREE);
                unOrder.orderedByPerson(null);
                chat.sendMessage(person, this, "Room not booked");
            }
        }
    }

    public void prettyPrint(SortType conditional, IPerson person) throws CloneNotSupportedException {
        Model m = buildModel( );
        String answer = "";
        switch (conditional) {
            case PRICE:
                answer = Arrays.toString(m.sortByPrice( ).toArray( ));
                break;
            case NUMBER_OF_SEATS:
                answer = Arrays.toString(m.sortByPlaces( ).toArray( ));
                break;
            case BY_STATU:
                answer = Arrays.toString(m.sortByStatus( ).toArray( ));
                break;
            case IN_CLASS:
                answer = Arrays.toString(m.sortByClass( ).toArray( ));
                break;
            default:
                throw new NullPointerException( );
        }
        String message = (answer != null) ? answer : "Repeat the request ";
        chat.sendMessage(person, this, message);
    }

    @Override
    public void addTempOrder(long daley) {
       // personOrder.reactOnPay(summ);
       boolean isPayment = TaskTimer.startTimer(daley);                //  startTimer(room, personOrder, 2000);
    }

    @Override
    public void removeTempOrder(IPerson personOrder) {

    }

    private Model buildModel() {

        Model m = new Model(this.hotel.getRooms( ));
        return m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return hotel.equals(admin.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode( ), hotel);
    }

}

//         double sum = 0;
//        TimerTask ts = new TimerTask( ) {
//            @Override
//            public void run() {
//               // unBookRoom(room, person);
//                StringBuilder sb = new StringBuilder( );
//                try (FileReader reader = new FileReader("\\JDeducation\\Order.txt")) {
//                    // читаем посимвольно
//                    int c;
//                    while ((c = reader.read( )) != -1) {
//                        sb.append((char) c);
//                        System.out.print((char) c);
//                    }
//                } catch (IOException ex) {
//
//                    System.out.println(ex.getMessage( ));
//                }
//                String doub = sb.toString();
//              //  sum = Double.parseDouble(doub);
//            }
//        };
//        Timer t = new Timer( );
//        t.schedule(ts, data);
//
//        try {
//            //Thread.sleep(data);
//            if(sum  == payment){
//                t.cancel();
//                return;
//            }
//            else{
//                unBookRoom(room,person);
//            }
//
//        } catch (InterruptedException exc) {
//        }
//        t.cancel( );
//    }