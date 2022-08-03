package com.ncs.student.util;

import org.springframework.stereotype.Component;

import com.ncs.student.dto.QuizResultDTO;
import com.ncs.student.model.Result;
import com.ncs.student.model.User;

@Component
public class QuizResultDTOConversion {

	public Result convertToResultResponse(User user, QuizResultDTO quiz) {
		Result r = new Result();

		r.setDate(quiz.getDate());
		r.setUser(user);
		r.setCategory(quiz.getCategory());
		r.setLevel(quiz.getLevel());
		int totalScore = quiz.getTotalScore();
		r.setTotalScore(totalScore);
		// 20 = 100% , 15 = 75%, 10 = 50%
		int marks = (int) ((totalScore * 100) / 20);
		r.setMarks(marks);

		return r;
	}

}
