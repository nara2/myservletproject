package spms.controls;

import java.util.Map;

import spms.annotation.Component;
import spms.dao.MemberDao;

// Annotation ����
@Component("/member/list.do")
public class MemberListController implements Controller {
  MemberDao memberDao;
  
  public MemberListController setMemberDao(MemberDao memberDao) {
    this.memberDao = memberDao;
    return this;
  }

  @Override
  public String execute(Map<String, Object> model) throws Exception {
    model.put("members", memberDao.selectList());
    System.out.println("list.do execute...");
    return "/member/MemberList.jsp";
  }
}
