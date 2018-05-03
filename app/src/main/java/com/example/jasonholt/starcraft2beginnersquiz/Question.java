package com.example.jasonholt.starcraft2beginnersquiz;

import java.util.ArrayList;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class Question {

    private ArrayList<String> questions;

    public Question(ArrayList<String> questions)
    {
        this.questions = questions;
    }

    public ArrayList<String> getQuestions()
    {
        return questions;
    }

    public void setQuestions(ArrayList<String> questions) {
        this.questions = questions;
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
