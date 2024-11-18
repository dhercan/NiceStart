package com.dhernandez.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MainActivity extends AppCompatActivity {

    TextView myContext;
    SwipeRefreshLayout swipeLayout;
    WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myContext = findViewById(R.id.textView2);
        registerForContextMenu(myContext);



        //Para actualizar

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //La vista dentro es un webview con permiso para zoom

//        miVisorWeb.getSettings().setJavaScriptEnabled(true);
//        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb=findViewById(R.id.miVisorWeb);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if (item.getItemId()==R.id.item1){
            Toast.makeText(this, "Op1: Copiando", Toast.LENGTH_SHORT).show();
            return true;
        }else if (item.getItemId()==R.id.item2){
            Toast.makeText(this, "Op1: Descargando", Toast.LENGTH_SHORT).show();
            return true;
        }else{
            return false;
        }
    }

    @Override
   public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
    }





    @Override
   public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.perfil){
            Intent intent = new Intent(MainActivity.this, Profile.class);
            startActivity(intent);
        }else if(id==R.id.logout) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }else if(id==R.id.mas) {
            Toast.makeText(this, "Mas cositas coming", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(MainActivity.this, "Hi there! I don't exist :)", Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };

}