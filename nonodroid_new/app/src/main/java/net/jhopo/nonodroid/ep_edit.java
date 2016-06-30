package net.jhopo.nonodroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class ep_edit extends Activity {

    private TextView view_text;
    private EditText title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ep_edit);

        processViews();
    }

    private void processViews() {

        title_text = (EditText) findViewById(R.id.edit_name_text);
        view_text = (TextView) findViewById(R.id.textView);
        Intent result = getIntent();
        int i = result.getIntExtra("index", -1);
        String anime_i = Integer.toString(i + 1);
        String edit_epi_text = "第 " + anime_i + " 話評論";
        view_text.setText(edit_epi_text);

        String origin = result.getStringExtra("origin");
        if(!origin.isEmpty()){

            title_text.setText(origin);
        }
    }

    public void onSubmit(View view) {

        if (view.getId() == R.id.ok_edit_name) {

            String titleText = title_text.getText().toString();
            Intent result = getIntent();
            result.putExtra("titleText", titleText);
            setResult(Activity.RESULT_OK, result);
        }

        finish();
    }
}
