package example.itsme.beautytipsproject;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BeautyDetailFragment extends Fragment {
    Beauty beauty;
    public static final String LOGTAG = "EXPLORECA";

    public void BeautyDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BeautyDetailActivity) getActivity()).hideStatusBar();

        Bundle b = getArguments();
        if (b != null && b.containsKey(Beauty.TITLE)) {

            beauty = new Beauty(b);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_activity, container, false);

        if (beauty != null) {

            /////////////////////////////////////IMAGE 1 ////////////////////////////////////////////

            String image = beauty.getImage_first();
            byte[] image_1 = Base64.decode(image.getBytes(), Base64.DEFAULT);
            Log.i(LOGTAG, "This is image conversion in byte  in detail activity fragment" + image_1);
            ImageView iv = (ImageView) view.findViewById(R.id.image1);
            iv.setImageBitmap(BitmapFactory.decodeByteArray(image_1, 0, image_1.length));

///////////////////////////////////////////////////IMAGE2////////////////////////////////////////////

            String image2 = beauty.getImage_mid();
            byte[] image_2 = Base64.decode(image2.getBytes(), Base64.DEFAULT);
            Log.i(LOGTAG, "This is image conversion in byte  in detail activity fragment" + image_2);
            ImageView iv_mid= (ImageView) view.findViewById(R.id.image2);
            iv_mid.setImageBitmap(BitmapFactory.decodeByteArray(image_2, 0, image_2.length));


/////////////////////////////////////////////IMAGE3//////////////////////////////////////////////////////

            String image3 = beauty.getImage_last();
            byte[] image_3 = Base64.decode(image3.getBytes(), Base64.DEFAULT);
            Log.i(LOGTAG, "This is image conversion in byte  in detail activity fragment" + image_3);
            ImageView iv_last = (ImageView) view.findViewById(R.id.image3);
            iv_last.setImageBitmap(BitmapFactory.decodeByteArray(image_3, 0, image_3.length));

/////////////////////////////////////////////////////////////////////////////////////////////////////

            TextView desc_first = (TextView) view.findViewById(R.id.tip_descFirst);
            desc_first.setText(beauty.getDescription_first());

            TextView desc_mid = (TextView) view.findViewById(R.id.tip_descMid);
            desc_mid.setText(beauty.getDescription_mid());

            TextView desc_last = (TextView) view.findViewById(R.id.tip_descLast);
            desc_last.setText(beauty.getDescription_last());
        }

        return view;

    }
}
