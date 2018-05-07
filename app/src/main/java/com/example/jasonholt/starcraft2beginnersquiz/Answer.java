package com.example.jasonholt.starcraft2beginnersquiz;

public class Answer {

    private boolean correctAnswer = false;
    private String answerText;

    public Answer(String answerText)
    {
        this.answerText = answerText;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerText() {
        return answerText;
    }

    public boolean getCorrectAnswer()
    {
        return correctAnswer;
    }
}
