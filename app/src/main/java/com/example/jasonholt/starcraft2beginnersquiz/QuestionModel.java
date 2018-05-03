package com.example.jasonholt.starcraft2beginnersquiz;

import java.util.ArrayList;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class QuestionModel extends AppCompatActivity{

    private ArrayList<String> questions;
    private Context context = this;

    public QuestionModel()
    {
        questions = new ArrayList<>();
        questions.add("No questions added. Default constructor called.");
    }

    public QuestionModel(int resourceID)
    {
        questions = new ArrayList<>();
        System.out.print(resourceID);
        try {
            for (int i = 0; i < (getResources().getStringArray(resourceID).length - 1); i++) {
                try {
                    String question = context.getResources().getStringArray(resourceID)[i];
                    questions.add(question);
                }
                catch (NullPointerException e)
                {
                    Log.e("For_loop", "Something is null in the for loop.");
                }
            }
        } catch (NullPointerException e)
        {
            Log.e("Question_Model", "QuestionModel has failed to instantiate.");
        }
    }

    public ArrayList<String> getQuestions()
    {
        return questions;
    }

}
