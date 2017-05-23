package demo.com.myanimation;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rootLayout;
    Animation animShow, animHide, animShow2, animHide2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View top = (View)findViewById(R.id.pathview);
        final View bottom = (View)findViewById(R.id.pathview2);
        Button click = (Button)findViewById(R.id.click);
        Button click2 = (Button)findViewById(R.id.click2);

        rootLayout=(RelativeLayout)findViewById(R.id.rootLayout);

        initAnimation();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom.startAnimation( animHide );
                bottom.setVisibility(View.GONE);
                top.startAnimation( animHide2 );
                top.setVisibility(View.GONE);
            }
        });

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom.setVisibility(View.VISIBLE);
                bottom.startAnimation( animShow );
                top.setVisibility(View.VISIBLE);
               top.startAnimation( animShow2 );
            }
        });

    }
    private void initAnimation()
    {
        animShow = AnimationUtils.loadAnimation( this, R.anim.view_show);
        animHide = AnimationUtils.loadAnimation( this, R.anim.hide);

        animShow2 = AnimationUtils.loadAnimation( this, R.anim.view_show2);
        animHide2 = AnimationUtils.loadAnimation( this, R.anim.hide2);
    }

    @Override
    public void onBackPressed() {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            int cx = rootLayout.getWidth();
//            int cy = 0;
//            float finalRadius = Math.max(rootLayout.getWidth(), rootLayout.getHeight());
//            Animator circularReveal = ViewAnimationUtils.createCircularReveal(rootLayout, cx, cy, finalRadius, 0);
//
//            circularReveal.addListener(new Animator.AnimatorListener() {
//                @Override
//                public void onAnimationStart(Animator animator) {
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animator animator) {
//                    rootLayout.setVisibility(View.INVISIBLE);
//
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animator) {
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animator animator) {
//
//                }
//            });
//            circularReveal.setDuration(2000);
//            circularReveal.start();
//        }else{
//            super.onBackPressed();
//        }
        startActivity(new Intent(getApplicationContext(),Second.class));
        finish();
    }
}
