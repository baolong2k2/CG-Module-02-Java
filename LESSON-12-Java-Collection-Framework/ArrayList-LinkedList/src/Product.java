public class Product {
    private long price;
    private long id;
    private String name;
    private static long count;
    public Product(){};
    public Product(String name,long price) {
        this.id = ++count;
        this.name= name;
        this.price=price;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UNIVERSE HAVE ID " + getId() + " HAVE A NAME " + getName() + " HAVE A PRICE " + getPrice() + "$";
    }
}
