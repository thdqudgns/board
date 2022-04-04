package web.dao.face;

import web.dto.Member;

public interface MemberDao {

	/**
	 * id/pw로 조회된 사용자 수를 반환한다
	 *  -> 로그인 인증에 활용
	 *  
	 * @param member - 조회할 id/pw를 가진 객체
	 * @return 조회된 행 수
	 */
	public int selectCntMember(Member member);

	/**
	 * id를 이용하여 nick을 조회한다
	 * 
	 * @param member - 조회하려는 회원의 id를 가진 DTO객체
	 * @return 조회된 nick
	 */
	public String selectNickByMember(Member member);

	/**
	 * id가 존재하는 값인지 확인한다
	 * 
	 * @param member - 조회하려는 회원의 id를 가진 DTO객체
	 * @return 존재 여부 (0 - 없음, 1 - 있음)
	 */
	public int selectCntById(Member member);

	/**
	 * 회원의 정보를 새롭게 삽입한다
	 * 
	 * @param member - 신규 회원 정보
	 */
	public void insert(Member member);

}
