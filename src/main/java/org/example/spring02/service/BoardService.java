package org.example.spring02.service;

import java.util.List;

import org.example.spring02.dao.BoardDao;
import org.example.spring02.dto.BoardDto;
import org.example.spring02.form.BoardForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;

	public List<BoardDto> getBoardList(BoardForm boardForm) throws Exception {
		return boardDao.getBoardList(boardForm);
	}

}
