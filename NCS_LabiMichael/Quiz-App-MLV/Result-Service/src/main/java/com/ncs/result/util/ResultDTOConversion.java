package com.ncs.result.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ncs.result.dto.ResultResponseDTO;
import com.ncs.result.model.Result;

@Component
public class ResultDTOConversion {

	public ResultResponseDTO convertToResponse(Result r) {
		ResultResponseDTO dto = new ResultResponseDTO();
		dto.setTestId(r.getTestId());
		dto.setUserId(r.getUser().getUserId());
		dto.setDate(r.getDate());
		dto.setCategory(r.getCategory());
		dto.setLevel(r.getLevel());
		dto.setMarks(r.getMarks());
		dto.setTotalScore(r.getTotalScore());
		return dto;

	}

	public List<ResultResponseDTO> convertToResponse(List<Result> list) {
		List<ResultResponseDTO> listDTO = new ArrayList<ResultResponseDTO>();
		for (Result result : list) {
			ResultResponseDTO dto = convertToResponse(result);
			listDTO.add(dto);
		}
		return listDTO;

	}

}
