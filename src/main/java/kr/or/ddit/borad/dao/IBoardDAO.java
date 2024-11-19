package kr.or.ddit.borad.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardDAO {

	public int insertBoard(BoardVO boardVO);

	public BoardVO selectBoard(int boNo);

	public void incrementHit(int boNo);

	public int updateBoard(BoardVO boardVO);

	public int deleteBoard(int boNo);

	public List<BoardVO> selectBoardList();

	public List<BoardVO> selectBoardList(PaginationInfoVO<BoardVO> pagingVO);

	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

}
