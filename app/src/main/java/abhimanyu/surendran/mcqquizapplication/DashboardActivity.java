package abhimanyu.surendran.mcqquizapplication;

import static abhimanyu.surendran.mcqquizapplication.MainActivity.list_of_questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timervalue=20;
    ProgressBar progressBar;
    List<QuestionActivity>allQuestionsList;
    QuestionActivity questionActivity;
    int index=0;

    TextView question,optiona,optionb,optionc,optiond;
    CardView cardoA,cardoB,cardoC,cardoD;
    int correctCount=0;
    int wrongCount=0;
    Button next_btn;
    TextView exit;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

        allQuestionsList=list_of_questions;
        Collections.shuffle(allQuestionsList);
        questionActivity=list_of_questions.get(index);

        cardoA.setBackgroundColor(getResources().getColor(R.color.white));
        cardoB.setBackgroundColor(getResources().getColor(R.color.white));
        cardoC.setBackgroundColor(getResources().getColor(R.color.white));
        cardoD.setBackgroundColor(getResources().getColor(R.color.white));

        next_btn.setClickable(false);

        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timervalue=timervalue-1;
                progressBar.setProgress(timervalue);
            }

            @Override
            public void onFinish() {
                Dialog dialog=new Dialog(DashboardActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.try_again_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();

        setAllData();

    }

    private void setAllData() {

        question.setText(questionActivity.getQuestions());
        optiona.setText(questionActivity.getoA());
        optionb.setText(questionActivity.getoB());
        optionc.setText(questionActivity.getOC());
        optiond.setText(questionActivity.getoD());
        timervalue=20;
        countDownTimer.cancel();
        countDownTimer.start();

    }

    private void Hooks() {

        progressBar=findViewById(R.id.quiz_timer);
        question=findViewById(R.id.question);
        optiona=findViewById(R.id.optiona);
        optionb=findViewById(R.id.optionb);
        optionc=findViewById(R.id.optionc);
        optiond=findViewById(R.id.optiond);

        cardoA=findViewById(R.id.cardoptiona);
        cardoB=findViewById(R.id.cardoptionb);
        cardoC=findViewById(R.id.cardoptionc);
        cardoD=findViewById(R.id.cardoptiond);

        next_btn=findViewById(R.id.next_btn);

    }
    public void Correct(CardView cardView){

        cardView.setBackgroundColor(getResources().getColor(R.color.green));

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                questionActivity=list_of_questions.get(index);
                resetColor();
                setAllData();
                enableButton();
            }
        });

    }

    public void Wrong(CardView cardoA){

        cardoA.setBackgroundColor(getResources().getColor(R.color.red));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if (index<list_of_questions.size()-1) {
                    index++;
                    questionActivity=list_of_questions.get(index);
                    resetColor();
                    setAllData();
                    enableButton();
                }else {
                    GameWon();
                }
            }
        });


    }

    private void GameWon() {
        Intent intent = new Intent(DashboardActivity.this,WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }

    public void enableButton(){
        cardoA.setClickable(true);
        cardoB.setClickable(true);
        cardoC.setClickable(true);
        cardoD.setClickable(true);
    }
    public void disableButton(){
        cardoA.setClickable(false);
        cardoB.setClickable(false);
        cardoC.setClickable(false);
        cardoD.setClickable(false);
    }

    public void resetColor(){
        cardoA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardoB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardoC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardoD.setCardBackgroundColor(getResources().getColor(R.color.white));

    }

    public void optionAClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(questionActivity.getoA().equals(questionActivity.getAns()))
        {
            cardoA.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list_of_questions.size()-1){
                Correct(cardoA);

            }
            else {
                GameWon();
            }
        } else {
            Wrong(cardoA);
        }
    }

    public void optionBClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(questionActivity.getoB().equals(questionActivity.getAns()))
        {
            cardoB.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list_of_questions.size()-1){
                Correct(cardoB);

            }
            else {
                GameWon();
            }
        } else {
            Wrong(cardoB);
        }
    }

    public void optionCClick(View view) {
        disableButton();
        next_btn.setClickable(true);
        if(questionActivity.getOC().equals(questionActivity.getAns()))
        {
            cardoC.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list_of_questions.size()-1){
                Correct(cardoC);

            }
            else {
                GameWon();
            }
        } else {
            Wrong(cardoC);
        }
    }

    public void optionDClick(View view) {disableButton();
        disableButton();
        next_btn.setClickable(true);
        if(questionActivity.getoD().equals(questionActivity.getAns()))
        {
            cardoD.setCardBackgroundColor(getResources().getColor(R.color.green));

            if(index<list_of_questions.size()-1){
                Correct(cardoD);
            }
            else {
                GameWon();
            }
        } else {
            Wrong(cardoD);
        }
    }


    public void EXIT(View view) {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void BACK(View view) {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}