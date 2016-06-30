package net.jhopo.nonodroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddAnimeActivity extends AppCompatActivity {

    private EditText title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_anime);

        processViews();
    }

    private void processViews() {

        title_text = (EditText) findViewById(R.id.title_text);
    }

    public void onSubmit(View view) {

        if (view.getId() == R.id.ok_item) {

            String titleText = title_text.getText().toString();
            Intent result = getIntent();
            result.putExtra("titleText", titleText);
            setResult(Activity.RESULT_OK, result);
        }

        finish();
    }

}
