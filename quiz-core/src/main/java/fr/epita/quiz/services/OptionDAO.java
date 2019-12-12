package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Option;

public class OptionDAO extends DAO<Option> {

	@Override
	protected String getQueryString() {
		
		return "from Option opt where opt.content like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Option option) {
		map.put("pContent", "%" + option.getContent() + "%");
		
	}

}
