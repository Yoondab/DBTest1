package kr.or.ddit.borad.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.borad.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardInsertController {
	
	@Inject
	private IBoardService boardService;

	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public String boardForm() {
		return "board/form";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String boardInsert(BoardVO boardVO, Model model) {
		String goPage = "";		//이동 페이지 설정
		
		// 넘겨 받은 데이터가 잘못되었을 때 에러를 담을 공간
		Map<String, String> errors = new HashMap<String, String>();
		
		// 제목이 입력되지 않고 넘어왔을 때, 에러를 담는다
		if(StringUtils.isBlank(boardVO.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해주세요");
		}
		
		// 내용이 입력되지 않고 넘어왔을 때, 에러를 담는다
		if(StringUtils.isBlank(boardVO.getBoContent())) {
			errors.put("boContent", "내용을 입력해주세요");
		}
		
//		내용을 기입하지 않고 등록을 눌렀을 때 forword로 전에 했던 것을 보내줌
		if(errors.size() > 0) {		// 에러발생
			model.addAttribute("board", boardVO);
			model.addAttribute("errors", errors);
			goPage = "board/form";
		}else {		// 정상적인 데이터 입력(정상)
			boardVO.setBoWriter("a001"); 	// 로그인 처리를 하지 않았으므로 작성자 하드코딩
			// 게시글 등록 성공: OK
			// 게시글 등록 실패: Failed
			ServiceResult result = boardService.insertBoard(boardVO);

			// 이 떄는 리다이렉트
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/board/detail.do?boNo=" + boardVO.getBoNo();
			}else {
				model.addAttribute("board", boardVO);
				model.addAttribute("failed", "서버에러, 다시 시도해주세요");
				goPage = "board/form";
			}
		}
		return goPage;
	}

}
