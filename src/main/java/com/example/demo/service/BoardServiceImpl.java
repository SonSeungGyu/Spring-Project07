package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

@Service//서비스 클래스로 지정
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository repository;

	@Override
	public int register(BoardDTO dto) {
		Board entity = dtoToEntity(dto);

		repository.save(entity);

		int newNo = entity.getNo();

		System.out.println(entity);

		return newNo;
	}

	@Override
	public List<BoardDTO> getList() {
		//데이터베이스에서 목록을 가져옴
		List<Board> result = repository.findAll();
		//list 생성
		List<BoardDTO> list = new ArrayList<>();
		
		list = result.stream()//리스트에 스트림 생성
				.map(entity -> entityToDto(entity))//중간연산으로 엔티티를 dto로 변환
				.collect(Collectors.toList());//최종연산으로 결과를 리스트로 변환
		return list;//dto리스트 반환
	}

}
