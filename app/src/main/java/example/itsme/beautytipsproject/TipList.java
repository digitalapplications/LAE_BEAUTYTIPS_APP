package example.itsme.beautytipsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

public class TipList extends AppCompatActivity
        implements TipListFragment.Callbacks {

    private boolean isToPain = false;
    public static final String LOGTAG="EXPLORECA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_list);

        if (findViewById(R.id.detail_Container) != null) {
            isToPain = true;
        }
    }

    @Override
    public void onItemSelected(Beauty beauty) {
        Bundle b = beauty.toBundle();
        if (isToPain) {
            BeautyDetailFragment fragment = new BeautyDetailFragment();
            fragment.setArguments(b);
            getFragmentManager().beginTransaction()
                    .replace(R.id.detail_Container, fragment)
                    .commit();

        } else {
            Intent intent = new Intent(this,BeautyDetailActivity.class);
            intent.putExtra("BeautyBundle", b);
            startActivityForResult(intent,1002);
        }

    }

    public void hideStatusBar(){
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
