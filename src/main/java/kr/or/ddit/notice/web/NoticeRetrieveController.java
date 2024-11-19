package kr.or.ddit.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {

	// 공지사항 게시판 목록 페이지
	// 페이징 및 검색기능
	// 목적지 uri: /list.do
	public String noticeList() {
		return null;
	}
	
	// 공지사항 게시판 상세보기 페이지
	// 목적지 uri: /detail.do
	public String noticeDetail() {
		return null;
	}
	
}
