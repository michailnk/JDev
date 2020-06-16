package JavaOOP.hw_Hotel.hotel.Model;

import JavaOOP.hw_Hotel.person.IAdmin;
import JavaOOP.hw_Hotel.person.IPerson;

public class ListRoom implements IListRoom {

    private IAdmin admin;

    public ListRoom(IAdmin admin) {
        this.admin = admin;
    }

    @Override
    public void print(SortType sortType, IPerson person) {
        try {
            admin.prettyPrint(sortType, person);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace( );
        }
    }
}
