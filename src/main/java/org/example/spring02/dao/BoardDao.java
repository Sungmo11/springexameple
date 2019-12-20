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
	
	public List<BoardDto> getBoardList(BoardForm boardForm) {
		return sqlSession.selectList(NAMESPACE + ".getBoardList");
	}

}
