package com.epam.hogwarts.entity;

public class Answer extends AbstractEntity {
    
    private long questionId;
    private String text;
    private boolean isCorrect;

    public Answer(long entityId, long questionId, String text, boolean isCorrect) {
        super(entityId);
        this.questionId = questionId;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
