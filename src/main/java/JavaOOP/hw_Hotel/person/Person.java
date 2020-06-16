package JavaOOP.hw_Hotel.person;

import JavaOOP.hw_Hotel.Infochat.IInfo;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public abstract class Person implements IPerson {
    protected double payment;
    protected String name;
    protected IInfo chat;

    public Person(String name, IInfo chat) {
        this(name);
        this.chat = chat;
    }

    public Person(String name) {
        this.name = name;
    }

    public IInfo getChat() {
        return chat;
    }

    @Override
    public void reactOnPay(double payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public double makePayment(IPerson p2) {
        try (FileWriter writer = new FileWriter("E:\\Git\\JavaDev\\JDeducation\\Order.txt", false)) {
            writer.write(String.valueOf(this.payment));
            writer.flush( );
        } catch (IOException ex) {

            System.out.println(ex.getMessage( ));
        }
        System.out.println("The file has been written");
        return payment;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void getMessage(String receiver, String message) {
        System.out.println(this.name + " get message " + message + receiver);
    }


    @Override
    public void registration() {
        chat.registration(this);
    }
}
