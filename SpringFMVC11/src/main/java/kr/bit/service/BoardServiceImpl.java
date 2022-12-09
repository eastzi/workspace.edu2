package kr.bit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public List<Board> getList() {
		List<Board> list = boardRepository.findAll();
		return list;
	}

	@Override
	public void register(Board vo) {
		boardRepository.save(vo);
	}

	@Override
	public Board get(Long idx) {
		Optional<Board> vo = boardRepository.findById(idx);
		return vo.get();
	}

	@Override
	public void delete(Long idx) {
		boardRepository.deleteById(idx); //해당 id에 해당하는 데이터를 삭제하라.
	}

	@Override
	public void update(Board vo) {
		boardRepository.save(vo); //게시글 수정하기 -> vo에 idx가 있다면 update, 없다면 insert		
	}


}
