package com.sundargmail.akshara.scarnesdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.os.Handler;



import java.util.Random;



public class MainActivity extends AppCompatActivity {
    public int userTurnScore = 0;
    public int computerOverallScore = 0;
    public int computerTurnScore=0;
    public int userOverallScore = 0;
    Handler handler=new Handler();

    public boolean done = false;
    ImageView dice;
    Button roll;
    Button hold;
    Button reset;
    TextView user;
    TextView computer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dice = (ImageView)findViewById(R.id.imageView) ;
        dice.setImageResource(R.drawable.dice3);
        roll = (Button)findViewById(R.id.ROLL);
        hold = (Button)findViewById(R.id.HOLD);
        reset = (Button)findViewById(R.id.RESET);
        user = (TextView)findViewById(R.id.userscore);
        computer = (TextView)findViewById(R.id.computerscore);
        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                userOverallScore = 0;
                userTurnScore = 0;
                computerOverallScore = 0;
                computerTurnScore = 0;
                user.setText("Your score: "+userOverallScore);
                computer.setText("  Computer score: "+ computerOverallScore);
            }
        });
        roll.setOnClickListener(new View.OnClickListener()
        {
            int rollValue;
            @Override
            public void onClick(View v) {

                    rollValue = changeDice();
                    if(rollValue == 1)
                    {
                        userTurnScore = 0;

                        setComputerTurn();

                    }
                    hold.setOnClickListener(new View.OnClickListener(){


                        @Override
                        public void onClick(View v) {

                            userOverallScore += userTurnScore;
                            user.setText("Your score: "+userOverallScore);
                            userTurnScore = 0;
                            setComputerTurn();
                            /*if(userOverallScore>100)
                            {
                                user.setText("YOU WIN!");
                                computer.setText("");
                            }
                            else if(computerOverallScore>100)
                            {
                                computer.setText("You lose. :(");
                                user.setText("");
                            }*/
                        }

                        }


                    );

            }
        });
    }

    public int changeDice()
    {
        Random rand= new Random();
        int  n = rand.nextInt(6) + 1;

        switch(n)
        {
            case 1: dice.setImageResource(R.drawable.dice1);
                userTurnScore = 0;
                return 1;

            case 2:dice.setImageResource(R.drawable.dice2);

                userTurnScore +=2;
                return 2;

            case 3:dice.setImageResource(R.drawable.dice3);
                userTurnScore +=3;
                return 3;


            case 4: dice.setImageResource(R.drawable.dice4);
                userTurnScore +=4;
                return 4;

            case 5:dice.setImageResource(R.drawable.dice5);
                userTurnScore +=5;
                return 5;

            case 6:dice.setImageResource(R.drawable.dice6);
                userTurnScore +=6;
                return 6;

        }
        //userTurnScore += 4;
        return 0;
    }

    public void setComputerTurn()
    {
        roll.setEnabled(false);
        hold.setEnabled(false);
        int rollValue = 0;
        if(rollValue == 1)
        {
            computerTurnScore = 0;
            // computer.setText("  Computer score: " + computerOverallScore);
        }
        else if(computerTurnScore<20)
        {

            rollValue = changeDiceComp();
            if(rollValue!=1)
            {handler.postDelayed(new Runnable(){
                @Override
                public void run()
                {
                        setComputerTurn();
                }
            },500);}
            else
            {
                computerOverallScore += computerTurnScore;
                computer.setText("  Computer score: " + computerOverallScore);
                computerTurnScore = 0;
                roll.setEnabled(true);
                hold.setEnabled(true);
            }
        }
        else
        {

            computerOverallScore += computerTurnScore;
            computer.setText("  Computer score: " + computerOverallScore);
            computerTurnScore = 0;
            roll.setEnabled(true);
            hold.setEnabled(true);
        }




    }
/*public void setComputerTurn()
    {
        roll.setEnabled(false);
        hold.setEnabled(false);
        int rollValue = 0;
        while(rollValue != 1 && computerTurnScore<20)
        {
            rollValue = changeDiceComp();

        }
        if(rollValue == 1)
        {
            computerTurnScore = 0;
           // computer.setText("  Computer score: " + computerOverallScore);
        }
        computerOverallScore += computerTurnScore;
        computer.setText("  Computer score: " + computerOverallScore);
        roll.setEnabled(true);
        hold.setEnabled(true);
        computerTurnScore = 0;
    }
*/
    public int changeDiceComp()
    {
        Random rand= new Random();
        int  n = rand.nextInt(6) + 1;

        switch(n)
        {
            case 1: dice.setImageResource(R.drawable.dice1);
                computerTurnScore = 0;
                return 1;

            case 2:dice.setImageResource(R.drawable.dice2);

                computerTurnScore +=2;
                return 2;

            case 3:dice.setImageResource(R.drawable.dice3);
                computerTurnScore +=3;
                return 3;


            case 4: dice.setImageResource(R.drawable.dice4);
                computerTurnScore +=4;
                return 4;

            case 5:dice.setImageResource(R.drawable.dice5);
                computerTurnScore +=5;
                return 5;

            case 6:dice.setImageResource(R.drawable.dice6);
                computerTurnScore +=6;
                return 6;

        }
        //userTurnScore += 4;
        return 0;
    }
}
