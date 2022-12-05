package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository boardRepository; // = mapper

	@Override
	public List<Board> getList() {
		List<Board> list = boardRepository.findAll();
		return null;
	}

	@Override
	public void register(Board vo) {
		boardRepository.save(vo);
	}

}
