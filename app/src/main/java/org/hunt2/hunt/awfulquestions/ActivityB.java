package org.hunt2.hunt.awfulquestions;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Van on 7/28/2016.
 */
public class ActivityB extends Activity {
    Button btn;
    EditText nameInput;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
    }

    public void startGame(View view) {
        String name = parseName();
        if (name.length() <= 0) {
            Toast.makeText(ActivityB.this, "Please enter your name.", Toast.LENGTH_LONG).show();
        }
        else {
            Intent startIntent = new Intent(view.getContext(), ActivityC.class);
            startIntent.putExtra("name", name);
            startActivity(startIntent);
        }
    }

    public String parseName() {
        nameInput = (EditText) findViewById(R.id.nameInput);
        name = nameInput.getText().toString().trim();
        return name;
    }
}
