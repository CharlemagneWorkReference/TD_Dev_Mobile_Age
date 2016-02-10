package com.linkpulsion.age;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Message extends AppCompatActivity {

    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        message = (TextView)findViewById(R.id.message);

        Bundle content = getIntent().getExtras();

        message.setText(content.getString("MESSAGE"));

    }
}
