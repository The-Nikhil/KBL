package com.nikhilkanyal.kbl;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button answer1,answer2,answer3,answer4,bt,hint2,c3;
    TextView score,question;
    private boolean x=false;
    private boolean y=false;
    private questions mQuestion = new questions();//java file

    private String mAnswer;
    private int mscore=0;
    private int mQuestionsLength=mQuestion.mQuestions.length;

    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r= new Random();

        answer1=(Button)findViewById(R.id.answer1);
        answer2=(Button)findViewById(R.id.answer2);
        answer3=(Button)findViewById(R.id.answer3);
        answer4=(Button)findViewById(R.id.answer4);
        hint2 = (Button)findViewById(R.id.lifeline2);
        bt =(Button)findViewById(R.id.BT);
        c3=(Button)findViewById(R.id.connect);

        score=(TextView)findViewById(R.id.score);
        question=(TextView)findViewById(R.id.question);

        updateQuestion(r.nextInt(mQuestionsLength));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l=20000;
                if(x==true){ x=false;
                   l=5000;

                }
                if(answer1.getText()==mAnswer)
                { mscore=mscore+l;
                    score.setText("Score: "+mscore);
                    updateQuestion(r.nextInt(mQuestionsLength));

            }else{
                    Toast.makeText(MainActivity.this,
                            "WRONG ANSWER", Toast.LENGTH_LONG).show();
                    gameOver();
                }
            }

        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l=20000;
                if(x==true){ x=false;
                    l=5000;

                }
                if(answer2.getText()==mAnswer)
                { mscore=mscore+l;
                    score.setText("Score: "+mscore);
                    updateQuestion(r.nextInt(mQuestionsLength));

                }else{
                    Toast.makeText(MainActivity.this,
                            "WRONG ANSWER", Toast.LENGTH_LONG).show();
                    gameOver();
                }

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l=20000;
                if(x==true){ x=false;
                    l=5000;

                }
                if(answer3.getText()==mAnswer)
                { mscore=mscore+l;
                    score.setText("Score: "+mscore);
                    updateQuestion(r.nextInt(mQuestionsLength));

                }else{
                    Toast.makeText(MainActivity.this,
                            "WRONG ANSWER", Toast.LENGTH_LONG).show();
                    gameOver();
                }

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int l=20000;
                if(x==true){ x=false;
                    l=5000;

                }
                if(answer4.getText()==mAnswer)
                { mscore=mscore+l;
                    score.setText("Score: "+mscore);
                    updateQuestion(r.nextInt(mQuestionsLength));

                }else{
                    Toast.makeText(MainActivity.this,
                            "WRONG ANSWER", Toast.LENGTH_LONG).show();
                    gameOver();
                }

            }
        });
        hint2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x=true;
                Toast.makeText(MainActivity.this,mAnswer,Toast.LENGTH_LONG).show();
                hint2.setClickable(false);
                hint2.setAlpha(0);

            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= getPackageManager().getLaunchIntentForPackage("com.nikhilkanyal.bt");
                startActivity(i);

            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= getPackageManager().getLaunchIntentForPackage("com.nikhilkanyal.connect3");
                startActivity(i);

            }
        });

    }
    private void updateQuestion(int num){
        question.setText(mQuestion.getQuestion(num));
        answer1.setText(mQuestion.getChoice1(num));
        answer2.setText(mQuestion.getChoice2(num));
        answer3.setText(mQuestion.getChoice3(num));
        answer4.setText(mQuestion.getChoice4(num));

        mAnswer= mQuestion.getCorrectAnswer(num);

    }
    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your Score is"+mscore)
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                    }
                });
        AlertDialog alertDialog =alertDialogBuilder.create();
        alertDialog.show();

    }
}
