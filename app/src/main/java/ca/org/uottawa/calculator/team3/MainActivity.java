package ca.org.uottawa.calculator.team3;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    public void onClickNumericalButton(View view) {
        int pressId = view.getId();

        TextView curText = (TextView)findViewById(R.id.resultEdit);

        switch (pressId) {
            case R.id.btn00:
                curText.setText(curText.getText() + "0");
                break;

            case R.id.btn01:
                curText.setText(curText.getText() + "1");
                break;

            case R.id.btn02:
                curText.setText(curText.getText() + "2");
                break;

            case R.id.btn03:
                curText.setText(curText.getText() + "3");
                break;

            case R.id.btn04:
                curText.setText(curText.getText() + "4");
                break;

            case R.id.btn05:
                curText.setText(curText.getText() + "5");
                break;

            case R.id.btn06:
                curText.setText(curText.getText() + "6");
                break;

            case R.id.btn07:
                curText.setText(curText.getText() + "7");
                break;

            case R.id.btn08:
                curText.setText(curText.getText() + "8");
                break;

            case R.id.btn09:
                curText.setText(curText.getText() + "9");
                break;

            case R.id.btnDot:
                curText.setText(curText.getText() + ".");
                break;
            default:
                curText.setText("ERROR");
                Log.w("Error", "Error: Unkown Button Pressed!");
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
                if (data2 == 0) { // if dividing by zero, set result to NaN
                    result = Double.NaN;
                } else {
                    result = data1 / data2;
                }
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