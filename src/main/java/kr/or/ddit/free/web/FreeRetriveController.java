package kr.or.ddit.free.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/free")
public class FreeRetriveController {
	
	@Inject
	public IFreeService freeService;

	// 자유게시판 목록 페이지
	// 검색 및 페이징 처리
	// 목적지 주소 uri: /list.do
	@RequestMapping(value = "/list.do")
	public String freeList(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model
			) {
		
		List<FreeVO> boardList = freeService.selectFreeList();
		model.addAttribute("boardList", boardList);
		
		PaginationInfoVO<FreeVO> pagingVO = new PaginationInfoVO<FreeVO>(10,5);
		
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = freeService.selectFreeCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<FreeVO> dataList = freeService.selectFreeList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "free/list";
	}
	
	// 자유게시판 상세보기 페이지
	// 목적지 주소 uri: detail.do
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public String freeDetail(int feNo, Model model) {
		FreeVO freeVO = freeService.selectFree(feNo);
		model.addAttribute("free", freeVO);
		return "free/view";
	}
	
}
