package com.example.demo.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.BoardDTO;

@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService service;
	
	@Test
	public void 게시물등록() {
		BoardDTO dto = BoardDTO.builder()
						.title("2번")
						.content("내용")
						.writer("또치")
						.build();
		int no = service.register(dto);
		
		System.out.println("새로운 게시물 번호: " + no);
	}
	
	@Test
	public void 게시물목록조회() {
		
		List<BoardDTO> list = service.getList();
		
		for (BoardDTO boardDTO : list) {
			System.out.println(boardDTO);
		}
	}
	
	@Test
	public void 게시물단건조회() {
		BoardDTO dto = service.read(2);
		System.out.println(dto);
	}
	
	
	@Test
	public void 게시물수정() {
		//게시물을 조회하기 위해선 db에서 데이터를 읽어와야 하므로 dto로 변환해주어야 함
		BoardDTO dto = service.read(4); 
		dto.setContent("수정");
		dto.setTitle("내용도 수정");
		service.modify(dto);
		System.out.println(dto);
	}
}
