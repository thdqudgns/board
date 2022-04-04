package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);

	@Autowired private MemberDao memberDao;
	
	@Override
	public boolean login(Member member) {
		int loginChk = memberDao.selectCntMember(member);
		
		if(loginChk > 0)	return true;

		return false;
	}
	
	@Override
	public String getNick(Member member) {
		return memberDao.selectNickByMember(member);
	}
	
	@Override
	public boolean join(Member member) {
		
		//중복 ID 확인
		if( memberDao.selectCntById(member) > 0 ) {
			return false;
		}
		
		//회원가입(삽입)
		memberDao.insert(member);
		
		//회원가입 결과 확인
		if( memberDao.selectCntById(member) > 0 ) {
			return true;
		}
		
		return false;
	}
}




















