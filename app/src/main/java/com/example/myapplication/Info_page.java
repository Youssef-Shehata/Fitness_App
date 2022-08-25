package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Info_page extends AppCompatActivity {
TextView details_tx;
LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        details_tx=findViewById(R.id.details);
        layout=findViewById(R.id.card_layout);
    }
    public void expand(View v)
    {
       int y=(details_tx.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        details_tx.setVisibility(y);
    }
}