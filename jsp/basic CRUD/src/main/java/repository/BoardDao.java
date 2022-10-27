package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Board;

public class BoardDao {
	
	private SqlSessionFactory factory;
	
	private static BoardDao dao = new BoardDao();
	
	private BoardDao() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.board.";
	
	public List<Board> listBoard() {
		SqlSession ss = factory.openSession();
		List<Board> boards = ss.selectList(mapper + "listBoard");
		ss.close();
		return boards;
	}
	
	public int listCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "listCount");
		ss.close();
		return count;
	}
	
	public Board detailBoard(int boardNo) {
		SqlSession ss = factory.openSession();
		Board board = ss.selectOne(mapper + "detailBoard", boardNo);
		ss.close();
		return board;
	}
	
	
	public int insertBoard(Board board) {
		SqlSession ss = factory.openSession();
		int result = ss.insert(mapper + "insertBoard", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}

	public int updateBoard(Board board) {
		SqlSession ss = factory.openSession();
		int result = ss.update(mapper + "updateBoard", board);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteBoard(int boardNo) {
		SqlSession ss = factory.openSession();
		int result = ss.delete(mapper + "deleteBoard", boardNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	
	
	
}
