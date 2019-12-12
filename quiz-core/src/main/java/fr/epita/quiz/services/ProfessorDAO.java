package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Professor;

public class ProfessorDAO extends DAO<Professor> {

	@Override
	protected String getQueryString() {

		return "from Professor prof where prof.name like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Professor professor) {
		map.put("pContent", "%" + professor.getName() + "%");
		
	}

}
