package example.itsme.beautytipsproject;

import android.os.Bundle;

/**
 * Created by itsme on 10/7/2016.
 */
public class Beauty {

    public static final String ID="id";
    public static final String TITLE="title";
    public static final String TYPE="type";
    public static final String FIRST_DESCRIPTION="firstdescription";
    public static final String MID_DESCRIPTION="middescription";
    public static final String LAST_DESCRIPTION="lastdescription";
    public static final String IMAGE_FIRST="firstimage";
    public static final String IMAGE_MID="secondimage";
    public static final String IMAGE_LAST="lastimage";


    private long id;
    private String title;
    private String type;
    private String description_first;
    private String description_mid;
    private String description_last;
    private String image_first;
    private String image_mid;
    private String image_last;

    public Beauty() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    ///////////////////////////////////////////////////

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    ////////////////////////////////////////////////////////

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
////////////////////////////////////////////////////////////////////////////////
    public String getDescription_first() {
        return description_first;
    }

    public void setDescription_first(String description_first) {
        this.description_first = description_first;
    }

    ////////////////////////////////////////////////////////////////////////
    public String getDescription_mid() {
        return description_mid;
    }

    public void setDescription_mid(String description_mid) {
        this.description_mid = description_mid;
    }
///////////////////////////////////////////////////////////////////////////////////
    public String getDescription_last() {
        return description_last;
    }

    public void setDescription_last(String description_last) {
        this.description_last = description_last;
    }
///////////////////////////////////////////////////////////////////////////////////////
    public String getImage_first() {
        return image_first;
    }

    public void setImage_first(String image_first) {
        this.image_first = image_first;
    }
//////////////////////////////////////////////////////////////////////////////////
    public String getImage_mid() {
        return image_mid;
    }

    public void setImage_mid(String image_mid) {
        this.image_mid = image_mid;

    }
///////////////////////////////////////////////////////////////////////////////////////////


    public String getImage_last() {
        return image_last;
    }

    public void setImage_last(String image_last) {
        this.image_last = image_last;
    }
    ///////////////////////////////////////////////////////////////////////////////////


    public Beauty (Bundle b) {

        if (b != null) {

            this.title = b.getString(TITLE);
            this.type = b.getString(TYPE);
            this.description_first = b.getString(FIRST_DESCRIPTION);
            this.description_mid = b.getString(MID_DESCRIPTION);
            this.description_last = b.getString(LAST_DESCRIPTION);
            this.image_first = b.getString(IMAGE_FIRST);
            this.image_mid = b.getString(IMAGE_MID);
            this.image_last = b.getString(IMAGE_LAST);
        }
    }

        public Bundle toBundle(){
            Bundle b=new Bundle();
            b.putDouble(ID,this.id);
            b.putString(TITLE,this.title);
            b.putString(TYPE,this.type);
            b.putString(FIRST_DESCRIPTION,this.description_first);
            b.putString(MID_DESCRIPTION,this.description_mid);
            b.putString(LAST_DESCRIPTION,this.description_last);
            b.putString(IMAGE_FIRST,this.image_first);
            b.putString(IMAGE_MID,this.image_mid);
            b.putString(IMAGE_LAST,this.image_last);
            return b;
        }
}
