package e.administrator.counter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private EditText etInOut=null,etShowInfo=null;
    private Button bt0=null,
    bt1=null,
    bt2=null,
    bt3=null,
    bt4=null,
    bt5=null,
    bt6=null,
    bt7=null,
    bt8=null,
    bt9=null,
    btC=null,
    btequal=null,
    btplus=null,
    btsub=null,
    btdiv=null,
    btnper=null,
    btmul=null,
    btdel=null;


    private int x=0,y=0,result=0,k=1;
    private int sign=0;

    private String operator="",j="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click();
        String i=Integer.toString(x);
        etInOut.setText(i);
       bt1.setOnClickListener(new OnClickListener()  {
           @Override
           public void onClick(View view) {
               settext(1);
           }
       });
        bt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                settext(2);
            }
        });
        bt3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(3);
            }
        });
        bt4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(4);
            }
        });
        bt5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(5);
            }
        });
        bt6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(6);
            }
        });
        bt7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(7);
            }
        });
        bt8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(8);
            }
        });
        bt9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(9);
            }
        });
        bt0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                settext(0);
            }
        });
        btplus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setoperator("+");
            }
        });
        btequal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                equal();
            }
        });
        btsub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setoperator("-");
            }
        });
        btmul.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                setoperator("*");
            }
        });
        btdiv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setoperator("/");
            }
        });
        btnper.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setoperator("%");
            }
        });
        btC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clean();
            }
        });
        btdel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });
    }
        private void click(){
            etShowInfo=(EditText) findViewById(R.id.edit2);
            etInOut=(EditText) findViewById(R.id.edit1);
            bt1=(Button) findViewById(R.id.button1);
            bt2=(Button)findViewById(R.id.button2);
            bt3=(Button)findViewById(R.id.button3);
            bt4=(Button)findViewById(R.id.button4);
            bt5=(Button)findViewById(R.id.button5);
            bt6=(Button)findViewById(R.id.button6);
            bt7=(Button)findViewById(R.id.button7);
            bt8=(Button)findViewById(R.id.button8);
            bt9=(Button)findViewById(R.id.button9);
            bt0=(Button)findViewById(R.id.button0);
            btplus=(Button)findViewById(R.id.buttonplus);
            btequal=(Button)findViewById(R.id.buttonequal);
            btC=(Button)findViewById(R.id.buttonC);
            btsub=(Button)findViewById(R.id.buttondec);
            btmul=(Button)findViewById(R.id.buttonmultiple);
            btdiv=(Button)findViewById(R.id.buttondiv);
            btnper=(Button)findViewById(R.id.buttonper);
            btdel=(Button) findViewById(R.id.buttondel);
        }
    private void settext(int input) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("警告：");
        builder.setMessage("你输入的值过大！");
            String i=Integer.toString(input);
            MyDialogFragment dialog = new MyDialogFragment();
            if(sign==0 || sign==1){
                j=j+i;
                etInOut.setText(j);
                etInOut.setSelection(etInOut.getText().length());
                sign=1;
                try {
                    x = Integer.valueOf(j);
                }catch (Exception e){
                    sign=-1;
                    builder.show();
                }

            }else if(sign==2){
                j=j+i;
                etInOut.setText(j);
                etInOut.setSelection(etInOut.getText().length());
                try {
                    y = Integer.valueOf(j);
                }catch (Exception e){
                    sign=-1;
                    builder.show();
                }
            }else if(sign==-1){
                return;
            }
    }
    private void delete(){
            if(sign==1||sign==-1) {
                if(j.length()<2){
                    etInOut.setText("0");
                    etInOut.setSelection(etInOut.getText().length());
                    j="";
                    x=0;
                    return;
                }
                j = j.substring(0, j.length() - 1);
                etInOut.setText(j);
                etInOut.setSelection(etInOut.getText().length());
                x = Integer.valueOf(j);
            }else if(sign==2){
                if(j.length()<2){
                    etInOut.setText("0");
                    etInOut.setSelection(etInOut.getText().length());
                    j="";
                    y=0;
                    return;
                }
                j = j.substring(0,j.length()-1);
                etInOut.setText(j);
                etInOut.setSelection(etInOut.getText().length());
                y = Integer.valueOf(j);
            }

    }
    private  void setoperator(String op){
        if(sign==1||sign==0||sign==-1){
            operator=op;
            etShowInfo.setText(etInOut.getText()+op);
            etInOut.setText("");
            sign=2;
            j="";
        }
    }
    private void equal(){
        if(operator.equals("+")&&sign==2){
            result=x+y;
            etShowInfo.setText(x+operator+y);
            etInOut.setText(""+result);
            etInOut.setSelection(etInOut.getText().length());
            sign=0;
            operator="";
            x=result;
        }else if(operator.equals("-")&&sign==2){
            result=x-y;
            etShowInfo.setText(x+operator+y);
            etInOut.setText(""+result);
            etInOut.setSelection(etInOut.getText().length());
            sign=0;
            operator="";
            x=result;
        }else if(operator.equals("*")&&sign==2){
            result=x*y;
            etShowInfo.setText(x+operator+y);
            etInOut.setText(""+result);
            etInOut.setSelection(etInOut.getText().length());
            sign=0;
            operator="";
            x=result;
        }else if(operator.equals("/")&&sign==2){
//            result=x/y;
            if(y==0){
                etInOut.setText("零不能当除数");
                return;
            }
            double result2 = (double)x/(double)y;
            etShowInfo.setText(x+operator+y);
            etInOut.setText(""+result2);
            etInOut.setSelection(etInOut.getText().length());
            sign=0;
            operator="";
            x=result;
        }else if(operator.equals("%")&&sign==2){
            result=x%y;
            etShowInfo.setText(x+operator+y);
            etInOut.setText(""+result);
            etInOut.setSelection(etInOut.getText().length());
            sign=0;
            operator="";
            x=result;
        }
    }
    private void clean(){
        etInOut.setText("0");
        etInOut.setSelection(etInOut.getText().length());
        etShowInfo.setText("");
        x=0;
        y=0;
        result=0;
        sign=0;
        j="";
    }
}





