package com.jyq.note.ui.fragments;

import android.app.Activity;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by _SOLID
 * Date:2016/3/30
 * Time:11:30
 */
public abstract class BaseFragment extends SupportFragment {

    protected Activity mContext;


    @Override
    public void onAttach(Activity context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        hideSoftInput();
    }

}
