package com.shardulgogate.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int firstOp=1;
    static int decimalUsed=0;
    static int inpEmpty=1;
    static int resEmpty=1;
    static int signEmpty=1;

    public TextView resText;
    public TextView inpText;
    public TextView signText;

    public void evaluate(){
        if(firstOp==1 && inpEmpty==0)
        {
            resText.setText(inpText.getText().toString());
            inpText.setText("");
            inpEmpty=1;
            decimalUsed=0;
            resEmpty=0;
            firstOp=0;
        }
        else if(resEmpty==0 && inpEmpty==0 && signEmpty==0)
        {
            Double eRes=Double.parseDouble(resText.getText().toString());
            Double eInp=Double.parseDouble(inpText.getText().toString());
            char eSign=(signText.getText().toString().charAt(0));
            switch(eSign)
            {
                case '+':resText.setText(Double.toString(eRes + eInp));
                    break;
                case '-':resText.setText(Double.toString(eRes - eInp));
                    break;
                case '*':resText.setText(Double.toString(eRes * eInp));
                    break;
                case '/':resText.setText(Double.toString(eRes / eInp));
                    break;
            }
            inpText.setText("");
            inpEmpty=1;
            resEmpty=0;
            decimalUsed=0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button one=(Button)findViewById(R.id.one);
        one.setOnClickListener(onClickListener);
        Button two=(Button)findViewById(R.id.two);
        two.setOnClickListener(onClickListener);
        Button three=(Button)findViewById(R.id.three);
        three.setOnClickListener(onClickListener);
        Button four=(Button)findViewById(R.id.four);
        four.setOnClickListener(onClickListener);
        Button five=(Button)findViewById(R.id.five);
        five.setOnClickListener(onClickListener);
        Button six=(Button)findViewById(R.id.six);
        six.setOnClickListener(onClickListener);
        Button seven=(Button)findViewById(R.id.seven);
        seven.setOnClickListener(onClickListener);
        Button eight=(Button)findViewById(R.id.eight);
        eight.setOnClickListener(onClickListener);
        Button nine=(Button)findViewById(R.id.nine);
        nine.setOnClickListener(onClickListener);
        Button zero=(Button)findViewById(R.id.zero);
        zero.setOnClickListener(onClickListener);

        Button plus=(Button)findViewById(R.id.plus);
        plus.setOnClickListener(onClickListener);
        Button minus=(Button)findViewById(R.id.minus);
        minus.setOnClickListener(onClickListener);
        Button multiply=(Button)findViewById(R.id.multiply);
        multiply.setOnClickListener(onClickListener);
        Button divide=(Button)findViewById(R.id.divide);
        divide.setOnClickListener(onClickListener);

        Button equals=(Button)findViewById(R.id.equals);
        equals.setOnClickListener(onClickListener);

        Button decimal=(Button)findViewById(R.id.decimal);
        decimal.setOnClickListener(onClickListener);

        Button clear=(Button)findViewById(R.id.clear);
        clear.setOnClickListener(onClickListener);
        Button delete=(Button)findViewById(R.id.delete);
        delete.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener= new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Button pressed=(Button)findViewById(v.getId());

            /*TextView resText=(TextView)findViewById(R.id.resText);
            TextView inpText=(TextView)findViewById(R.id.inpText);
            TextView signText=(TextView)findViewById(R.id.signText);*/

            resText=(TextView)findViewById(R.id.resText);
            inpText=(TextView)findViewById(R.id.inpText);
            signText=(TextView)findViewById(R.id.signText);

            switch(v.getId()) {
                case R.id.one:
                case R.id.two:
                case R.id.three:
                case R.id.four:
                case R.id.five:
                case R.id.six:
                case R.id.seven:
                case R.id.eight:
                case R.id.nine:
                case R.id.zero:
                    inpText.setText(inpText.getText().toString() + pressed.getText().toString());
                    inpEmpty=0;
                    break;
                case R.id.plus:
                case R.id.minus:
                case R.id.divide:
                case R.id.multiply:
                    evaluate();
                    signText.setText(pressed.getText().toString());
                    signEmpty=0;
                    break;
                case R.id.decimal:
                    if(decimalUsed==1) break;
                    inpText.setText(inpText.getText().toString() + pressed.getText().toString());
                    decimalUsed=1;
                    break;
                case R.id.clear:
                    inpText.setText("");
                    resText.setText("");
                    signText.setText("");
                    resEmpty=1;
                    inpEmpty=1;
                    firstOp=1;
                    signEmpty=1;
                    decimalUsed=0;
                    break;
                case R.id.delete:
                    if(inpEmpty==1) break;
                    String oldString=inpText.getText().toString();
                    char oldArray[]=oldString.toCharArray();
                    char newArray[]=new char[oldArray.length-1];
                    for(int i=0;i<oldArray.length-1;i++)
                    {
                        newArray[i]=oldArray[i];
                    }
                    String newString=new String(newArray);
                    if(newString.length()==0) inpEmpty =1;
                    inpText.setText(newString);
                    break;
                case R.id.equals:
                    evaluate();
                    break;
            }
        }
    };
}
