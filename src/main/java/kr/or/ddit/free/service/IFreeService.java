package kr.or.ddit.free.service;

import java.util.List;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;


public interface IFreeService {

	public FreeVO selectFree(int feNo);

	public List<FreeVO> selectFreeList();

	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);



}
