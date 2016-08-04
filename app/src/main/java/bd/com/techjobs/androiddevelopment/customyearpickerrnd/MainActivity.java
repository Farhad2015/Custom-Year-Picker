package bd.com.techjobs.androiddevelopment.customyearpickerrnd;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.NumberPicker;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    Button b;
    static Dialog d ;
    //int year = Calendar.getInstance().get(Calendar.YEAR);
    java.util.Calendar c = java.util.Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("yyyy");
    String getyear = df.format(c.getTime());
    int year = Integer.parseInt(getyear);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.year);
        b.setText(""+year);
        b.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                showYearDialog();
            }
        });
    }

    public void showYearDialog()
    {

        final Dialog d = new Dialog(MainActivity.this);
        //d.getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        d.setTitle("Year Picker");
        d.setContentView(R.layout.yeardialog);
        Button set = (Button) d.findViewById(R.id.button1);
        Button cancel = (Button) d.findViewById(R.id.button2);
        final NumberPicker nopicker = (NumberPicker) d.findViewById(R.id.numberPicker1);

        nopicker.setMaxValue(year+50);
        nopicker.setMinValue(year-50);
        nopicker.setWrapSelectorWheel(false);
        nopicker.setValue(year);
        nopicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        set.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                b.setText(String.valueOf(nopicker.getValue()));
                d.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();


    }
}
