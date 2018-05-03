package com.example.jasonholt.starcraft2beginnersquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ExamActivity extends AppCompatActivity {

    //private ArrayList<String> questions = new ArrayList<String>();
    private Context context = this;
    private QuestionModel questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        // This solution is partially taken from https://stackoverflow.com/questions/28051187/how-can-i-pass-an-button-id-to-other-activity-android
        Intent mIntent = getIntent();
        int buttonID = mIntent.getIntExtra("button", 0);
        if (buttonID == 0) {
            Log.e("OnCreate_Exam_Activity", "Something is wrong related to button ID assignments/data transfer to this view.");
        } else {
            if (buttonID == R.id.protoss_button)
            {
                questions = new QuestionModel(R.array.protoss_questions);
            }
            /*if (buttonID == R.id.terran_button) loadTerranQuestions();
            if (buttonID == R.id.zerg_button) loadZergQuestions();*/
        }
    }

/*    private void loadZergQuestions() {
        for (int i = 0; i < getResources().getStringArray(R.array.zerg_questions).length - 1; i++) {
            String question =  context.getResources().getStringArray(R.array.zerg_questions)[i];
            questions.add(question);
        }

        loadLayout();
    }

    private void loadTerranQuestions() {
        for (int i = 0; i < getResources().getStringArray(R.array.terran_questions).length - 1; i++) {
            String question =  context.getResources().getStringArray(R.array.terran_questions)[i];
            questions.add(question);
        }
        loadLayout();
    }

    private void loadProtossQuestions() {

        for (int i = 0; i < getResources().getStringArray(R.array.protoss_questions).length - 1; i++) {
            String question =  context.getResources().getStringArray(R.array.protoss_questions)[i];
            questions.add(question);
        }

        loadLayout();
    }*/

    private void loadLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ArrayList<String> questionsToLoad = questions.getQuestions();
        for (String question : questionsToLoad) {
            TextView textView = new TextView(this);
            textView.setText(question);
            linearLayout.addView(textView);
        }
    }


}
