package spms.listeners;

import javax.naming.InitialContext;
// 프로퍼티 파일 적용 : ApplicationContext 사용
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import spms.context.ApplicationContext;
import spms.dao.BookDao;
import spms.dao.MemberDao;
import spms.dao.MySqlBookDao;
import spms.dao.MySqlMemberDao;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
	static ApplicationContext applicationContext;
	BasicDataSource ds;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
  
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext sc = event.getServletContext();
			/*
			InitialContext initialContext = new InitialContext();
			DataSource ds = (DataSource)initialContext.lookup("java:comp/env/jdbc/sampledb");
			*/
			
			ds=new BasicDataSource();
			ds.setDriverClassName(sc.getInitParameter("driver"));
			ds.setUrl(sc.getInitParameter("url"));
			ds.setUsername(sc.getInitParameter("username"));
			ds.setPassword(sc.getInitParameter("password"));
			
			MemberDao memberDao = new MySqlMemberDao();
			memberDao.setDataSource(ds);
			
			sc.setAttribute("memberDao", memberDao);
			
			BookDao bookDao = new MySqlBookDao();
			bookDao.setDataSource(ds);
			
			sc.setAttribute("bookDao", bookDao);
   
			String propertiesPath = sc.getRealPath(sc.getInitParameter("contextConfigLocation"));
			applicationContext = new ApplicationContext(propertiesPath);
			
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
  
	@Override
	public void contextDestroyed(ServletContextEvent event) {}
}
