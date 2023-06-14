public class Books {
    private String nameOfBooks;
    private double prices;
    private int publishingYear;
    private Author author;

    public Books(String nameOfBooks, double prices, int publishingYear, Author author) {
        this.nameOfBooks = nameOfBooks;
        this.prices = prices;
        this.publishingYear = publishingYear;
        this.author = author;
    }

    public String getNameOfBooks() {
        return nameOfBooks;
    }

    public void setNameOfBooks(String nameOfBooks) {
        this.nameOfBooks = nameOfBooks;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public void bookTitlePrint (){
        System.out.println(this.nameOfBooks);
    }

    public boolean sameYearTest (Books anotherBooks){
//        if (this.publishingYear == anotherBooks.publishingYear){
//            return true;
//        }else {
//            return false;
//        }
        return this.publishingYear == anotherBooks.publishingYear; //the same with if
    }
}
