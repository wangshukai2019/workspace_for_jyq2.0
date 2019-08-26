package com.jyq.note.ui.fragments;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.jyq.note.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by pc on 2019/8/26.
 */

@EFragment(R.layout.fragment_login)
public class LoginFragment extends BaseFragment{
    public static LoginFragment newInstance(Bundle bundle) {
        LoginFragment_ fragment = new LoginFragment_();
        fragment.setArguments(bundle);
        return fragment;
    }

    @ViewById
    ProgressBar pb_loading;

    @AfterViews
    void afterViews() {

    }

}
