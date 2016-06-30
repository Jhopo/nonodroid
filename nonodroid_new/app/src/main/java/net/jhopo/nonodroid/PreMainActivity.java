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
                    Thread thread = new Thread(Connection);     //賦予執行緒工作
                    thread.start();                    //讓執行緒開始執行

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
            // TODO Auto-generated method stub
            try{
                // IP為Server端
                InetAddress serverIp = InetAddress.getByName("140.112.250.38");
                int serverPort = 5050;
                Socket clientSocket = new Socket(serverIp, serverPort);
                //取得網路輸出串流
                BufferedWriter bw = new BufferedWriter( new OutputStreamWriter(clientSocket.getOutputStream()));
                // 取得網路輸入串流
                BufferedReader br = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
                // 當連線後


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
                        //if(tempUser.compareTo(origin_user) != 0) {
                        AnimeData.edit()
                                .putString("JSON", tmp)
                                .apply();
                        // }
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
                /*
                while (clientSocket.isConnected()) {
                    // 取得網路訊息
                    tmp = br.readLine();    //宣告一個緩衝,從br串流讀取值
                    // 如果不是空訊息
                    if(tmp!=null){


                    }
                }
                */

            }catch(Exception e){
                //當斷線時會跳到catch,可以在這裡寫上斷開連線後的處理
                e.printStackTrace();
                Log.e("text", "Socket disconnected = " + e.toString());

            }
        }
    };
/*
    @Override
    protected void onDestroy() {            //當銷毀該app時
        super.onDestroy();
        try {
            json_write=new JSONObject();
            json_write.put("action","離線");    //傳送離線動作給伺服器
            Log.i("text","onDestroy()="+json_write+"\n");
            //寫入後送出
            bw.write(json_write+"\n");
            bw.flush();
            //關閉輸出入串流後,關閉Socket
            //最近在小作品有發現close()這3個時,導致while (clientSocket.isConnected())這個迴圈內的區域錯誤
            //會跳出java.net.SocketException:Socket is closed錯誤,讓catch內的處理再重複執行,如有同樣問題的可以將下面這3行註解掉
            bw.close();
            br.close();
            clientSocket.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.e("text", "onDestroy()=" + e.toString());
        }
    }
*/
}
