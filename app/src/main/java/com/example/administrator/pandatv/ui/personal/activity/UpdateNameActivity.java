package com.example.administrator.pandatv.ui.personal.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class UpdateNameActivity extends BaseActivity {


    @BindView(R.id.update_name_back)
    ImageButton fanhui;
    @BindView(R.id.baocun)
    TextView baocun;
    @BindView(R.id.personal_update_edit)
    EditText personalUpdateEdit;
    @BindView(R.id.activity_update_name)
    LinearLayout activityUpdateName;
    private String trim;

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_name;
    }

    @Override
    protected void init() {
        boolean login = SharedPreferencesUtils.getBoolean("login");
        if(login) {
            personalUpdateEdit.setText(SharedPreferencesUtils.getString("nickName"));
        }
    }

    @OnClick({R.id.update_name_back, R.id.baocun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.update_name_back:
                finish();
                break;
            case R.id.baocun:
                personalUpdateEdit.getText().toString().trim();
                Intent intent = new Intent();

                intent.putExtra("edit", personalUpdateEdit.getText().toString().trim());
                SharedPreferencesUtils.putString("nickName",personalUpdateEdit.getText().toString().trim());
                setResult(200, intent);
                finish();
                break;
        }
    }

}
