package com.example.jasonholt.starcraft2beginnersquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ExamActivity extends AppCompatActivity {

    private Questions questions;
    private LinkedHashMap<Integer, ArrayList<Answer>> answers = new LinkedHashMap<>();
    private ArrayList<Answer> questionOneAnswers = new ArrayList<>();
    private ArrayList<Answer> questionTwoAnswers = new ArrayList<>();
    private ArrayList<Answer> questionThreeAnswers = new ArrayList<>();
    private LinearLayout linearLayout;
    private int[] questionPositions;
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        Intent mIntent = getIntent();

        // Decide which set of questions and answers to load based on the the button ID passed from the previous activity.
        int buttonID = mIntent.getIntExtra("button", 0);
        if (buttonID == 0) {
            Log.e("OnCreate_Exam_Activity", "Something is wrong with the button ID assignments/data transfer to this view.");
        } else {
            if (buttonID == R.id.protoss_button) loadQuestions(R.array.protoss_questions);
            if (buttonID == R.id.terran_button) loadQuestions(R.array.zerg_questions);
            if (buttonID == R.id.zerg_button) loadQuestions(R.array.terran_questions);
        }
    }

    private void loadQuestions(int resourceId) {

        // Load the questions in the XML resource file into an array list

        questions = new Questions(new ArrayList<String>());
        for (int i = 0; i < getResources().getStringArray(resourceId).length; i++) {
            String question = context.getResources().getStringArray(resourceId)[i];
            questions.addQuestion(question);
        }

        loadAnswers(resourceId);
        loadLayout(resourceId);
        loadAnswerLayout();

    }

    private void loadAnswers(int resourceId) {

        if(resourceId == R.array.protoss_questions)
        {
            answers.put(R.array.protossAnswers_1, questionOneAnswers);
            answers.put(R.array.protossAnswers_2, questionTwoAnswers);
            answers.put(R.array.protossAnswers_3, questionThreeAnswers);

            for (LinkedHashMap.Entry<Integer, ArrayList<Answer>> entry : answers.entrySet()) {
                int id = entry.getKey();
                for(int i = 0; i < context.getResources().getStringArray(id).length; i++)
                {
                    entry.getValue().add(new Answer(context.getResources().getStringArray(id)[i]));
                }
            }
        }
        if(resourceId == R.array.terran_questions)
        {

        }
        if(resourceId == R.array.zerg_questions)
        {

        }
    }

    private void loadLayout(int resourceId) {
        questionPositions = new int[context.getResources().getStringArray(resourceId).length];
        linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for (String question : questions.getQuestions()) {
            TextView textView = new TextView(this);
            textView.setText(question);
            linearLayout.addView(textView);
            questionPositions[linearLayout.indexOfChild(textView)] = linearLayout.indexOfChild(textView) + 1;
        }
    }

    private void loadAnswerLayout() {

        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(questionOneAnswers.get(0).getAnswerText());
        linearLayout.addView(checkBox, questionPositions[0]);

    }

}
