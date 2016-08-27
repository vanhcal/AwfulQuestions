package org.hunt2.hunt.awfulquestions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends Activity {
    Button btnNew, btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNewGame();
        joinNewGame();
    }

    public void startNewGame() {
        btnNew = (Button) findViewById(R.id.newGameBtn);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new RetrieveFeedTask(getApplicationContext()).execute(new String [] {"http://104.198.104.150/awfulquestions/index.php/"});
            }
        });
    }

    public void joinNewGame() {
        btnJoin = (Button) findViewById(R.id.joinGameBtn);
        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                //main activity might be the wrong context here -- "ActivityContext"
                final EditText edittext = new EditText(MainActivity.this);
                edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
                alert.setMessage("JOIN ROOM");
                alert.setTitle("Enter your room number:");
                alert.setView(edittext);

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String roomNumber = edittext.getText().toString();
                        Toast.makeText(MainActivity.this, "Entered: " + roomNumber, Toast.LENGTH_LONG).show();

                        try {
                            URL url = new URL("http://104.198.104.150/awfulquestions/index.php/");
                            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                            conn.setReadTimeout(10000);
                            conn.setConnectTimeout(15000);
                            conn.setRequestMethod("POST");
                            conn.setDoInput(true);
                            conn.setDoOutput(true);
                        }
                        catch (Exception e) {

                        }

                        List<Integer> roomNumbers = new ArrayList<>();
                        roomNumbers.add(0);


                        }
                    });
                alert.show();
                }
            });
        }
}
