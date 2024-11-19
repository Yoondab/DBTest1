package kr.or.ddit.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	// 공지사항 게시판 수정 폼페이지
	// 목적지 uri: /form.do
	public String noticeForm() {
		return null;
	}

	// 공지사항 게시판 수정 폼페이지
	// 목적지 uri: /insert.do
	public String noticeInsert() {
		return null;
	}

}
