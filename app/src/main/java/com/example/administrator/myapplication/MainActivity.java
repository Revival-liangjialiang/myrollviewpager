package com.example.administrator.myapplication;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.IconHintView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RollPagerView mRollViewPager;
    int a=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRollViewPager= (RollPagerView) findViewById(R.id.roll_view_pager);
        mRollViewPager.setAnimationDurtion(500);
        mRollViewPager.setAdapter(new TestLoopAdapter(mRollViewPager));
//        mRollViewPager.setAdapter(new TestNomalAdapter());
        mRollViewPager.setHintView(new IconHintView(this,R.drawable.point_focus,R.drawable.point_normal));
        //mRollViewPager.setHintView(new ColorPointHintView(this, Color.YELLOW,Color.WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);
    }

    private class TestLoopAdapter extends LoopPagerAdapter{
        public int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setId(a);
            view.setOnClickListener(MainActivity.this);
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            a++;
            Log.i("MainActivity","ok!");
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }

    }

    private class TestNomalAdapter extends StaticPagerAdapter{
        private int[] imgs = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
        };


        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }


    //图片点击事件
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case 0:
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "4", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this, "5", Toast.LENGTH_SHORT).show();
                break;
            default:break;
        }
    }
}
