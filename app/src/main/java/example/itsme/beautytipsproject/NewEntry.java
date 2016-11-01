package example.itsme.beautytipsproject;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class NewEntry extends AppCompatActivity {

    public static final String LOGTAG = "EXPLORECA";
    private static final int RESULT_LOAD_IMAGE = 20;
    beautyDataSource dataSource;
    EditText title, type, desc1, desc2, desc3;
    TextView img1, img2, img3;
    Button save;
    ImageView selected_img;
    String encodedImage1, encodedImage2, encodedImage3;
//    String image1, image2, image3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        dataSource = new beautyDataSource(this);
        dataSource.open();

        title = (EditText) findViewById(R.id.tipTitle);
        type = (EditText) findViewById(R.id.tipType);
        desc1 = (EditText) findViewById(R.id.tipDesc_1);
        desc2 = (EditText) findViewById(R.id.tipDesc_2);
        desc3 = (EditText) findViewById(R.id.tipDesc_3);
        img1 = (TextView) findViewById(R.id.imgPath_1);
        img2 = (TextView) findViewById(R.id.imgPath_2);
        img3 = (TextView) findViewById(R.id.imgPath_3);
        save = (Button) findViewById(R.id.btn_save);
        selected_img = (ImageView) findViewById(R.id.selected_img);

    }


    @Override
    protected void onResume() {
        super.onResume();
        dataSource.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataSource.close();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void getImage(View view) {
        Intent photopicker = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(photopicker, RESULT_LOAD_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            selected_img.setImageBitmap(BitmapFactory.decodeFile(picturePath));

     //////////////////////////  IMAGE 1 /////////////////////////////////////

            if (img1.getText().toString().equals("TextView1")) {
                img1.setText(picturePath);

                Bitmap bm = BitmapFactory.decodeFile(picturePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.PNG,10, baos);

                byte[] b = baos.toByteArray();
                encodedImage1 = Base64.encodeToString(b, Base64.DEFAULT);

                Log.i(LOGTAG, encodedImage1);
            }

/////////////////////////////////////////  IMAGE 2  ///////////////////////////////
            else if (img2.getText().toString().equals("TextView2")) {

                img2.setText(picturePath);
                Bitmap bm = BitmapFactory.decodeFile(picturePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                byte[] b = baos.toByteArray();
               encodedImage2 = Base64.encodeToString(b, Base64.DEFAULT);
                Log.i(LOGTAG,encodedImage2);
            }

            //////////////////////////// IMAGE 3//////////////////////////////////////////////////////

            else if (img3.getText().toString().equals("TextView3")) {

                img3.setText(picturePath);
                Bitmap bm = BitmapFactory.decodeFile(picturePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
                byte[] b = baos.toByteArray();
                encodedImage3 = Base64.encodeToString(b, Base64.DEFAULT);
                Log.i(LOGTAG,encodedImage3);
            }


        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//    public void addData(View view) {
//
//        Beauty beauty = new Beauty();
//        beauty.setTitle(title.getText().toString());
//        beauty.setType(type.getText().toString());
//        beauty.setDescription_first(desc1.getText().toString());
//        beauty.setDescription_mid(desc2.getText().toString());
//        beauty.setDescription_last(desc3.getText().toString());
//        beauty.setImage_first(encodedImage1);
//        Log.i(LOGTAG, "Adding To Database " + encodedImage1);
////       Log.i(LOGTAG,"here is the setting of image 1 "+image1);
////        beauty.setImage_mid(image2);
////        beauty.setImage_last(image3);
//        dataSource.create(beauty);
//
//    }

    public void addData(View view) {
        if (title.getText().toString().trim().equals("")) title.setError("Title is required");
        else if (type.getText().toString().trim().equals(""))
            type.setError("Type name is required");
        else if (desc1.getText().toString().trim().equals(""))
            desc1.setError("First description is required");
        else if (desc2.getText().toString().trim().equals(""))
            desc2.setError("Second description is required");
        else if (desc3.getText().toString().trim().equals(""))
            desc3.setError("Third description is required");
        else if (img1.getText().toString().equals("TextView1")){

            Toast.makeText(this, "Please Select First Image", Toast.LENGTH_LONG).show();
        }
        else if (img2.getText().toString().equals("TextView2")){

            Toast.makeText(this, "Please Select Second Image", Toast.LENGTH_LONG).show();
        }
        else if (img3.getText().toString().equals("TextView3")){

            Toast.makeText(this, "Please Select Last Image", Toast.LENGTH_LONG).show();
        }

        else {


            boolean isInserted = dataSource.createData(


                    encodedImage1.toString(),
                    encodedImage2.toString(),
                    encodedImage3.toString(),
                    title.getText().toString(),
                    type.getText().toString(),
                    desc1.getText().toString(),
                    desc2.getText().toString(),
                    desc3.getText().toString());
            Log.i(LOGTAG, title.toString());
            if (isInserted = true) {


                Toast.makeText(this, "Data is Inserted", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NewEntry.this, TipList.class);
                startActivity(intent);
            } else {

                Toast.makeText(this, "Not Inserted", Toast.LENGTH_LONG).show();
            }

        }
    }
}
