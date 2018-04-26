package com.example.jasonholt.starcraft2beginnersquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.protoss_button, R.id.zerg_button, R.id.terran_button})
    public void pickButton(Button button)
    {
        Intent examScreenIntent = new Intent(MainActivity.this, ExamActivity.class);
        examScreenIntent.putExtra("button", button.getId());
        startActivity(examScreenIntent);
    }
}
