package com.epam.hogwarts.model.entity;

import java.util.ArrayList;

public class QuestionWithAnswers {
    private Question question;
    private ArrayList<Answer> answers;

    public QuestionWithAnswers(Question question, ArrayList<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
}
