package com.example.mateusz.figuryandroid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Test extends Activity implements OnClickListener {
    private EditText edit;
    private TextView tekst;
    private Button ok;
    private Button wyjdz;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onStart() {
        super.onStart();
        setContentView(R.layout.test);

        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }
    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.test);
        edit = (EditText)findViewById(R.id.Edit);
        ok = (Button)findViewById(R.id.ok);
        ok.setOnClickListener(this);
        tekst = (TextView)findViewById(R.id.Tekst);
    }

    public void onClick(View v) {
        tekst.setText(edit.getText().toString());
        String przekaz=edit.getText().toString();
        Toast();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("dane",przekaz);
        startActivity(intent);
    }
    private void Toast(){
        Context context = getApplicationContext();
        CharSequence text = String.format("Liczba figur to " + edit.getText().toString());
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}