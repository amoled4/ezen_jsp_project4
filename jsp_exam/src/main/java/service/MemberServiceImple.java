package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImpl;

public class MemberServiceImple implements MemberService {
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImple.class);
	
	private MemberDAO mdao;
	
	public MemberServiceImple() {
		mdao = new MemberDAOImpl();
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		log.info(">>> login service in");
		return mdao.selectLogin(mvo);
	}

	@Override
	public int join(MemberVO mvo) {
		log.info(">>> join service in");
		return mdao.insertJoin(mvo);
	}

	@Override
	public MemberVO detail(String id) {
		log.info(">>> detail service in");
		return mdao.selectDetail(id);
	}

	@Override
	public int modify(MemberVO mvo) {
		log.info(">>> modify service in");
		return mdao.updateMod(mvo);
	}

	@Override
	public int remove(String id) {
		log.info(">>> remove service in");
		return mdao.deleteRem(id);
	}
}
