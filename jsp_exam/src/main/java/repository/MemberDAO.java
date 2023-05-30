package repository;

import domain.MemberVO;

public interface MemberDAO {

	MemberVO selectLogin(MemberVO mvo);

	int insertJoin(MemberVO mvo);

	MemberVO selectDetail(String id);

	int updateMod(MemberVO mvo);

	int deleteRem(String id);

}
