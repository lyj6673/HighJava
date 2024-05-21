package kr.or.ddit.board.vo;

public class BoardVo {
	private int b_no;
	private String b_title;
	private String b_writer;
	private String b_date;
	private int b_cnt;
	private String b_content;
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_cnt() {
		return b_cnt;
	}
	public void setB_cnt(int b_cnt) {
		this.b_cnt = b_cnt;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	@Override
	public String toString() {
		return "boardVo [b_no=" + b_no + ", b_title=" + b_title + ", b_writer=" + b_writer + ", b_date=" + b_date
				+ ", b_cnt=" + b_cnt + ", b_content=" + b_content + "]";
	}
	
	
}
