package repository;

import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Member;

public class MemberDao {
	
	private SqlSessionFactory factory;
	
	private static MemberDao dao = new MemberDao();
	
	private MemberDao() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.member.";
	
	public Member login(Member member) {
		SqlSession ss = factory.openSession();
		Member loginMember = ss.selectOne(mapper + "login", member);
		ss.close();
		return loginMember;
	}

	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert(mapper + "insertMember", member);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteMember(long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete(mapper + "deleteMember", no);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
