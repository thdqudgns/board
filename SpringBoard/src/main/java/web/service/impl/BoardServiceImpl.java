package web.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import web.dao.face.BoardDao;
import web.dto.Board;
import web.dto.Boardfile;
import web.service.face.BoardService;
import web.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardDao boardDao;
	@Autowired private ServletContext context;
	
	@Override
	public List<Board> list(Paging paging) {
		
		return boardDao.selectList(paging);
	}

	@Override
	public Paging getPaging(Paging paramData) {
		
		//총 게시글 수 조회
		int totalCount = boardDao.selectCntAll();
		
		//페이징 계산
		Paging paging = new Paging(totalCount, paramData.getCurPage());
		
		return paging;
	}
	
	@Override
	public Board view(Board viewBoard) {
		
		boardDao.hit(viewBoard); //조회수 증가
		
		return boardDao.selectBoardByBoardno(viewBoard);
	}
	
	@Override
	public void write(Board board, MultipartFile file) {

		//게시글 정보 처리
		
		if( "".equals(board.getTitle()) ) {
			board.setTitle("(제목없음)");
		}
		boardDao.insertBoard(board);
		
		//--------------------------------------------------------
		
		//빈 파일
		if( file.getSize() <= 0 ) {
			return;
		}
		
		//파일이 저장될 경로
		String storedPath = context.getRealPath("upload");
	
		File storedFolder = new File(storedPath);
		if( !storedFolder.exists() ) {
			storedFolder.mkdir();
		}
		
		//저장될 파일의 이름 생성하기
		String originName = file.getOriginalFilename();
		String storedName = originName + UUID.randomUUID().toString().split("-")[4];
		
		//저장할 파일 객체
		File dest = new File(storedPath, storedName);
		
		try {
			file.transferTo(dest); //업로드 파일 저장
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		//--------------------------------------------------------
		
		Boardfile boardfile = new Boardfile();
		boardfile.setBoardNo( board.getBoardNo() );
		boardfile.setOriginName(originName);
		boardfile.setStoredName(storedName);
		
		boardDao.insertFile(boardfile);
	}
	
	@Override
	public Boardfile getAttachFile(Board viewBoard) {
		return boardDao.selectBoardfileByBoardno(viewBoard);
	}
	
	@Override
	public Boardfile getFile(int fileNo) {
		return boardDao.selectBoardfileByFileno(fileNo);
	}

	@Override
	public void boardDelete(Board boardNo) {
		boardDao.deleteBoardFile(boardNo);
		boardDao.deleteBoard(boardNo);
	}

	@Override
	public Board boardView(Board board) {
		return boardDao.selectBoardByBoardno(board);
	}

	@Override
	public void boardUpdate(Board updateBoard) {
		boardDao.updateBoard(updateBoard);
	}
	
}






















