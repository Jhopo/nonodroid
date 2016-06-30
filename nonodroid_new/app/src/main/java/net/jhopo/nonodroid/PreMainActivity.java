package net.jhopo.nonodroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class PreMainActivity extends AppCompatActivity {

    private SharedPreferences username;
    private EditText username_text;
    private TextView status_text;
    private Button login_button;
    private Button enter_button;
    private Button save_button;
    String user_str = "";

    static final int ENTER_REQUEST = 0;

    private static String LOGIN_REQUEST = "bG9naW5fcmVxdWVzdA==";
    private static String SAVE_REQUEST = "c2F2ZV9yZXF1ZXN0";

    private static int LOGIN = 0;
    private static int SAVE = 1;
    private static int request;

    private static String origin_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_main);

        username_text = (EditText) findViewById(R.id.username_text);
        username = getSharedPreferences("username",MODE_PRIVATE);

        //status_text = (TextView) findViewById(R.id.status);
        login_button = (Button)findViewById(R.id.login);
        enter_button = (Button)findViewById(R.id.enter_animedata);
        save_button = (Button)findViewById(R.id.save_animedata);
        String tempUser = username.getString("user","");
        String enter_str = "進入 " + tempUser + " 的動畫收藏";
        enter_button.setText(enter_str);
        String save_str = "儲存 " + tempUser + " 的動畫收藏";
        save_button.setText(save_str);
        origin_user = tempUser;



        login_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                String tempUser = username_text.getText().toString();
                if (!tempUser.isEmpty()) {
                    username = getSharedPreferences("username", MODE_PRIVATE);
                    username.edit()
                            .putString("user", tempUser)
                            .apply();

                    request = LOGIN;
                    Thread thread = new Thread(Connection);    
                    thread.start();      

                    String status_str;
                    status_text = (TextView) findViewById(R.id.status);
                    status_str = "";
                    try {
                        status_text.setText(status_str);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                    String enter_str = "進入 " + tempUser + " 的動畫收藏";
                    enter_button.setText(enter_str);
                    String save_str = "儲存 " + tempUser + " 的動畫收藏";
                    save_button.setText(save_str);
                }


            }
        });

        enter_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                Intent intent = new Intent(PreMainActivity.this, MainActivity.class);
                startActivityForResult(intent, ENTER_REQUEST);

            }
        });

        save_button.setOnClickListener(new Button.OnClickListener() {

            @Override

            public void onClick(View v) {

                request = SAVE;
                Thread thread = new Thread(Connection);
                thread.start();

            }
        });

    }

    private Runnable Connection=new Runnable(){
        @Override
        public void run() {
            
            try{
               
                InetAddress serverIp = InetAddress.getByName("140.112.250.38");
                int serverPort = 5050;
                Socket clientSocket = new Socket(serverIp, serverPort);
                BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader br = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));


                String tmp;
                SharedPreferences AnimeData;
                username = getSharedPreferences("username",MODE_PRIVATE);
                String tempUser = username.getString("user","");

                if(clientSocket.isConnected()) {
                    if (request == LOGIN) {
                        bw.write(LOGIN_REQUEST);
                        bw.newLine();
                        bw.write(tempUser);
                        bw.newLine();
                        bw.flush();

                        tmp = br.readLine();
                        AnimeData = getSharedPreferences("AnimeData", MODE_PRIVATE);
                        AnimeData.edit()
                                .putString("JSON", tmp)
                                .apply();
                        origin_user = tempUser;
                        bw.close();
                        br.close();
                        clientSocket.close();

                    } else if (request == SAVE) {
                        bw.write(SAVE_REQUEST);
                        bw.newLine();
                        bw.write(tempUser);
                        bw.newLine();
                        bw.flush();
                        AnimeData = getSharedPreferences("AnimeData", MODE_PRIVATE);
                        String tempJSON = AnimeData.getString("JSON", "");

                        bw.write(tempJSON);
                        bw.newLine();
                        bw.flush();

                        bw.close();
                        br.close();
                        clientSocket.close();
                    }
                }


            }catch(Exception e){
                e.printStackTrace();
                Log.e("text", "Socket disconnected = " + e.toString());

            }
        }
    };

}
