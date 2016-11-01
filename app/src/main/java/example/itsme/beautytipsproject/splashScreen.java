package example.itsme.beautytipsproject;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by itsme on 10/27/2016.
 */

public class splashScreen extends AppCompatActivity {

    ProgressBar pbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spash_layout);

        pbar= (ProgressBar) findViewById(R.id.progressBar);
        ObjectAnimator anim1=ObjectAnimator.ofInt(pbar,"progressbar",0,100);


        anim1.setDuration(2000);
        anim1.setInterpolator(new DecelerateInterpolator());
        anim1.start();

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        Animation anim= AnimationUtils.loadAnimation(this,R.anim.anim_down);
        iv.setAnimation(anim);

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashScreen.this,MainActivity.class));
                finish();

            }
        },2000);
    }
}
