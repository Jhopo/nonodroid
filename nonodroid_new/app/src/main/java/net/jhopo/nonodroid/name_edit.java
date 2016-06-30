package net.jhopo.nonodroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class name_edit extends Activity {

    private EditText title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_name_edit);

        processViews();
    }

    private void processViews() {

        title_text = (EditText) findViewById(R.id.edit_name_text);
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
