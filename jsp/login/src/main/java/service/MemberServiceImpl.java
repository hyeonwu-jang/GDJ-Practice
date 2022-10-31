package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.Member;
import repository.MemberDao;

public class MemberServiceImpl implements MemberService {

	@Override
	public ActionForward login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		Member loginMember = MemberDao.getInstance().login(member);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			return new ActionForward(request.getContextPath(), true);
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	@Override
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		return new ActionForward(request.getContextPath(), true);
	}
	
	@Override
	public void join(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setEmail(email);
		
		int result = MemberDao.getInstance().insertMember(member);
		
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.println("<script>");
				out.println("alert('환영합니다.')");
				out.println("location.href='" + request.getContextPath() + "/index.jsp'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('다시 시도해주세요.')");
				out.println("history.back()");
				out.println("</script>");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void out(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		long no = loginMember.getNo();
		int result = MemberDao.getInstance().deleteMember(no);
		try {
			PrintWriter out = response.getWriter();
			if(result > 0) {
				session.invalidate();
				out.println("<script>");
				out.println("alert('이용해주셔서 감사합니다.')");
				out.println("location.href='" + request.getContextPath() + "'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('회원가입 탈퇴가 취소되었습니다.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
