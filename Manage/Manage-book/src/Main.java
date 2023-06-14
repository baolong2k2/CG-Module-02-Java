public class Main {
    public static void main(String[] args){
        Date date1 = new Date(19, 1, 2002);
        Date date2 = new Date(20, 1, 2003);
        Date date3 = new Date(20, 1, 2003);

        Author author1 = new Author("Long", date1);
        Author author2 = new Author("Albert Einstein", date2);
        Author author3 = new Author("Leonardo da Vinci", date3);

        Books books1 = new Books("JavaScript", 5000, 2005, author1);
        Books books2 = new Books("BYE BYE", 6000, 2005, author2);
        Books books3 = new Books("C#", 7000, 2000, author3);

        books1.bookTitlePrint();
        books2.bookTitlePrint();
        books3.bookTitlePrint();

        System.out.println("Compare publishing year books1 and books3 " + books1.sameYearTest(books3));
        System.out.println("Compare publishing year books2 and books3 " + books2.sameYearTest(books3));
        System.out.println("Compare publishing year books1 and books2 " + books1.sameYearTest(books2));
    }
}