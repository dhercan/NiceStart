package com.dhernandez.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myContext = findViewById(R.id.textView2);
        registerForContextMenu(myContext);

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

}