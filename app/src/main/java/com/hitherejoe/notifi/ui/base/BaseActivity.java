package com.hitherejoe.notifi.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.hitherejoe.notifi.NotifiApplication;
import com.hitherejoe.notifi.injection.component.ActivityComponent;
import com.hitherejoe.notifi.injection.component.DaggerActivityComponent;
import com.hitherejoe.notifi.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(NotifiApplication.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

}
