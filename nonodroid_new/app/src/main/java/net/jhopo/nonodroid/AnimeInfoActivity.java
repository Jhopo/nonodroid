package net.jhopo.nonodroid;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Switch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AnimeInfoActivity extends AppCompatActivity {

    private int index;
    private int finished = 0;
    private Button name_button;
    private Button update_button;
    private Switch update_switch;
    private Button add_button;
    private Button eli_button;
    private Button renew_button;

    private JSONArray jsonAnime = new JSONArray();
    private SharedPreferences AnimeData;
    private SharedPreferences Name_epic;

    private ListView ListView;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> ListAdapter;

    static final int EDIT_NAME_REQUEST = 0;
    static final int EDIT_TIME_REQUEST = 1;
    static final int EDIT_EPISODE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_info);

        Intent result = getIntent();
        index = result.getIntExtra("index",-1);

        name_button = (Button)findViewById(R.id.button_name);
        update_button = (Button)findViewById(R.id.button_update);
        update_switch = (Switch)findViewById(R.id.switch1);
        update_switch.setChecked(false);
        add_button = (Button)findViewById(R.id.add_name);
        eli_button = (Button)findViewById(R.id.eli_name);
        renew_button = (Button) findViewById(R.id.renew);

        ListView = (ListView)findViewById(R.id.listView);
        ListAdapter = new ArrayAdapter(AnimeInfoActivity.this,android.R.layout.simple_list_item_1,list);
        ListView.setAdapter(ListAdapter);

        final int notifyID = index;
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        final NotificationManager Manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        loadData();
        updatename(index);
        updatetime(index);
        setButton();
        updateListView();

        updateListView();
        ListAdapter.notifyDataSetChanged();

        processControllers();







        name_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(AnimeInfoActivity.this, name_edit.class);
                startActivityForResult(intent, EDIT_NAME_REQUEST);

            }
        });

        update_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(AnimeInfoActivity.this, updatetime_edit.class);
                startActivityForResult(intent, EDIT_TIME_REQUEST);

            }
        });

        renew_button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                loadData();
                updatename(index);
                updatetime(index);
                setButton();
                updateListView();
            }
        });

        add_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                try {
                    JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
                    JSONArray tempJSONAr = jsonObjAnime.getJSONArray("episode");
                    tempJSONAr.put("");
                    jsonObjAnime.put("episode",tempJSONAr);
                    jsonAnime.put(index,jsonObjAnime);
                }
                catch(JSONException e) { e.printStackTrace();}

                saveData();
                updateListView();
                ListAdapter.notifyDataSetChanged();
            }
        });

        eli_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                try {
                    JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
                    JSONArray tempJSONAr = jsonObjAnime.getJSONArray("episode");
                    tempJSONAr.remove(tempJSONAr.length() - 1);
                    jsonObjAnime.put("episode",tempJSONAr);
                    jsonAnime.put(index,jsonObjAnime);
                }
                catch(JSONException e) { e.printStackTrace();}

                saveData();
                updateListView();
                ListAdapter.notifyDataSetChanged();

            }
        });

        update_switch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {

                    JSONObject tempJSON;
                    String tempname = "";
                    try {
                        tempJSON = jsonAnime.getJSONObject(index);
                        tempname = tempJSON.getString("name");
                    }
                    catch(JSONException e) { e.printStackTrace();}

                    Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
                    builder.setSmallIcon(R.drawable.ic_launcher)
                            .setLargeIcon(bm)
                            .setWhen(System.currentTimeMillis())
                            .setContentTitle("Anicolle")
                            .setContentText(tempname + " 今天更新!");

                    builder.setDefaults(0);
                    Notification notification = builder.build();
                    Manager.notify(index, notification);

                } else {

                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == Activity.RESULT_OK) {

            switch(requestCode) {

                case EDIT_NAME_REQUEST:

                    String titleText = data.getStringExtra("titleText");

                    if(!titleText.isEmpty()){

                        try {
                            JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
                            jsonObjAnime.put("name", titleText);
                            jsonAnime.put(index,jsonObjAnime);
                        }
                        catch(JSONException e) { e.printStackTrace();}
                    }

                    saveData();
                    updatename(index);

                    break;

                case EDIT_TIME_REQUEST:

                    int upday = data.getIntExtra("update_time",0);

                    if(upday != 0) {
                        try {
                            JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
                            jsonObjAnime.put("updatetime", upday);
                            jsonAnime.put(index, jsonObjAnime);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    saveData();
                    updatetime(index);

                    break;

                case EDIT_EPISODE_REQUEST:

                    String epiText = data.getStringExtra("titleText");
                    int epi_index = data.getIntExtra("index",-1);

                    if(epi_index != -1){

                        try {
                            JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
                            JSONArray tempJSONAr = jsonObjAnime.getJSONArray("episode");
                            tempJSONAr.put(epi_index,epiText);
                            jsonObjAnime.put("episode",tempJSONAr);
                            jsonAnime.put(index,jsonObjAnime);
                        }
                        catch(JSONException e) { e.printStackTrace();}
                    }

                    saveData();
                    updateListView();
                    ListAdapter.notifyDataSetChanged();


            }
        }
    }

    private void processControllers() {
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(AnimeInfoActivity.this, ep_edit.class);
                intent.putExtra("index",position);

                try {
                    JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
                    JSONArray tempJSONAr = jsonObjAnime.getJSONArray("episode");
                    String origin = tempJSONAr.getString(position);
                    intent.putExtra("origin",origin);
                }
                catch(JSONException e) { e.printStackTrace();}


                startActivityForResult(intent, EDIT_EPISODE_REQUEST);

            }
        };

        ListView.setOnItemClickListener(itemListener);


    }

    public void loadData(){

        AnimeData = getSharedPreferences("AnimeData",MODE_PRIVATE);
        String tempJSON = AnimeData.getString("JSON", "");
        JSONObject tempJSON2;
        String AnimeName = "";
        JSONArray tempJSONAr;
        try {
            jsonAnime = new JSONArray(tempJSON);
            JSONObject jsonObjAnime = jsonAnime.getJSONObject(index);
            tempJSONAr = jsonObjAnime.getJSONArray("episode");
            tempJSON2 = jsonAnime.getJSONObject(index);
            AnimeName = tempJSON2.getString("name");
            Name_epic = getSharedPreferences("Name_epic", MODE_PRIVATE);
            int epic_num = Name_epic.getInt(AnimeName, 0);
            if(epic_num != 0) finished=1;
            if(epic_num == 0) finished=0;
            if(epic_num != 0 && epic_num != tempJSONAr.length()) {
                tempJSONAr = new JSONArray(new ArrayList<String>());
                for(int i=0; i < epic_num; i++) {
                    tempJSONAr.put("");
                }
                jsonObjAnime.put("episode",tempJSONAr);
            }
        }
        catch(JSONException e) { e.printStackTrace();}

    }

    public void saveData(){
        AnimeData = getSharedPreferences("AnimeData",MODE_PRIVATE);
        AnimeData.edit()
                .putString("JSON", jsonAnime.toString())
                .apply();
    }

    public void updatename(int index){

        JSONObject tempJSON;
        String tempname = "";
        try {
            tempJSON = jsonAnime.getJSONObject(index);
            tempname = tempJSON.getString("name");
        }
        catch(JSONException e) { e.printStackTrace();}

        if( !tempname.isEmpty() ){
            name_button.setText(tempname);
        }

    }

    public void updatetime(int index){

        JSONObject tempJSON;
        int days = 0;
        String str_day;
        try {
            tempJSON = jsonAnime.getJSONObject(index);
            days = tempJSON.getInt("updatetime");
        }
        catch(JSONException e) { e.printStackTrace();}
        if(finished == 1) days=8;

        switch(days){

            case 1:
                str_day = getResources().getString(R.string.mon_update);
                break;
            case 2:
                str_day = getResources().getString(R.string.tue_update);
                break;
            case 3:
                str_day = getResources().getString(R.string.wed_update);
                break;
            case 4:
                str_day = getResources().getString(R.string.thu_update);
                break;
            case 5:
                str_day = getResources().getString(R.string.fri_update);
                break;
            case 6:
                str_day = getResources().getString(R.string.sat_update);
                break;
            case 7:
                str_day = getResources().getString(R.string.sun_update);
                break;
            case 8:
                str_day = getResources().getString(R.string.fin_update);
                break;
            case 0:
            default:
                str_day = getResources().getString(R.string.default_update);
                break;
        }
        String result = "更新時間   :   " + str_day;
        update_button.setText(result);

    }

    public void setButton() {
        update_switch.setEnabled(true);
        update_button.setEnabled(true);
        add_button.setEnabled(true);
        eli_button.setEnabled(true);
        if (finished == 1) {
            update_switch.setEnabled(false);
            update_button.setEnabled(false);
            add_button.setEnabled(false);
            eli_button.setEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        saveData();
        Intent result = getIntent();
        setResult(Activity.RESULT_OK, result);
        finish();
    }

    public void updateListView(){

        this.list.clear();
        int i;

        JSONObject tempJSON;
        JSONArray tempJSONAr;

        try {
            tempJSON = jsonAnime.getJSONObject(index);
            tempJSONAr = tempJSON.getJSONArray("episode");

            for(i=0; i<tempJSONAr.length(); ++i){

                String tempmem = "";
                tempmem = tempJSONAr.getString(i);

                String anime_i = Integer.toString(i+1);
                String tempepi = "第 " + anime_i + " 話          " + tempmem;
                this.list.add(tempepi);

            }
        }
        catch(JSONException e) { e.printStackTrace();}

    }

    private int getNotificationIcon() {
        boolean useWhiteIcon = (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP);
        return useWhiteIcon ? R.drawable.ic_launcher : R.drawable.ic_launcher;
    }

}
