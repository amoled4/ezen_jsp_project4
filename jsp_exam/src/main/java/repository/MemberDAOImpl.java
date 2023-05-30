package repository;

import org.apache.ibatis.session.SqlSession;

import domain.MemberVO;
import orm.DatabaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private SqlSession sql;
	private String NS = "MemberMapper.";
	private int isOk;
	
	public MemberDAOImpl() {
		new DatabaseBuilder();
		sql = DatabaseBuilder.getFactory().openSession();
	}

	@Override
	public MemberVO selectLogin(MemberVO mvo) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public int insertJoin(MemberVO mvo) {
		isOk = sql.insert(NS+"join", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public MemberVO selectDetail(String id) {
		// TODO Auto-generated method stub
		return sql.selectOne(NS+"detail",id);
	}

	@Override
	public int updateMod(MemberVO mvo) {
		isOk = sql.update(NS+"modify", mvo);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}

	@Override
	public int deleteRem(String id) {
		isOk = sql.delete(NS+"remove", id);
		if(isOk>0) {
			sql.commit();
		}
		return isOk;
	}
}
