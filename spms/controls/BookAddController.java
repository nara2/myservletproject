package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.BookDao;
import spms.vo.Book;

@Component("/book/add.do")
public class BookAddController implements Controller, DataBinding {
  BookDao bookDao;
  
  public BookAddController setBookDao(BookDao bookDao) {
    this.bookDao = bookDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "book", spms.vo.Book.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Book book = (Book)model.get("book");
    if (book.getBname() == null) {
      return "/book/BookForm.jsp";
      
    } else {
      bookDao.insert(book);
      return "redirect:list.do";
    }
  }
}
