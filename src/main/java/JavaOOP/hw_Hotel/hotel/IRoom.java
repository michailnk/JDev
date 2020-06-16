package JavaOOP.hw_Hotel.hotel;

import JavaOOP.hw_Hotel.person.IPerson;

public interface IRoom {
    int getNumber();
    int getPlaces();
    ClassRoom getClassRoom();
    double getPrice();
    Status getStatus();
    int compareByPrice(IRoom room);

    Object clone() throws CloneNotSupportedException;

    void setStatus(Status status);

    void orderedByPerson(IPerson person);
    IPerson getOrderedPerson();
}
