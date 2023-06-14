package Entity;

public class Cart {
    private final long id;
    private String totalPrice;
    private static long count = 0;
    public Cart (String totalPrice){
        this.id =  ++count;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public  String toString (){
        return "Cart ID: " + id + " with total price is " + totalPrice;
    }
}
