package org.hunt2.hunt.awfulquestions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Van on 8/5/2016.
 */
public class ActivityC extends Activity {
    ArrayList<String> questions = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    TextView question;
    ListView answers;
    CustomArrayAdapter customAdapter;
    CustomArrayAdapterBlank blankAdapter;
    Intent intent;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        intent = getIntent();
        String name = intent.getExtras().getString("name");
        names.add(name);

        fillQuestions();
        printQuestion(i);
        fillNames();

        answers = (ListView) findViewById(R.id.answerView);
        customAdapter = new CustomArrayAdapter(names, this);
        answers.setAdapter(customAdapter);
    }

    public void fillQuestions() {
        questions.add("Who's the hottest?");
        questions.add("Who's the sluttiest?");
        questions.add("Who was the last to lose their virginity?");
        questions.add("Who has the hottest significant other?");
        questions.add("Who are you most jealous of?");
        questions.add("Who has the nicest house?");
        questions.add("Who's the best dressed?");
        questions.add("Who's the laziest?");
        questions.add("Who's most likely to have sex for money?");
        questions.add("Who has the most money?");
        Collections.shuffle(questions);
    }

    public void printQuestion(int j) {
        question = (TextView) findViewById(R.id.questionView);
        if (j < questions.size()) {
            question.setText(questions.get(j));
            // probably need to reset the adapter to non-blank if we're coming back from blank state
        }
        else {
            question.setText("OH NO! We've run out of questions. Time for you to submit your own!");
            answers.setAdapter(blankAdapter);
        }
    }

    public void fillNames() {
        names.add("Amanda");
        names.add("Byron");
        names.add("Chris");
        names.add("Darryl");
    }

    public void showResultDialog(final Context context, int position, Button nameButton) {
        final int pos = position;
        final String nameSelected = names.get(pos);
        final Button newNameButton = nameButton;

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_dialog);

        // set the text of text field
        TextView text = (TextView) dialog.findViewById(R.id.result);
        text.setText(nameSelected);

        Button okButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                printQuestion(++i);
                newNameButton.setSelected(false);
            }
        });
        dialog.show();
    }
}

