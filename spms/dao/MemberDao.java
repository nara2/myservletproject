package spms.dao;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import spms.vo.Member;

public interface MemberDao {
	List<Member> selectList() throws Exception;
	int insert(Member member) throws Exception;
	int delete(int mno) throws Exception;
	Member selectOne(int mno) throws Exception;
	int update(Member member) throws Exception;
	Member exist(String email, String pwd) throws Exception;
	void setDataSource(BasicDataSource ds);
}