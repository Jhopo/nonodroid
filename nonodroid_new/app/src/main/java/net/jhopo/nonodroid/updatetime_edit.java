package net.jhopo.nonodroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class updatetime_edit extends Activity {

    private RadioGroup rgroup;
    // private RadioButton default_button;
    private RadioButton mon_button;
    private RadioButton tue_button;
    private RadioButton wed_button;
    private RadioButton thu_button;
    private RadioButton fri_button;
    private RadioButton sat_button;
    private RadioButton sun_button;
    private RadioButton fin_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_updatetime_edit);

        processViews();

    }

    private void processViews() {

        rgroup = (RadioGroup) findViewById(R.id.radioGroup);
        // default_button = (RadioButton) findViewById(R.id.radioButton0);
        mon_button = (RadioButton) findViewById(R.id.radioButton1);
        tue_button = (RadioButton) findViewById(R.id.radioButton2);
        wed_button = (RadioButton) findViewById(R.id.radioButton3);
        thu_button = (RadioButton) findViewById(R.id.radioButton4);
        fri_button = (RadioButton) findViewById(R.id.radioButton5);
        sat_button = (RadioButton) findViewById(R.id.radioButton6);
        sun_button = (RadioButton) findViewById(R.id.radioButton7);
        fin_button = (RadioButton) findViewById(R.id.radioButton8);

        rgroup.setOnCheckedChangeListener(listener);

    }


    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener(){

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId){

            switch (checkedId) {

                case R.id.radioButton1:
                    Intent result1 = getIntent();
                    result1.putExtra("update_time", 1);
                    setResult(Activity.RESULT_OK, result1);
                    finish();
                    break;
                case R.id.radioButton2:
                    Intent result2 = getIntent();
                    result2.putExtra("update_time", 2);
                    setResult(Activity.RESULT_OK, result2);
                    finish();
                    break;
                case R.id.radioButton3:
                    Intent result3 = getIntent();
                    result3.putExtra("update_time", 3);
                    setResult(Activity.RESULT_OK, result3);
                    finish();
                    break;
                case R.id.radioButton4:
                    Intent result4 = getIntent();
                    result4.putExtra("update_time", 4);
                    setResult(Activity.RESULT_OK, result4);
                    finish();
                    break;
                case R.id.radioButton5:
                    Intent result5 = getIntent();
                    result5.putExtra("update_time", 5);
                    setResult(Activity.RESULT_OK, result5);
                    finish();
                    break;
                case R.id.radioButton6:
                    Intent result6 = getIntent();
                    result6.putExtra("update_time", 6);
                    setResult(Activity.RESULT_OK, result6);
                    finish();
                    break;
                case R.id.radioButton7:
                    Intent result7 = getIntent();
                    result7.putExtra("update_time", 7);
                    setResult(Activity.RESULT_OK, result7);
                    finish();
                    break;
                case R.id.radioButton8:
                    Intent result8 = getIntent();
                    result8.putExtra("update_time", 8);
                    setResult(Activity.RESULT_OK, result8);
                    finish();
                    break;
                default:
                    Intent result = getIntent();
                    setResult(Activity.RESULT_OK, result);
                    finish();
                    break;

            }



        }
    };

    public void onSubmit(View view) {

        if (view.getId() == R.id.cancel_edit_update) {

            Intent result = getIntent();
            setResult(Activity.RESULT_OK, result);

        }

        finish();

    }
}
