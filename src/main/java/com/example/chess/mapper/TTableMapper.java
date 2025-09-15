package com.example.chess.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.chess.dto.TTable;

@Mapper
public interface TTableMapper {
	
	List<TTable> findAll();
	
}
