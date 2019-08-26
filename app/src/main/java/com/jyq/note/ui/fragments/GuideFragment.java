package com.jyq.note.ui.fragments;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jyq.note.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by pc on 2019/8/26.
 */

@EFragment(R.layout.fragment_guide)
public class GuideFragment extends BaseFragment{

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

    }

    @Click(R.id.btn_guide)
    void onClick(View view){
        switch (view.getId()){
            case R.id.btn_guide:
                break;
        }
    }

}
