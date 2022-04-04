package web.dto;

import java.util.Date;

public class Board {
	private int boardNo;	//글 번호(int)
	private String title;	//글 제목(String)
	private String content;	//글 내용(String)
	private String writerId;//작성자 아이디(String)
	private String writerNick;//작성자 닉(String)
	private int hit;		//조회수(int)
	private Date writeDate;	//날짜(Date)

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + ", writerId=" + writerId
				+ ", writerNick=" + writerNick + ", hit=" + hit + ", writeDate=" + writeDate + "]";
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getWriterNick() {
		return writerNick;
	}
	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
}
