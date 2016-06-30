package net.jhopo.nonodroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class deleteAnime extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_delete_anime);
    }

    public void onSubmit(View view) {

        if (view.getId() == R.id.ok_delete) {

            Intent result = getIntent();
            setResult(Activity.RESULT_OK, result);
        }

        finish();
    }
}
