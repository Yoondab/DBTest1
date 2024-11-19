package kr.or.ddit.free.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.free.dao.IFreeDAO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;


@Service
public class FreeServiceImpl implements IFreeService {

	@Inject
	private IFreeDAO freeDao;
	
	@Override
	public FreeVO selectFree(int feNo) {
//		freeDao.incrementHit(feNo);
		return freeDao.selectFree(feNo);
	}

	@Override
	public List<FreeVO> selectFreeList() {
		return freeDao.selectFreeList();
	}

	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		return freeDao.selectFreeCount(pagingVO);
	}

	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
		return freeDao.selectFreeList(pagingVO);
	}

}
