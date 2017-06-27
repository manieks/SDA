package bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mariusz.przybysz on 2017-04-10.
 */
@RestController
public class BookControl {

private BookService bookService;

@Autowired
BookControl(BookService bookService){
    this.bookService = bookService;
}

@RequestMapping (value = "/book/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable("id") int id){
    return bookService.getBook(id);
}

@RequestMapping (value = "/book/all", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
}
@RequestMapping (value = "/book", method = RequestMethod.POST)
public int createBook (@RequestBody Book book ){
        return bookService.createBook(book);
}

    @RequestMapping (value = "/book/{id}", method = RequestMethod.DELETE)
    public String delBook(@PathVariable("id") int id){
        return delBook(id);
    }


}
