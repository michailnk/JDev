package JavaOOP.hw_Hotel.hotel;

import JavaOOP.hw_Hotel.person.IPerson;

import java.util.Objects;

public class Room implements IRoom, Cloneable {
    int number;
    int places;
    ClassRoom classRoom;
    double price;
    Status stat;
    private IPerson customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return number == room.number &&
                places == room.places &&
                classRoom == room.classRoom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, places, classRoom);
    }

    public Room(int number, int places, ClassRoom clss) {
        this.number = number;
        this.places = places;
        this.classRoom = clss;

    }

    public Room(int number, int places, ClassRoom classRoom, double price, Status stat) {

        this(number, places, classRoom);
        this.price = price;
        this.stat = stat;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getPlaces() {
        return this.places;
    }

    @Override
    public ClassRoom getClassRoom() {
        return this.classRoom;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public Status getStatus() {
        return this.stat;
    }

    public void setStatus(Status st) {
        this.stat = st;
    }

    @Override
    public void orderedByPerson(IPerson person) {
        this.customer = person;
    }

    @Override
    public IPerson getOrderedPerson() {
        return this.customer;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", places=" + places +
                ", classRoom=" + classRoom +
                ", price=" + price +
                ", stat=" + stat +
                '}' + "\n";
    }

    public int compareByPrice(IRoom val) {
        return (int) (this.getPrice( ) - val.getPrice( ));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Room r = (Room) super.clone( );
        return r;
    }
}
