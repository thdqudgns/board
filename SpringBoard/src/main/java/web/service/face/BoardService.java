package web.service.face;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import web.dto.Board;
import web.dto.Boardfile;
import web.util.Paging;

public interface BoardService {

	/**
	 * 페이징이 적용된 게시글 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return 페이징이 적용된 게시글 목록
	 */
	public List<Board> list(Paging paging);

	/**
	 * 게시글 목록을 위한 페이징 객체를 생성한다
	 * 
	 * 	파라미터 객체의 curPage(현재 페이지)
	 * 	DB에서 조회한 totalCount(총 게시글 수)
	 * 
	 * 	두 가지 데이터를 활용하여 페이징객체를 생성하여 반환한다
	 * 
	 * @param paramData - curPage를 저장하고있는 객체
	 * @return 계산이 완료된 Paging객체
	 */
	public Paging getPaging(Paging paramData);

	/**
	 * 게시글 상세보기
	 * 
	 * @param viewBoard - 상세 조회할 게시글 번호 DTO
	 * @return 조회된 상세 게시글 정보
	 */
	public Board view(Board viewBoard);

	/**
	 * 게시글 + 첨부파일을 처리한다
	 * 
	 * @param board - 게시글 정보 DTO
	 * @param file - 첨부파일 정보 DTO
	 */
	public void write(Board board, MultipartFile file);

	/**
	 * 게시글번호를 이용하여 업로드된 파일의 정보를 조회한다
	 * 
	 * @param viewBoard - 조회할 게시글 번호를 가진 객체
	 * @return 첨부파일 정보
	 */
	public Boardfile getAttachFile(Board viewBoard);

	/**
	 * 파일번호를 이용하여 업로드된 파일의 정보를 조회한다
	 * 
	 * @param fileNo - 조회할 파일 번호
	 * @return 첨부파일 정보
	 */
	public Boardfile getFile(int fileNo);

	/**
	 * 글 번호를 매개변수로 하여 글 삭제하기
	 * 
	 * @param boardNo - 글 번호
	 */
	public void boardDelete(Board boardNo);

	/**
	 * 글 번호를 매개변수로 해당 글의 데이터 조회하기
	 * 
	 * @param board - 글 번호가 담긴 객체
	 * @return - Board의 모든 데이터 반환
	 */
	public Board boardView(Board board);

	/**
	 * 수정된 내용 DB에 update하기
	 * 
	 * @param updateBoard - 수정된 정보가 담긴 객체
	 */
	public void boardUpdate(Board updateBoard);

}






















