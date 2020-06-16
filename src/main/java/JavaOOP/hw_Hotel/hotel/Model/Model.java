package JavaOOP.hw_Hotel.hotel.Model;

import JavaOOP.hw_Hotel.hotel.IRoom;
import JavaOOP.hw_Hotel.hotel.Room;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Model implements Cloneable {

    private List<IRoom> rooms;

    public Model(List<IRoom> rooms) {
        this.rooms = rooms;
    }

    protected static List<IRoom> clone(List<IRoom> list) throws CloneNotSupportedException {
        List<IRoom> clon = new ArrayList<>( );
        for (IRoom item : list) {
            clon.add(myclone(item));
        }
        return clon;
    }

    public static Room myclone(IRoom r) throws CloneNotSupportedException {
        Room temp = (Room) (r).clone( );
        return temp;
    }

    public List<IRoom> sortByPrice() throws CloneNotSupportedException {
        List<IRoom> temp = clone(rooms);
        temp.sort(new Comparator<IRoom>( ) {
            @Override
            public int compare(IRoom o1, IRoom o2) {
                if (o1.getPrice( ) == o2.getPrice( )) {
                    return 0;
                }
                return o1.getPrice( ) < o2.getPrice( ) ? -1 : 1;
            }
        });
        return temp;
    }

    public List<IRoom> sortByPlaces() throws CloneNotSupportedException {
        List<IRoom> temp = clone(rooms);
        temp.sort(new Comparator<IRoom>( ) {
            @Override
            public int compare(IRoom r1, IRoom r2) {
                if (r1.getPlaces( ) == r2.getPrice( ))
                    return 0;
                return r1.getPlaces( ) < r2.getPlaces( ) ? -1 : 1;
            }
        });
        return temp;
    }

    public List<IRoom> sortByClass() throws CloneNotSupportedException {
        List<IRoom> temp = clone(rooms);
        temp.sort(new Comparator<IRoom>( ) {
            @Override
            public int compare(IRoom r1, IRoom r2) {
                if (r1.getClassRoom( ) == r2.getClassRoom( ))
                    return 0;
                return r1.getPlaces( ) < r2.getPlaces( ) ? -1 : 1;
            }
        }.reversed( ));
        return temp;
    }

    public List<IRoom> sortByStatus() throws CloneNotSupportedException {
        List<IRoom> temp = clone(rooms);
        temp.sort(new Comparator<IRoom>( ) {
            @Override
            public int compare(IRoom r1, IRoom r2) {
                if (r1.getStatus( ) == r2.getStatus( ))
                    return 0;
                return r1.getPlaces( ) < r2.getPlaces( ) ? -1 : 1;
            }
        });
        return temp;
    }

    public static IRoom getRoonByNubmer(int numRoom, List<IRoom> rooms) {
        IRoom room = rooms.stream( ).filter(r -> r.getNumber( ) == numRoom).findFirst( ).get( );
        return room;
    }

}
