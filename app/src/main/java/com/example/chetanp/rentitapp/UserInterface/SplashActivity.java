package com.example.chetanp.rentitapp.UserInterface;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chetanp.rentitapp.BasicComponentsReuse;
import com.example.chetanp.rentitapp.MainActivity;
import com.example.chetanp.rentitapp.R;

public class SplashActivity extends AppCompatActivity {
    public static final String sessionvalue = "Session not created";
    private BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //Session shared preference work
        SharedPreferences sharedPreferences_obj = getSharedPreferences("LoginAppSession", Context.MODE_PRIVATE);
        String sessionstatus = sharedPreferences_obj.getString("LoginuserAuthKey", sessionvalue);
        if (sessionstatus.equals(sessionvalue) || sessionstatus.equals("")) {
            final Thread thread_obj = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1500);
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                basicComponentsReuse_obj.intentmoveAnimateCode_method(SplashActivity.this,intent);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }//end of catch
                        }//end of run method7
                    }//end of Runnable
            ); //end of Thread
            thread_obj.start();
        } else {
            Intent intent_obj = new Intent(getApplicationContext(), MainActivity.class);
            basicComponentsReuse_obj.intentmoveAnimateCode_method(SplashActivity.this,intent_obj);
        }//end of else
    }//end of oncreate method
}//end of main class