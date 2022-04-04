package web.service.face;

import web.dto.Member;

public interface MemberService {

	/**
	 * 로그인 인증 처리
	 * 
	 * @param member - 입력한 ID/PW 정보
	 * @return 로그인 인증 결과
	 */
	public boolean login(Member member);

	/**
	 * 회원의 닉네임 조회
	 * 
	 * @param member - 닉네임을 조회하려는 사용자 정보
	 * @return 사용자의 닉네임
	 */
	public String getNick(Member member);

	/**
	 * 신규 회원 가입
	 * @param member - 신규 회원의 정보
	 * @return 회원가입 결과
	 */
	public boolean join(Member member);

}
