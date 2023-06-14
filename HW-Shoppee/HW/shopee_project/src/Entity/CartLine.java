package Entity;

public class CartLine {
    private final long id;
    private int productID;
    private int quantity;
    private String totalPrice;
    private static long count = 0;
    public CartLine (int productID, int quantity, String totalPrice){
        this.id = ++count;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public  String toString (){
        return "Cart Line have ID: " + id + "\nProduct ID: " + productID + "\nQuantity: " + quantity + "\n Total Price: " + totalPrice;
    }
}
