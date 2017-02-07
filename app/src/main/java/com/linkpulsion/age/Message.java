package com.linkpulsion.age;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Message extends AppCompatActivity {

    private TextView message;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        message = (TextView)findViewById(R.id.message);
        layout = (ConstraintLayout)findViewById(R.id.constraint);

        Bundle content = getIntent().getExtras();

        message.setText(content.getString("MESSAGE"));

        Snackbar.make(layout,content.getString("MESSAGE"),Snackbar.LENGTH_LONG).show();
    }
}
