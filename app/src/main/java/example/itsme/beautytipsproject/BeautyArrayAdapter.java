package example.itsme.beautytipsproject;


import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class BeautyArrayAdapter extends ArrayAdapter<Beauty> {

//    beautyOpenHelper dbhelper=new beautyOpenHelper(getContext());

    public static final String LOGTAG = "EXPLORECA";
    private final beautyDataSource dataSource;
    Context context;
        List<Beauty> objects;


        public BeautyArrayAdapter(Context context, int resource, List<Beauty> objects) {
            super(context, resource, objects);

            this.context = context;
            this.objects = objects;
            dataSource = new beautyDataSource(context);
        }

    @NonNull
        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {

            final Beauty beauty = objects.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            final View view = inflater.inflate(R.layout.single_list_textview, null);


            final TextView tv_title = (TextView) view.findViewById(R.id.tvTitle);
            tv_title.setText(beauty.getTitle());

            TextView tv_type = (TextView) view.findViewById(R.id.tvType);
            tv_type.setText(beauty.getType());

           String image = beauty.getImage_first();

            byte[] image1= Base64.decode(image.getBytes(),Base64.DEFAULT);

            ImageView img = (ImageView) view.findViewById(R.id.list_image);
            img.setImageBitmap(BitmapFactory.decodeByteArray(image1,0,image1.length));
//            Log.i(LOGTAG,"Image is set into Image View "+img);

            //////////////////////////////////////////////////////////////////////////////////

//        ImageButton delete= (ImageButton) view.findViewById(R.id.delete);
            view.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataSource.deleteData(String.valueOf(objects.get(position).getId()));
                    objects.remove(position);
                    notifyDataSetChanged();
                }
            });


          return view;
        }

    }



