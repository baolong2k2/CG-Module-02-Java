public class Movie {
    private String nameOfMovie;
    private int yearOfManufacture;
    private Manufacturer manufacturer;
    private double priceTicket;
    private Date showDate;

    public Movie(String nameOfMovie, int yearOfManufacture, Manufacturer manufacturer, double priceTicket, Date showDate) {
        this.nameOfMovie = nameOfMovie;
        this.yearOfManufacture = yearOfManufacture;
        this.manufacturer = manufacturer;
        this.priceTicket = priceTicket;
        this.showDate = showDate;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPriceTicket() {
        return priceTicket;
    }

    public void setPriceTicket(double priceTicket) {
        this.priceTicket = priceTicket;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }
    public boolean checkCheaperTickets (Movie anotherMovie){
        return this.priceTicket < anotherMovie.priceTicket;
    }
    public String getTheManufacturerName (){
        return this.manufacturer.getName();
    }
    public double priceAfterPromotion (double x){
        return this.priceTicket * (1 - x/100);
    }
}
