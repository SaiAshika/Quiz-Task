package com.example.myquiz3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity {
    TextView questionView;
    TextView questionNo;
    Button ans1, ans2, ans3;
    Button submit;
    EditText namevalue;
    Integer choice=0;

    int score = 0;

    private ArrayList<QndA> quearray;

    int currentNo = 0;



    ProgressBar pbr;
    TextView barview;
    String pbr_text;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        quearray = new ArrayList<>();
        questionView = findViewById(R.id.QuestionView);
        questionNo = findViewById(R.id.questionNo);
        ans1 = findViewById(R.id.AnsView1);
        ans2 = findViewById(R.id.AnsView2);
        ans3 = findViewById(R.id.AnsView3);
        pbr = findViewById(R.id.Progressbar);
        namevalue = findViewById(R.id.ValueName);
        barview = findViewById(R.id.progressview);
        questionNo.setText("Total questions 3 " );
        submit = findViewById(R.id.SubmitButton);

        AddQues(quearray);
        showquestions(currentNo);


        ans1.setOnClickListener(v -> choice =1);
        ans2.setOnClickListener(v -> choice=2);
        ans3.setOnClickListener(v -> choice = 3);
        submit.setOnClickListener(v -> {
            if(submit.getText().equals("Submit".trim().toLowerCase()))
            {
                if(choice.equals(1))
                {
                    if(quearray.get(currentNo).GetCorrans().equals(ans1.getText()))
                    {
                        score++;
                    }
                    else
                        {
                            ans1.setBackgroundColor(Color.RED);
                        }
                    }
                    if(choice.equals(2))
                    {
                        if(quearray.get(currentNo).GetCorrans().equals(ans2.getText()))
                        {
                            score++;
                        }
                        else
                        {
                            ans2.setBackgroundColor(Color.RED);
                        }
                    }
                    if(choice.equals(3))
                    {
                        if(quearray.get(currentNo).GetCorrans().equals(ans3.getText()))
                        {
                            score++;
                        }
                        else
                        {
                            ans3.setBackgroundColor(Color.RED);
                        }
                    }

                    submit.setText("Next");

                    if(ans1.getText().equals(quearray.get(currentNo).GetCorrans()))
                    {
                        ans1.setBackgroundColor(Color.GREEN);
                    }
                    if(ans2.getText().equals(quearray.get(currentNo).GetCorrans()))
                    {
                        ans2.setBackgroundColor(Color.GREEN);
                    }
                    if(ans3.equals(quearray.get(currentNo).GetCorrans()))
                    {
                        ans3.setBackgroundColor(Color.GREEN);
                    }

                }
                else
                    {
                    currentNo++;
                    pbr.setProgress(currentNo);
                    barview.setText(currentNo + "/" + pbr.getMax());
                    if(currentNo==3)
                    {
                        OpenActivity();
                    }

                }
                showquestions(currentNo);
                submit.setText("submit");


            });
        OpenActivity();

    }
    public void AddQues(ArrayList<QndA> quearray)
    {
        quearray.add(new QndA("Android is", "a web browser", "an operating System", "a web server", "an operating System"));
        quearray.add(new QndA("which language is mainly used in android?", "Java", "C#", "C ++", "Java"));
        quearray.add(new QndA("Which method is used to handle after clicking a button", "onClick", "onSelect", "onSelect", "onClick"));

    }


    public void showquestions(int index)
    {
        questionView.setText(quearray.get(index).GetQue());
        ans1.setText(quearray.get(index).GetAns1());
        ans2.setText(quearray.get(index).GetAns2());
        ans3.setText(quearray.get(index).GetAns3());

    }
    void OpenActivity()
    {
        Intent intent = new Intent(getApplicationContext(), finalscore.class);
        intent.putExtra("Score", score);
        intent.putExtra("Name", namevalue.toString());

        startActivity(intent);

    }



}