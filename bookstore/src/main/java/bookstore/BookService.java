package bookstore;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariusz.przybysz on 2017-04-10.
 */
@Service
public class BookService {

    private List<Book> books;
    private int counter;


    public BookService() {
        counter = 1;
        books = new ArrayList<>();
    }

    public Book getBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public int createBook(Book book) {
        book.setId(counter);
        books.add(book);
                return counter++;
    }

    public int delBook(int id) {
        int search = 0;
        for (int i = 0; i < books.size(); ++i) {
            Book book = getBook(i);
            if (book.getId() == search) {
                search = i;
                break;
            }
        }
        books.remove(search);
return id;
    }
}



