package Entity;

public class Address {
    private final String street;
    private String houseNumber;
    private String ward;
    private String district;
    public Address (String street, String houseNumber, String ward, String district){
        this.street = street;
        this.houseNumber = houseNumber;
        this.ward = ward;
        this.district = district;
    }
    public String getStreet (){
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString(){
        return "Located in: " + street + " street, " + houseNumber + " house number, " + ward + " ward, " + district + " district. ";
    }
}
