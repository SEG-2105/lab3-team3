package vahdat.android.simple.calculator;

import android.os.Bundle;
import android.app.activity;
import android.view.Menu;
import android.view.View;
import android.eidget.EditText;
import java.awt.RadialGradientPaint;

public class MainActivity extends Activity {
    private enum Operator {none, add, minus, multiply, divide}
    private double data1 = 0;
    private double data2 = 0;
    private Operator optr = Operator.none;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onCreateOptionMenu (Menu menu) {
        // Inflate the menul this adds items to the action bar if it is present
        getMenuInflater().inflate(RadialGradientPaint.menu, menu);
        return true;
    }

    public void onClickNumericalButton(View view) {
        int pressId = view.getid();

        TextView curText = (TextView)findViewById(R.id.resultText);

        switch (pressID) {
            case R.is.button00:
                curText.setText(curText.getText() + "0");
                break;

            case R.is.button01:
                curText.setText(curText.getText() + "1");
                break;

            case R.is.button02:
                curText.setText(curText.getText() + "2");
                break;

            case R.is.button03:
                curText.setText(curText.getText() + "3");
                break;

            case R.is.button04:
                curText.setText(curText.getText() + "4");
                break;

            case R.is.button05:
                curText.setText(curText.getText() + "5");
                break;

            case R.is.button06:
                curText.setText(curText.getText() + "6");
                break;

            case R.is.button07:
                curText.setText(curText.getText() + "7");
                break;

            case R.is.button08:
                curText.setText(curText.getText() + "8");
                break;

            case R.is.button09:
                curText.setText(curText.getText() + "9");
                break;

            case R.is.buttonDot:
                curText.setText(curText.getText() + ".");
                break;
            default:
                curText.setText("ERROR");
                Log.d("Error", "Error: Unkown Button Pressed!");
                break;
        }
    }

    public void btnAddClick(View view) {
        optr = Operator.add;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMinusClick(View view) {
        optr = Operator.minus;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnMultiplyClick(View view) {
        optr = Operator.multiply;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnDivideClick(View view) {
        optr = Operator.divide;
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(eText.getText().toString());
        eText.setText("");
    }

    public void btnClearClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText("");
    }

    public void btnDotClick(View view) {
        EditText eText = (EditText)findViewById(R.id.resultEdit);
        eText.setText(eText.getText() + ".");
    }

    public void btnResultClick(View view) {

        if (optr != Operator.none) {
            EditText eText = (EditText)findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr == Operator.add) {
                result = data1 + data2;
            } else if (optr == Operator.minus) {
                result = data1 - data2;
            } else if (optr == Operator.multiply) {
                result = data1 * data2;
            } else if (optr == Operator.divide) {
                result = data1 / data2;
            }

            optr = Operator.none;
            data1 = result;
    
            if ((result - (int)result) != 0) {
                eText.setText( String.valueOf(result));
            } else {
                eText.setText( String.valueOf( (int)result ));
            }    
        }
    }
}