package org.hunt2.hunt.awfulquestions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNewGame();
    }

    // TODO: button is set up but needs to connect to server
    public void startNewGame() {
        btn = (Button) findViewById(R.id.newGameBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(view.getContext(), ActivityB.class);
                startActivity(startIntent);
            }
        });
    }
}
