package kr.bit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.bit.entity.Criteria;
import kr.bit.mapper.DataSourceTest;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class) //servlet-context 연결
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //root-context 연결
public class BoardServiceTest {

	//root-context를 보고 di 하기 때문에 servlet-context에 있는 scan을 root로 옮겨줌.
	@Autowired
	BoardService boardService; 
	
	@Test
	public void testGetList() {
		//List<Board>
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(10);
		boardService.getList(cri).forEach(vo->log.info(vo));
	}
}
