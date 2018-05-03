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

    private Question questions;
    private Context context = this;

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
            if (buttonID == R.id.protoss_button) loadQuestions(R.array.protoss_questions);
            if (buttonID == R.id.terran_button) loadQuestions(R.array.zerg_questions);
            if (buttonID == R.id.zerg_button) loadQuestions(R.array.terran_questions);
        }
    }

    private void loadQuestions(int resourceId) {

        ArrayList<String> questionList = new ArrayList<>();
        for (int i = 0; i < getResources().getStringArray(resourceId).length - 1; i++) {
            String question =  context.getResources().getStringArray(resourceId)[i];
            questionList.add(question);
        }
        questions = new Question(questionList);
        loadLayout();
    }


    private void loadLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        setContentView(linearLayout);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        for (String question : questions.getQuestions()) {
            TextView textView = new TextView(this);
            textView.setText(question);
            linearLayout.addView(textView);
        }
    }


}
