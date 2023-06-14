public class Main {
    public static void main(String[] args){
        Date date1 = new Date(15, 05, 2022);
        Date date2 = new Date(25, 06, 2025);
        Date date3 = new Date(30, 07, 2030);

        Manufacturer manufacturer1 = new Manufacturer("Marvel", "America");
        Manufacturer manufacturer2 = new Manufacturer("Walt Disney", "America");
        Manufacturer manufacturer3 = new Manufacturer("Universal", "America");

        Movie movie1 = new Movie("Iron Man", 2002, manufacturer1, 50000, date1);
        Movie movie2 = new Movie("Mickey Mouse", 1996, manufacturer2, 55000, date2);
        Movie movie3 = new Movie("Toy Story", 2000, manufacturer3, 60000, date3);

        System.out.println("Compare price 1 cheaper than price 2:" + movie1.checkCheaperTickets(movie2));
        System.out.println("Compare price 2 cheaper than price 3:" + movie2.checkCheaperTickets(movie3));
        System.out.println("Compare price 1 cheaper than price 3:" + movie1.checkCheaperTickets(movie3));

        System.out.println("Name of manufacturer movie 3: " + movie3.getTheManufacturerName());

        System.out.println("Movie 1 discount 10%: " + movie1.priceAfterPromotion(10));
    }
}