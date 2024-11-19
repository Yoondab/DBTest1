package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	// 1) 요청 uri는 '/' 또는 '/main.do'인 목적지인 컨트롤러 메소드 main메소드가 있습니다.
	// 브라우저 주소 입력창에 localhost를 입력했을 때, 해당 메소드가 요청을 받아들여
	// 실행되게 만들어주세요
	// 이때, return 으로 이동해야하는 페이지는 main.jsp입니다
	// 브라우저 결과 화면으로 main.jsp 페이지가 결과로 출력될 수 있도록 해주세요
	@RequestMapping(value = {"/", "/main.do"}, method = RequestMethod.GET)
	public String main() {
		// 일반게시판 , 자유게시판, 공지사항 게시판 총 3개의 게시판 데이터를 
		// 메인화면에 각 게시판 영역에 최신글 5개를 출력해주세요
		
		// 그리고 각 게시판 영역별 총 게시글 수도 함께 표시해주세요
		// 메인 화면을 브라우저에 띄워보면 어떤 영역에 어떤 데이터를 넣어야할지가 보여집니다
		return "main";
	}
}
