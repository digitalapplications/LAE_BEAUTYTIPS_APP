package example.itsme.beautytipsproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class BeautyDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_detail);

        if(savedInstanceState == null){
            BeautyDetailFragment fragment=new BeautyDetailFragment();
            Bundle b=getIntent().getBundleExtra("BeautyBundle");
            fragment.setArguments(b);


            getFragmentManager().beginTransaction()
                    .add(R.id.detail_Container,fragment)
                    .commit();



        }

    }
    public void hideStatusBar(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
