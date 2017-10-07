package com.hkucs.amanjohar.card24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        start = (Button)findViewById(R.id.start);

        start.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
               sendMessage(view);
            }
        });
    }

    Button start;
    public static final String EXTRA_MESSAGE = "com.hkucs.amanjohar.card24.MESSAGE";

    public void sendMessage(View View)
    {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


}
