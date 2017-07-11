package com.example.user.stinner;

import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String[] friut = new String []{"香蕉","蘋果","鳳梨"};
    TextView textView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayAdapter<String> adapterFruit = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,friut);
        adapterFruit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterFruit);

        //監聽選取文字
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String s = spinner.getItemAtPosition(position).toString();

                textView.setText(s);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText(friut[0]);

            }
        });

        //選取功能
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox.isChecked()){
                    Toast.makeText(MainActivity.this,"選取",Toast.LENGTH_SHORT).show();
                    checkBox.setText("取消選取");
                }
                else {
                    Toast.makeText(MainActivity.this,"取消選取",Toast.LENGTH_SHORT).show();
                    checkBox.setText("選取");
                }
            }
        });


    }
}
