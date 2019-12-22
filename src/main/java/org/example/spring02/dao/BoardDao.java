package org.example.spring02.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.example.spring02.dto.BoardDto;
import org.example.spring02.form.BoardForm;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {

	@Resource(name = "sqlSession")
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "org.example.spring02.boardMapper";
	
//	게시판 - 목록 조회
	public List<BoardDto> getBoardList(BoardForm boardForm) {
		return sqlSession.selectList(NAMESPACE + ".getBoardList", boardForm);
	}

//	게시판 - 조회 수 수정
	public int updateBoardHits(BoardForm boardForm) {
		return sqlSession.update(NAMESPACE + ".updateBoardHits", boardForm);
	}

//	게시판 - 상세 조회
	public BoardDto getBoardDetail(BoardForm boardForm) {
		return sqlSession.selectOne(NAMESPACE + ".getBoardDetail", boardForm);
	}

//	 게시판 - 등록
	public int insertBoard(BoardForm boardForm) {
		return sqlSession.insert(NAMESPACE + ".insertBoard", boardForm);
	}
	
//	게시판 - 등록 실패(트랜잭션 테스트)
	public int insertBoardFail(BoardForm boardForm) 
	{
		return sqlSession.insert(NAMESPACE + ".insertBoardFail", boardForm);
	}

//	게시판 - 삭제
	public int deleteBoard(BoardForm boardForm) {
		return sqlSession.delete(NAMESPACE + ".deleteBoard", boardForm);
	}

//	게시판 - 수정
	public int updateBoard(BoardForm boardForm) {
		return sqlSession.update(NAMESPACE + ".updateBoard", boardForm);
	}

}
