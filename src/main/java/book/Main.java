package book;

import book.model.Book;
import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.PersistenceModule;

import static book.BookGenerator.createBook;

public class Main {
    private static int Number_Of_Books = 1000;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new PersistenceModule("test"));
        BookDao bookDao = injector.getInstance(BookDao.class);

        for(int i=0; i<Number_Of_Books; i++) {
            Book book = createBook();
            bookDao.persist(book);

        }

        bookDao.findAll().stream().forEach(System.out::println);

    }

}