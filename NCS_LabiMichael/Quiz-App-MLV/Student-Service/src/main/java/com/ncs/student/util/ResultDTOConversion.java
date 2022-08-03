package com.ncs.student.util;

import org.springframework.stereotype.Component;

import com.ncs.student.dto.ResultResponseDTO;
import com.ncs.student.model.Result;

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

}
