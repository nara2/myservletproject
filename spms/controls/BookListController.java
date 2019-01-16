package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.controls.Controller;
import spms.dao.BookDao;

@Component("/book/list.do")
public class BookListController implements Controller {
  BookDao bookDao;
  
  public BookListController setMemberDao(BookDao bookDao) {
    this.bookDao = bookDao;
    return this;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    model.put("books", bookDao.selectList());
    return "/book/BookList.jsp";
  }
}
