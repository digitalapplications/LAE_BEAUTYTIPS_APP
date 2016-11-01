package example.itsme.beautytipsproject;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by itsme on 10/24/2016.
 */

public class TipListFragment extends ListFragment{
    beautyDataSource dataSource;
//    final List<Beauty> b=dataSource.findAll();
    List<Beauty> beauties;
    private Callbacks activity;

    public TipListFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TipList)getActivity()).hideStatusBar();
        dataSource = new beautyDataSource(getActivity());
        dataSource.open();
         beauties = dataSource.findAll();
        dataSource.close();
         BeautyArrayAdapter adapter = new BeautyArrayAdapter(getActivity(),R.layout.single_list_textview,beauties);
        setListAdapter(adapter);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview=inflater.inflate(R.layout.fragment_tip_list,container,false);
        return rootview;

    }

    public interface Callbacks{

        public void onItemSelected(Beauty beauty);
  }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Beauty beauty=beauties.get(position);
        activity.onItemSelected(beauty);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (Callbacks) activity;
    }

}
