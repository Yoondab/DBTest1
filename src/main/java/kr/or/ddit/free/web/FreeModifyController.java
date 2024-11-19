package kr.or.ddit.free.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.free.service.IFreeService;

@Controller
@RequestMapping("/free")
public class FreeModifyController {

	@Inject
	private IFreeService freeService;
	
	// 자유 게시판 수정 폼 페이지
	// 목적지 주소 uri: /update.do
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public String freeUpdateForm() {
		return "free/update";
	}
	
	// 자유 게시판 수정
	// 목적지 주소 uri: /update.do
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String freeUpdate() {
		return "free/update";
	}
	
	// 자유 게시판 삭제
	// 목적지 주소 uri: /delete.do
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public String freeDelete() {
		return "free/delete";
	}
	
}
