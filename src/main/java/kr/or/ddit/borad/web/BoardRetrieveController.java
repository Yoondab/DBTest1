package kr.or.ddit.borad.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.borad.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	@Inject
	private IBoardService boardService;

	
	// 요청 uri는 /board/list.do 이고.
	// 이동할 페이지는 board 폴더 안에 들어있는 list.jsp로 이동해주세요
	
	// 일반 게시판 목록 페이지 요청
	@RequestMapping(value="/list.do")		// method = RequestMethod.GET를 넣으면 405에러가 떠서 지워줬음
	public String boardList(
			@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model) {
		// [방법 1] - 일반적인 목록 조회
//		List<BoardVO> boardList = boardService.selectBoardList();
//		model.addAttribute("boardList", boardList);
		
		
		// [방법 2] - 페이징 및 검색이 적용된 목록 조회
		PaginationInfoVO<BoardVO> pagingVO = new PaginationInfoVO<BoardVO>(10,5);
		
		// 브라우저에서 검색한 검색 유형, 검색 키워드를 이용한 검색 처리
		// 검색 키워드가 있으면 검색을 한거고, 키워드가 없다면 검색을 하지 않음.
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		// startRow, endRow, startPage, endPage가 결정
		pagingVO.setCurrentPage(currentPage);
		// 총 게시글 수 얻기
		int totalRecord = boardService.selectBoardCount(pagingVO);
		// 총 페이지결정
		pagingVO.setTotalRecord(totalRecord);
		// 각 페이지에 대한 screenSize 만큼의 게시글 목록을 가져온다
		List<BoardVO> dataList = boardService.selectBoardList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "board/list";
	}
	
	// 일반 게시판 상세보기 페이지 요청
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String boardDetail(int boNo, Model model) {
		BoardVO boardVO = boardService.selectBoard(boNo);
		model.addAttribute("board", boardVO);
		return "board/view";
	}

}
