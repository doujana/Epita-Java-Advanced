package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Quiz;

public class QuizDAO extends DAO<Quiz>{

	@Override
	protected String getQueryString() {
		
		return "from Option o where o.content like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Quiz quiz) {
		map.put("pContent", "%" + quiz.getQuizeName() + "%");
		
	}

}
