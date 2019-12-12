package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDAO extends DAO<Answer> {

	@Override
	protected String getQueryString() {
	
		return "from Answer a where a.content like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Answer answer) {
		map.put("pContent", "%" + answer.getContent()+ "%");
		
	}

}
