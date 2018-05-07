package com.example.jasonholt.starcraft2beginnersquiz;

import android.view.View;

import java.util.ArrayList;

public class Questions {

    private ArrayList<String> questions;

    public Questions(ArrayList<String> questions)
    {
        this.questions = questions;
    }

    public ArrayList<String> getQuestions()
    {
        return questions;
    }

    public void addQuestion(String addition)
    {
        questions.add(addition);
    }

    public String getQuestion(int index)
    {
        return questions.get(index);
    }
}
