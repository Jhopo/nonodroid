package net.jhopo.nonodroid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView header;
    private ListView ListView;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayAdapter<String> ListAdapter;
    private Button add_button;
    private JSONArray jsonAnime = new JSONArray();
    private SharedPreferences AnimeData;
    private SharedPreferences Name_epic;

    static final int ADD_REQUEST = 0;
    static final int DELETE_REQUEST = 1;
    static final int INFO_REQUEST = 2;

    static final int DEFAULT_EPISODES = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        ListView = (ListView)findViewById(R.id.ListView);
        ListAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);
        ListView.setAdapter(ListAdapter);

        // AnimeData = getSharedPreferences("AnimeData",MODE_PRIVATE);
        // AnimeData.getString("JSON", "");
        Assign assign = new Assign();
        Name_epic = getSharedPreferences("Name_epic", MODE_PRIVATE);
        assign.work(Name_epic);

        loadData();
        updateListView();
        ListAdapter.notifyDataSetChanged();
        updateAnimeNum();


        // processViews();
        processControllers();



        add_button = (Button)findViewById(R.id.add_item);
        add_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddAnimeActivity.class);
                startActivityForResult(intent, ADD_REQUEST);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        int i;
        if (resultCode == Activity.RESULT_OK) {

            switch(requestCode) {

                case ADD_REQUEST:
                    String titleText = data.getStringExtra("titleText");
                    JSONObject jsonObjAnime = new JSONObject();
                    JSONArray jsonArrayEpisode = new JSONArray();


                    if( !titleText.isEmpty() ){

                        try {
                            jsonObjAnime.put("name", titleText);
                            jsonObjAnime.put("updatetime", 0);

                            for(i=0; i<DEFAULT_EPISODES; ++i){
                                jsonArrayEpisode.put("");
                            }
                            jsonObjAnime.put("episode", jsonArrayEpisode);

                            // Todo <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                        } catch (JSONException e) { e.printStackTrace(); }

                        jsonAnime.put(jsonObjAnime);
                    }


                    saveData();
                    updateListView();
                    ListAdapter.notifyDataSetChanged();
                    updateAnimeNum();
                    break;

                case DELETE_REQUEST:
                    int index = data.getIntExtra("index",-1);

                    if(index != -1) {

                        jsonAnime.remove(index);

                        // String string = Integer.toString(jsonAnime.length());
                        // Toast.makeText(MainActivity.this,string, Toast.LENGTH_LONG).show();

                        saveData();
                        updateListView();
                        ListAdapter.notifyDataSetChanged();
                        updateAnimeNum();
                    }
                    break;

                case INFO_REQUEST:
                    loadData();
                    updateListView();
                    ListAdapter.notifyDataSetChanged();
                    break;

                default:
                    break;
            }
        }
    }

    private void processControllers() {
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(MainActivity.this, AnimeInfoActivity.class);
                intent.putExtra("index",position);
                startActivityForResult(intent, INFO_REQUEST);

            }
        };

        ListView.setOnItemClickListener(itemListener);


        AdapterView.OnItemLongClickListener itemLongListener = new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {

                Intent intent = new Intent(MainActivity.this, deleteAnime.class);
                intent.putExtra("index",position);
                startActivityForResult(intent, DELETE_REQUEST);
                return true;
            }
        };

        ListView.setOnItemLongClickListener(itemLongListener);


    }

    public void loadData(){

        AnimeData = getSharedPreferences("AnimeData",MODE_PRIVATE);
        String tempJSON = AnimeData.getString("JSON","");

        try {
            jsonAnime = new JSONArray(tempJSON);
        }
        catch(JSONException e) { e.printStackTrace();}

    }

    public void saveData(){
        AnimeData = getSharedPreferences("AnimeData",MODE_PRIVATE);
        AnimeData.edit()
                .putString("JSON", jsonAnime.toString())
                .apply();
    }

    public void updateListView(){

        this.list.clear();
        int i;
        for(i=0; i<jsonAnime.length(); ++i){
            JSONObject tempJSON;
            String tempname = "";
            try {
                tempJSON = jsonAnime.getJSONObject(i);
                tempname = tempJSON.getString("name");
            }
            catch(JSONException e) { e.printStackTrace();}

            if( !tempname.isEmpty() ){
                this.list.add(tempname);
            }

        }
    }

    public void updateAnimeNum(){

        header = (TextView)findViewById(R.id.textView2);
        String anime_num = Integer.toString(jsonAnime.length());
        String head = "所有收藏 (" + anime_num + ")";
        header.setText(head);
    }
}
