package com.jyq.note.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jyq.note.R;
import com.jyq.note.consts.ConstValue;
import com.jyq.note.ui.activitys.ContainerActivity;
import com.jyq.note.ui.activitys.ContainerActivity_;
import com.jyq.note.utils.ButtonUtils;
import com.jyq.note.utils.SPUtils;
import com.jyq.note.utils.ToastUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pc on 2019/8/26.
 */

@EFragment(R.layout.fragment_guide)
public class GuideFragment extends BaseFragment implements ViewPager.OnPageChangeListener{

    public static GuideFragment newInstance(Bundle bundle) {
        GuideFragment_ fragment = new GuideFragment_();
        fragment.setArguments(bundle);
        return fragment;
    }

    @ViewById
    ViewPager vp_guide;
    @ViewById
    Button btn_guide;

    private int[] imageArray = new int[]{R.mipmap.guide1, R.mipmap.guide2, R.mipmap.guide3, R.mipmap.guide4};

    @AfterViews
    void afterViews() {

        vp_guide.addOnPageChangeListener(this);

        vp_guide.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageArray.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = new ImageView(mContext);
                imageView.setBackgroundResource(imageArray[position]);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View)object);
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == imageArray.length - 1) {
            btn_guide.setVisibility(View.VISIBLE);
        } else {
            btn_guide.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Click(R.id.btn_guide)
    void onClick(View view){
        if(ButtonUtils.isFastDoubleClick(view.getId())){
            ToastUtils.showShort(R.string.frequency);
            return;
        }
        switch (view.getId()){
            case R.id.btn_guide:
                SPUtils.putInt(ConstValue.isFirstRunning,1);//标记非第一次安装
                Intent intent = new Intent(mContext, ContainerActivity_.class);
                Bundle bundle = new Bundle();
                bundle.putInt(ContainerActivity.FragmentTag, ContainerActivity.LoginFramgentTag);
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().finish();
                break;
        }
    }

}
