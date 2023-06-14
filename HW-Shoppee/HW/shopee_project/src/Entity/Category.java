package Entity;

public class Category {
    private final long id;
    private String name;
    private static long count = 0;
    public Category (String name){
        this.name = name;
        this.id = ++count;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Products with ID " + getId() + " has a name " + getName();
    }
}
