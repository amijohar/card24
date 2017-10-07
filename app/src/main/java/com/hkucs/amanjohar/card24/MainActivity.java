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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = new ImageButton[4];
        cards[0] = (ImageButton) findViewById(R.id.card1);
        cards[1] = (ImageButton) findViewById(R.id.card2);
        cards[2] = (ImageButton) findViewById(R.id.card3);
        cards[3] = (ImageButton) findViewById(R.id.card4);
        rePick = (Button)findViewById(R.id.repick);
        checkInput = (Button)findViewById(R.id.checkinput);
        left = (Button)findViewById(R.id.left);
        right = (Button)findViewById(R.id.right);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.divide);
        clear = (Button)findViewById(R.id.clear);
        expression = (TextView)findViewById(R.id.input);
        expression1=expression.getText().toString();
        Intent intent = getIntent();
        String message = intent.getStringExtra(Main2Activity.EXTRA_MESSAGE);
        finalValue=Integer.parseInt(message);
        expression.setHint("Please form an expression such that the result is "+message);
        initCardImage();
        pickCard();

        cards[0].setOnClickListener(new ImageButton.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()==0 || expression1.charAt(expression1.length()-1)=='(' || expression1.charAt(expression1.length()-1)=='+' || expression1.charAt(expression1.length()-1)=='-' || expression1.charAt(expression1.length()-1)=='*' || expression1.charAt(expression1.length()-1)=='/')
                    clickCard(0);
                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        cards[1].setOnClickListener(new ImageButton.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()==0 || expression1.charAt(expression1.length()-1)=='(' || expression1.charAt(expression1.length()-1)=='+' || expression1.charAt(expression1.length()-1)=='-' || expression1.charAt(expression1.length()-1)=='*' || expression1.charAt(expression1.length()-1)=='/')
                    clickCard(1);
                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        cards[2].setOnClickListener(new ImageButton.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()==0 || expression1.charAt(expression1.length()-1)=='(' || expression1.charAt(expression1.length()-1)=='+' || expression1.charAt(expression1.length()-1)=='-' || expression1.charAt(expression1.length()-1)=='*' || expression1.charAt(expression1.length()-1)=='/')
                    clickCard(2);
                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        cards[3].setOnClickListener(new ImageButton.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()==0 || expression1.charAt(expression1.length()-1)=='(' || expression1.charAt(expression1.length()-1)=='+' || expression1.charAt(expression1.length()-1)=='-' || expression1.charAt(expression1.length()-1)=='*' || expression1.charAt(expression1.length()-1)=='/')
                    clickCard(3);
                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        left.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()==0 || expression1.charAt(expression1.length()-1)=='(' || expression1.charAt(expression1.length()-1)=='+' || expression1.charAt(expression1.length()-1)=='-' || expression1.charAt(expression1.length()-1)=='*' || expression1.charAt(expression1.length()-1)=='/'){
                    expression1+=("(");
                    expression.append("(");
                }

                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        right.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()!=0){
                    if(expression1.charAt(expression1.length()-1)==')' || Character.isDigit(expression1.charAt(expression1.length()-1))){
                        expression.append(")");
                        expression1+=(")");
                    }
                    else
                        Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        plus.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()!=0){
                    if(expression1.charAt(expression1.length()-1)==')' || Character.isDigit(expression1.charAt(expression1.length() - 1))) {
                        expression1 += ("+");
                        expression.append("+");
                    }
                    else
                        Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        minus.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()!=0){
                    if(expression1.charAt(expression1.length()-1)==')' || Character.isDigit(expression1.charAt(expression1.length()-1))){
                        expression1+=("-");
                        expression.append("-");
                    }
                    else
                        Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        multiply.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()!=0){
                    if(expression1.charAt(expression1.length()-1)==')' || Character.isDigit(expression1.charAt(expression1.length()-1))){
                        expression1+=("*");
                        expression.append("*");
                    }
                    else
                        Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        divide.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                if(expression1.length()!=0){
                    if(expression1.charAt(expression1.length()-1)==')' || Character.isDigit(expression1.charAt(expression1.length()-1))){
                        expression1+=("/");
                        expression.append("/");
                    }
                    else
                        Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
                }

                else
                    Toast.makeText(MainActivity.this, "Non-Sense Input", Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                setClear();
            }
        });

        checkInput.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                String inputStr = expression.getText().toString();
                if (checkInput(inputStr)==0)
                {
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                    pickCard();

                }
                else if(checkInput(inputStr)==1)
                {
                    Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    setClear();

                }
                else
                    Toast.makeText(MainActivity.this, "You need to use all cards", Toast.LENGTH_SHORT).show();


            }
        });

        rePick.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View View)
            {
                pickCard();
            }
        });





    }
    ImageButton[] cards;
    Button rePick;
    Button checkInput;
    Button clear;
    Button left;
    Button right;
    Button plus;
    Button minus;
    Button multiply;
    Button divide;
    TextView expression;
    String expression1;
    int finalValue;
    int[] imageCount = new int[10];
    private void initCardImage() {
        for (int i = 0; i < 4; i++) {
            int resID = getResources().getIdentifier("back_0","drawable","com.hkucs.amanjohar.card24");
                    cards[i].setImageResource(resID);
        }
    }
    int[] data;
    int[] card;
    private void pickCard(){
        Random rand=new Random();
        int a= rand.nextInt(52)+1;
        int b= rand.nextInt(52)+1;
        int c= rand.nextInt(52)+1;
        int d= rand.nextInt(52)+1;
        data = new int[4];
        card =new int[4];
        card[0]=a;
        card[1]=b;
        card[2]=c;
        card[3]=d;
        data[0]=a%13;
        data[1]=b%13;
        data[2]=c%13;
        data[3]=d%13;
        for(int i=0;i<4;i++)
        {
            if(data[i]==0)
                data[i]=13;
        }
        setClear();

    }

    private void setClear()
    {
        int resID;

        expression.setText("");
        expression1="";
        for(int i=0;i<4;i++)
        {
            imageCount[i]=0;
            resID=getResources().getIdentifier("card"+card[i],"drawable","com.hkucs.amanjohar.card24");
            cards[i].setImageResource(resID);
            cards[i].setClickable(true);

        }
    }

    private void clickCard(int i)
    {   int resId;
        String num;
        Integer value;
        if (imageCount[i] == 0) {
            resId = getResources().getIdentifier("back_0","drawable","com.hkucs.amanjohar.card24");
            cards[i].setImageResource(resId);
            cards[i].setClickable(false);
            value = data[i];
            num = value.toString();
            expression.append(num);
            expression1+=num;
            imageCount[i] ++;
        }
    }

    private int checkInput(String input) { Jep jep = new Jep();
        boolean checkAll=true;
        for(int i=0;i<4;i++){
            if(imageCount[i]==0){
                checkAll=false;
            }
        }
        if(!checkAll)
            return 2;
        Object res;
        try
        {
            jep.parse(input);
            res = jep.evaluate();
        }

        catch (ParseException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Wrong Expression", Toast.LENGTH_SHORT).show();
            return 1;
        }

        catch (EvaluationException e)
        { e.printStackTrace();
            Toast.makeText(MainActivity.this, "Wrong Expression", Toast.LENGTH_SHORT).show();
            return 1;
        }

        Double ca = (Double)res;
        if (Math.abs(ca - finalValue) < 1e-6)
            return 0;

        return 1;
    }






}
