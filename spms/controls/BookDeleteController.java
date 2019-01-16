package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.controls.Controller;
import spms.dao.BookDao;

@Component("/book/delete.do")
public class BookDeleteController implements Controller, DataBinding {
	BookDao bookDao;
  
  public BookDeleteController setProjectDao(BookDao bookDao) {
    this.bookDao = bookDao;
    return this;
  }
  
  public Object[] getDataBinders() {
    return new Object[]{
        "bno", Integer.class
    };
  }
  
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    Integer bno = (Integer)model.get("bno");
    bookDao.delete(bno);
    
    return "redirect:list.do";
  }
}
