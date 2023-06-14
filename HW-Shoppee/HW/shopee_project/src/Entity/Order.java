package Entity;

import java.util.Date;

public class Order {
    private final long id;
    private String statics;
    private String totalPrice;
    private Address address;
    private String personReceive;
    private Date date;
    private static long count = 0;
    public Order(String statics, String totalPrice, Address address, String personReceive,Date date){
        this.id = ++count;
        this.statics = statics;
        this.totalPrice = totalPrice;
        this.address = address;
        this.personReceive = personReceive;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getStatics() {
        return statics;
    }

    public void setStatics(String statics) {
        this.statics = statics;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPersonReceive() {
        return personReceive;
    }

    public void setPersonReceive(String personReceive) {
        this.personReceive = personReceive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        Order.count = count;
    }

    @Override
    public String toString(){
        return "Products are: " + statics + " with total price " + totalPrice + " at " + address + "and name of the person receive is " + personReceive + " on " + date;
    }
}
