package com.yrtelf.newsviper.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.yrtelf.newsviper.AppComponent;
import com.yrtelf.newsviper.CustomApplication;

import javax.inject.Inject;

public abstract class BaseActivity<B extends ViewDataBinding, P> extends AppCompatActivity {

    protected B binding;

    @Inject
    protected P presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.injectDagger();
        this.attachView();

        if (this.binding == null) {
            this.binding = DataBindingUtil.setContentView(this, getXmlLayout());
        }
    }

    protected abstract void injectDagger();

    protected abstract int getXmlLayout();

    protected abstract void attachView();

    protected abstract void detachView();

    @Override
    public void onResume() {
        super.onResume();
        this.closeKeyboard();
    }

    protected AppComponent getAppComponent() {
        CustomApplication application = (CustomApplication) getApplication();
        return application.getAppComponent();
    }

    protected void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.detachView();
    }

}