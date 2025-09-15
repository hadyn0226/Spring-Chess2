package com.example.chess.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chess.dto.TTable;
import com.example.chess.mapper.TTableMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TTableService {
	
	private final TTableMapper ttableMapper;
	
	public List<TTable> finaAll() {
		return ttableMapper.findAll();
	}
	
}
