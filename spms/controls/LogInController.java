package spms.controls;

import java.util.Map;

import javax.servlet.http.HttpSession;

import spms.annotation.Component;
import spms.bind.DataBinding;
import spms.dao.MySqlMemberDao;
import spms.vo.Member;

@Component("/auth/login.do")
public class LogInController implements Controller, DataBinding {
	MySqlMemberDao memberDao;

	public LogInController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{
			"loginInfo", spms.vo.Member.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		// �Է����� ��û�� ��
		Member loginInfo = (Member) model.get("loginInfo");
		if (loginInfo.getEmail() == null) {
			return "/auth/LoginForm.jsp";
		} else { // ȸ�� ����� ��û�� ��
			// MemberDao memberDao = (MemberDao)model.get("memberDao");
			String email = loginInfo.getEmail();
			String pwd = loginInfo.getPwd();
			System.out.println(email);
			System.out.println(pwd);
			Member member = memberDao.exist(email, pwd);
			if (member != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("member", member);
				return "redirect:../member/list.do";
			} else {
				return "/auth/LoginFail.jsp";
			}
		}
	}
}
