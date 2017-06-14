package com.bluedigm.android.circularprogressbar;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private ProgressBar mProgressBar;
    private ValueAnimator mAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text1);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

        mAnim = ValueAnimator.ofInt(0, 100);
        mAnim.setInterpolator(new DecelerateInterpolator());
        mAnim.setDuration(500);
        mAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                String value = animation.getAnimatedValue().toString();
                mTextView.setText(value);
                mProgressBar.setProgress(Integer.parseInt(value));
            }
        });
        mAnim.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mAnim.start();
        return super.onTouchEvent(event);
    }
}
