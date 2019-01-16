package spms.dao;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import spms.vo.Book;

public interface BookDao {
  List<Book> selectList() throws Exception;
  int insert(Book book) throws Exception;
  Book selectOne(int bno) throws Exception;
  int update(Book book) throws Exception;
  int delete(int bno) throws Exception;
  void setDataSource(BasicDataSource ds);
}
