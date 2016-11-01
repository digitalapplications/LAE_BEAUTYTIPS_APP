package example.itsme.beautytipsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStatusBar();
    }

    public void onClickNewEntry(View view) {
        Intent intent=new Intent(MainActivity.this,NewEntry.class);
        startActivity(intent);
    }

    public void onClickBeautyTips(View view) {
        Intent intent=new Intent(MainActivity.this,TipList.class);
        startActivity(intent);
    }

    public void hideStatusBar(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
