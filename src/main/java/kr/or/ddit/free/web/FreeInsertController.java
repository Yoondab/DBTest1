package kr.or.ddit.free.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.free.service.FreeServiceImpl;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;

@Controller
@RequestMapping("/free")
public class FreeInsertController {
	
	@Inject
	private IFreeService FreeService;

	// 자유게시판 등록 페이지
	// 목적지 주소 uri: /form.do
	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public String freeForm() {
		return "free/form";
	}

	// 자유게시판 등록
	// 목적지 주소 uri: /insert.do
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String freeInsert(FreeVO freeVO, Model model) {
		return "free/insert";
	}
	
}
