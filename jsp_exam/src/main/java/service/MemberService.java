package service;

import domain.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO mvo);

	int join(MemberVO mvo);

	MemberVO detail(String id);

	int modify(MemberVO mvo);

	int remove(String id);

}
