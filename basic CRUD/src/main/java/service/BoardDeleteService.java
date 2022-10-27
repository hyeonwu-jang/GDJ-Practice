package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.BoardDao;

public class BoardDeleteService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt.orElse("0"));

		int result = BoardDao.getInstance().deleteBoard(boardNo);
		
		return new ActionForward("board/deleteResult.jsp?result=" + result, true);
	}

}
