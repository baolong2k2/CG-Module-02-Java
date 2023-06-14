package model.entity;

public class Multiverse {
    private int id;
    private String name;
    private static int count;
    private String detail;


    public Multiverse(int id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public Multiverse(String name, String detail) {
        this.name = name;
        this.detail = detail;
        this.id = ++count;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }



    @Override
    public String toString() {
        return String.format("""
                💥 MULTIVERSE 💥
                Multiverse id: %s
                Multiverse name: %s
                """,getId(),getName());
    }

}
