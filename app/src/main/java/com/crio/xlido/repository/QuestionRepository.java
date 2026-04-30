package com.crio.xlido.repository;

import com.crio.xlido.model.Question;
import java.util.*;

public class QuestionRepository {
    private Map<Integer, Question> questions = new HashMap<>();

    public void save(Question q) {
        questions.put(q.getId(), q);
    }

    public Question findById(int id) {
        return questions.get(id);
    }

    public List<Question> findAll() {
        return new ArrayList<>(questions.values());
    }

    public void delete(int id) {
        questions.remove(id);
    }
}