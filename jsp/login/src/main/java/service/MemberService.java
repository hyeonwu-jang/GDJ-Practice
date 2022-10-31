package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface MemberService {

	public ActionForward login(HttpServletRequest request, HttpServletResponse response);
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response);
	public void join(HttpServletRequest request, HttpServletResponse response);
	public void out(HttpServletRequest request, HttpServletResponse response);
}
