package fr.epita.quiz.services;

import java.util.Map;

import fr.epita.quiz.datamodel.Student;

public class StudentDAO extends DAO<Student> {

	@Override
	protected String getQueryString() {
		
		return "from Student std where std.name like :pContent";
	}

	@Override
	protected void fillParametersMap(Map<String, Object> map, Student student) {
		map.put("pContent", "%" + student.getName() + "%");
		
	}

}
