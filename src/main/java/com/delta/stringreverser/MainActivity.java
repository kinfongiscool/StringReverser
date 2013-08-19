package com.delta.stringreverser;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

/**
 * By David.
 */
public class MainActivity extends Activity {

    private Button mSendButton;
    private EditText mSendText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSendButton = (Button) findViewById(R.id.send_button);
        mSendText = (EditText) findViewById(R.id.send_text);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(reverseString(mSendText.getText().toString()));
            }
        });
    }

    public void send(String message) {
        Intent sendIntent = new Intent(getApplicationContext(), SecondActivity.class);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(sendIntent);
        finish();
    }

    private String reverseString(String string) {
        Stack stack = new Stack();
        for(int i = 0; i < string.length(); i++) {
            stack.push(string.substring(i, i+1));
        }
        String returnString = "";
        for (int i = 0; i < string.length(); i++) {
            returnString+= stack.pop();
        }
        return returnString;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
