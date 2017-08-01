package com.example.administrator.pandatv.ui.personal.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.net.OkHttpUtils;
import com.example.administrator.pandatv.utils.SharedPreferencesUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginSuccessActivity extends BaseActivity {
    @BindView(R.id.success_xin_back)
    ImageButton successXinBack;
    @BindView(R.id.iv_headicon)
    ImageView ivHeadicon;
    @BindView(R.id.person_have_login_layout)
    RelativeLayout personHaveLoginLayout;
    @BindView(R.id.nick_name)
    TextView nickName;
    @BindView(R.id.personal_nickname_layout)
    RelativeLayout personalNicknameLayout;
    @BindView(R.id.btn_login_out)
    TextView btnLoginOut;

    private Uri uriForCamera;
    private File appDir;
    private PopupWindow popupWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_xin;
    }

    @Override
    protected void init() {
        boolean login = SharedPreferencesUtils.getBoolean("login");
        if(login) {
            ivHeadicon.setImageResource(R.mipmap.tab_panda_live_normal);
            OkHttpUtils.getInstance().loadImage(SharedPreferencesUtils.getString("iconUrl"),ivHeadicon);
            nickName.setText(SharedPreferencesUtils.getString("nickName"));
        }
    }

    @OnClick({R.id.success_xin_back, R.id.person_have_login_layout, R.id.personal_nickname_layout,R.id.btn_login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.success_xin_back:
                finish();
                break;
            case R.id.person_have_login_layout:
                View inflate = LayoutInflater.from(this).inflate(R.layout.personal_paizhao_dialog, null);
                popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, 500, true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 10);
                TextView xiangce = (TextView) inflate.findViewById(R.id.xiangce);
                TextView paiyizhang = (TextView) inflate.findViewById(R.id.paiyizhang);
                TextView quxiao = (TextView) inflate.findViewById(R.id.quxiao);
                xiangce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getImageFromAlbum();
                    }
                });

                paiyizhang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getImageFromCamera();
                    }
                });
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
                break;
            case R.id.personal_nickname_layout:
                startActivityForResult(new Intent(LoginSuccessActivity.this,UpdateNameActivity.class),1000);
                break;
            case R.id.btn_login_out:
                SharedPreferencesUtils.putBoolean("login",false);
                startActivity(new Intent(LoginSuccessActivity.this,MineCenterActivity.class));
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1000:
                nickName.setText(data.getStringExtra("edit"));
                break;
            case 2000:
                Uri uri = data.getData();
                SharedPreferencesUtils.putString("uriForCamera", String.valueOf(uri));
                cropRawPhoto(uri);
                break;
            case 3000:
                Uri uri1 = Uri.parse(SharedPreferencesUtils.getString("uriForCamera"));
                cropRawPhoto(uri1);
                break;
            case 4000:
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap data1 = extras.getParcelable("data");
                    ivHeadicon.setImageBitmap(data1);
                    break;
                }
        }
    }

    //    从本地相册 获取图片
    protected void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, 2000);
    }

    /**
     * 裁剪原始的图片
     */
    public void cropRawPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, 4000);
    }

    //    从照相机获取图片
    protected void getImageFromCamera() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        uriForCamera = Uri.fromFile(createImageStoragePath());
        SharedPreferencesUtils.putString("uriForCamera", String.valueOf(uriForCamera));

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForCamera);
        startActivityForResult(intent, 3000);
    }

    private File createImageStoragePath() {
        if (hasSdcard()) {
            appDir = new File("/sdcard/testImages/");
            if (!appDir.exists()) {
                appDir.mkdirs();
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String str = simpleDateFormat.format(date);
            String fileName = str + ".jpg";
            File file = new File(appDir, fileName);
            return file;
        } else {
            return null;
        }
    }


    private boolean hasSdcard() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
}
