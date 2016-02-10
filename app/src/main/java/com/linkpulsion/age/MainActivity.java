package com.linkpulsion.age;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout nameLay;
    private EditText name;
    private RadioButton man,woman;
    private DatePicker picker;
    private CoordinatorLayout bgLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLay = (TextInputLayout)findViewById(R.id.name_layout);
        name = (EditText)findViewById(R.id.name_input);
        man = (RadioButton)findViewById(R.id.man);
        woman = (RadioButton)findViewById(R.id.woman);
        picker = (DatePicker)findViewById(R.id.picker);
        bgLay = (CoordinatorLayout)findViewById(R.id.bg_layout);

        nameLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameLay.isErrorEnabled()){
                    nameLay.setErrorEnabled(false);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                compute(this);
                return true;
        }
    }

    private void compute(Context context){
        if(name.getText().toString().equals("")){
            nameLay.setError(getString(R.string.err_input));
            nameLay.setErrorEnabled(true);
        }else{
            int dateNaiss = picker.getYear();
            int age = Calendar.getInstance().get(Calendar.YEAR) - dateNaiss;

            String res;

            if(man.isChecked()){
                res = "Mon cher " + name.getText().toString() + " tu as " + age + " ans";
                Toast.makeText(context,res,Toast.LENGTH_LONG).show();
            }else{
                res = "Ma chere " + name.getText().toString() + " tu as " + age + " ans";
                Toast.makeText(context,res,Toast.LENGTH_LONG).show();
            }

            if(age == 18){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://fr.wikipedia.org/wiki/Majorité")));
            }else{
                Intent message = new Intent(this,Message.class);
                message.putExtra("MESSAGE",res);
                startActivity(message);
            }
        }
    }
}
