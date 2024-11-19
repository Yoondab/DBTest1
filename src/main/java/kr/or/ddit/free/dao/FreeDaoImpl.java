package kr.or.ddit.free.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Repository
public class FreeDaoImpl implements IFreeDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public FreeVO selectFree(int feNo) {
		return sqlSession.selectOne("Free.selectFree", feNo);
	}

	@Override
	public List<FreeVO> selectFreeList() {
		return sqlSession.selectList("Free.selectFreeList_");
	}
	
	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
		return sqlSession.selectList("Free.selectFreeList", pagingVO);
	}

	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		return sqlSession.selectOne("Free.selectFreeCount", pagingVO);
	}

//	@Override
//	public void incrementHit(int feNo) {
//		return update("Free.incrementHit", feNo);
//	}

}
