package com.epam.hogwarts.entity;

public class Answer extends AbstractEntity {
    
    private final long questionId;
    private final String text;
    private final boolean isCorrect;

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
}
