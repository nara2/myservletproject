package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.controls.Controller;
import spms.dao.BookDao;
import spms.vo.Book;

@Component("/book/update.do")
public class BookUpdateController implements Controller, DataBinding {
  BookDao bookDao;
  
  public BookUpdateController setBookDao(BookDao bookDao) {
    this.bookDao = bookDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "bno", Integer.class,
        "book", spms.vo.Book.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
	  Book book = (Book)model.get("book");
    
    if (book.getBname() == null) { 
      Integer bno = (Integer)model.get("bno");
      Book detailInfo = bookDao.selectOne(bno);
      model.put("book", detailInfo);
      return "/book/BookUpdateForm.jsp";

    } else { 
      bookDao.update(book);
      return "redirect:list.do";
    }
  }
}
