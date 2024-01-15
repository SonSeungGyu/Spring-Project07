package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Board;


@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	BoardRepository repository;
	
	@Test
	void 게시물등록() {
		List<Board> list = new ArrayList<>();
		Board board1 = Board.builder()
						.title("1번글")
						.content("내용입니다")
						.writer("둘리")
						.build();
		list.add(board1);
		Board board2 = Board.builder()
				.title("2번글")
				.content("내용입니다")
				.writer("또치")
				.build();
		list.add(board2);
		Board board3 = Board.builder()
				.title("3번글")
				.content("내용입니다")
				.writer("도우너")
				.build();
		list.add(board3);
		repository.saveAll(list);
	}
	
	@Test
	void 게시물목록조회() {
		List<Board> list = repository.findAll();
		for (Board board : list) {
			System.out.println(board);
		}
		
	}
	
	@Test
	void 게시물단건조회() {
		Optional<Board> opt = repository.findById(1);
		if(opt.isPresent()) {
			Board board = opt.get();
			System.out.println(board);
		}
	}
	
	@Test
	void 게시물수정() {
		Optional<Board> opt = repository.findById(1);
		Board board = opt.get();
		board.setContent("수정");
		repository.save(board);
	}
	
	@Test
	void 게시물전체삭제() {
		repository.deleteAll();
	}
	@Test
	void 게시물단건삭제() {
		repository.deleteById(1);
	}
}
