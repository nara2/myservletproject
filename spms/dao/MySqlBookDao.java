package spms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import spms.annotation.Component;
import spms.vo.Book;

@Component("bookDao")
public class MySqlBookDao implements BookDao {
	static BasicDataSource ds;

	public void setDataSource(BasicDataSource ds) {
		this.ds = ds;
	}

	public List<Book> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
    
		try {
			connection = ds.getConnection();
			System.out.println("book selectList...");
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT *" + " FROM book" + " ORDER BY bno");

			ArrayList<Book> books = new ArrayList<Book>();

			while(rs.next()) {
				books.add(new Book()
					.setBno(rs.getInt("bno"))
					.setBname(rs.getString("bname"))
					.setAuthor(rs.getString("author"))
					.setBdate(rs.getDate("bdate"))
					.setPrice(rs.getInt("price"))
					.setBcount(rs.getInt("bcount"))
					.setTotalprice(rs.getInt("totalprice"))
					.setImage(rs.getString("image")));
			}
			return books;

		} catch (Exception e) {
			throw e;

		} finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	
	  public int insert(Book book) throws Exception  {
	    Connection connection = null;
	    PreparedStatement stmt = null;
	
	    try {
	      connection = ds.getConnection();
	      System.out.println("book insert...");
	      stmt = connection.prepareStatement(
	        "INSERT INTO Book"
	        + "(bno,bname,author,bdate,price,bcount,totalprice,image)"
	        + " VALUES (0,?,?,now(),?,?,?,?)");
	      stmt.setString(1, book.getBname());
	      stmt.setString(2, book.getAuthor());
	      stmt.setInt(3, book.getPrice());
	      stmt.setInt(4, book.getBcount());
	      stmt.setInt(5, book.getPrice()*book.getBcount());
	      stmt.setString(6, book.getImage());
	      
	      return stmt.executeUpdate();
	
	    } catch (Exception e) {
	      throw e;
	
	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	  
	  public Book selectOne(int bno) throws Exception { 
	    Connection connection = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {
	      connection = ds.getConnection();
	      System.out.println("book selectOne...");
	      stmt = connection.createStatement();
	      rs = stmt.executeQuery(
	        "SELECT *"
	        + " FROM book WHERE bno=" + bno);    
	      if (rs.next()) {
	    	  return new Book().setBno(rs.getInt("bno")).setBname(rs.getString("bname"))
	    			  .setAuthor(rs.getString("author")).setBdate(rs.getDate("bdate"))
	    			  .setPrice(rs.getInt("price")).setBcount(rs.getInt("bcount"))
	    			  .setTotalprice(rs.getInt("totalprice")).setImage(rs.getString("image"));
	      } else {
	        throw new Exception("해당 번호의 프로젝트를 찾을 수 없습니다.");
	      }
	
	    } catch (Exception e) {
	      throw e;
	    } finally {
	      try {if (rs != null) rs.close();} catch(Exception e) {}
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	
	  public int update(Book book) throws Exception { 
	    Connection connection = null;
	    PreparedStatement stmt = null;
	    try {
	      connection = ds.getConnection();
	      System.out.println("book update...");
	      stmt = connection.prepareStatement(
	        "UPDATE book SET "
	        + " bname=?,"
	        + " author=?,"
	        + " bdate=now(),"
	        + " price=?,"
	        + " bcount=?,"
	        + " totalprice=?,"
	        + " image=?"
	        + " WHERE bno=?");
	      stmt.setString(1, book.getBname());
	      stmt.setString(2, book.getAuthor());
	      stmt.setInt(3, book.getPrice());
	      stmt.setInt(4, book.getBcount());
	      stmt.setInt(5, book.getPrice()*book.getBcount());
	      stmt.setString(6, book.getImage());
	      stmt.setInt(7, book.getBno());
	      
	      return stmt.executeUpdate();
	
	    } catch (Exception e) {
	      throw e;
	
	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }  
	
	  public int delete(int bno) throws Exception {  
	    Connection connection = null;
	    Statement stmt = null;
	
	    try {
	      connection = ds.getConnection();
	      System.out.println("book delete...");
	      stmt = connection.createStatement();
	      return stmt.executeUpdate(
	          "DELETE FROM book WHERE bno=" + bno);
	
	    } catch (Exception e) {
	      throw e;
	
	    } finally {
	      try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      try {if (connection != null) connection.close();} catch(Exception e) {}
	    }
	  }
	}
