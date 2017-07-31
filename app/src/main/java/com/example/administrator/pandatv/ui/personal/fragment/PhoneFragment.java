package com.example.administrator.pandatv.ui.personal.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.ui.personal.activity.LoginActivity;
import com.example.administrator.pandatv.ui.personal.contract.RegisterContract;
import com.example.administrator.pandatv.ui.personal.contract.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by li on 2017/7/13.
 */

public class PhoneFragment extends BaseFragment implements RegisterContract.View{

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.null_phone)
    TextView nullPhone;
    @BindView(R.id.edit_imgyanzhengma)
    EditText editImgyanzhengma;
    @BindView(R.id.personal_reg_imgVerification)
    ImageView personalRegImgcheck;
    @BindView(R.id.null_imagecheck)
    TextView nullImagecheck;
    @BindView(R.id.edit_phoneyanzhengma)
    EditText editPhoneyanzhengma;
    @BindView(R.id.personal_reg_phone_VerificationCode)
    TextView personalRegPhonecheck;
    @BindView(R.id.null_phonecheck)
    TextView nullPhonecheck;
    @BindView(R.id.edit_inputpasswrod)
    EditText editInputpasswrod;
    @BindView(R.id.hint_password)
    TextView hintPassword;
    @BindView(R.id.xieyi_check)
    CheckBox xieyiCheck;
    @BindView(R.id.personal_reg_xieyi_view)
    TextView personalRegXieyiView;
    @BindView(R.id.hint_xieyi)
    TextView hintXieyi;
    @BindView(R.id.btn_register)
    TextView btnRegister;
    private String exception;
    private RegisterContract.Presenter presenter;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            presenter.start();
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.phonefragment;
    }

    @Override
    protected void init(View view) {
        new RegisterPresenter(this);
    }

    @Override
    protected void loadData() {
//        presenter.start();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            handler.sendEmptyMessage(1000);
        }
    }

    @OnClick({R.id.personal_reg_phone_VerificationCode, R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_reg_phone_VerificationCode:
                Log.e("TAG","获取验证码");
                presenter.phoneVerifiCodeRegister(editPhone.getText().toString().trim(),
                        editImgyanzhengma.getText().toString().trim());
                break;
            case R.id.btn_register:
                presenter.phoneRegisters(editPhone.getText().toString().trim(),
                        editInputpasswrod.getText().toString().trim(),
                        editPhoneyanzhengma.getText().toString());
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showImageCode(Bitmap bitmap) {
        personalRegImgcheck.setImageBitmap(bitmap);
    }

    @Override
    public void showEmailTips(String msg) {

    }

    @Override
    public void dismissEmailTips() {

    }

    @Override
    public void showPwdTips(String msg) {

    }

    @Override
    public void dismissPwdTips() {

    }

    @Override
    public void toLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String error) {

    }
//            //获取验证码
//            case R.id.personal_reg_phonecheck:
//                String tPhoneNumber = editPhone.getText().toString().trim();
////                    图形验证码
//                String imgyanzhengma = editImgyanzhengma.getText().toString().trim();
//
//                    if (tPhoneNumber.equals("")&&tPhoneNumber==null&&imgyanzhengma.equals("")&&imgyanzhengma==null&&phoneyanzhengma.equals("")&&phoneyanzhengma==null) {
//                            nullPhone.setText("手机号不能为空");
//                            nullImagecheck.setText("验证码不能为空");
//                            nullPhonecheck.setText("验证码不能为空");
//                    }
//                getPersonalRegPhoneCheck();
//                break;
//            //注册
//            case R.id.btn_register:
//                try {
//                    getRegister();
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//
//
//                xieyiCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        if(isChecked==true) {
//                            try {
//                                getRegister();
//                            } catch (UnsupportedEncodingException e) {
//                                e.printStackTrace();
//                            }
//                        }else {
//                            Toast.makeText(getActivity(), "未勾选《央视网网络服务使用协议》", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//
//                break;
//        }
//    }

//    public void getPersonalRegImgCheck() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                OkHttpClient okHttpClient = new OkHttpClient();
//                Request build = new Request.Builder().url("http://reg.cntv.cn/simple/verificationCode.action").build();
//                okHttpClient.newCall(build).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//
//                        Headers headers = response.headers();
//
//                        JSESSIONID = headers.get("Set-Cookie");
//                        Log.e("TAG", "图形验证码的额" + JSESSIONID);
//
////                            for (int x=0;x<headers.size();x++){
////                                String name = headers.name(x);
////                                String name1 = headers.get(name);
////                                if(name1.contains("JSESSIONID")) {
////                                    JSESSIONID=name1;
////                                    break;
////                                }
////                                Log.e("TAG",name1+"---+++");
////                            }
//
//                        bytes = response.body().bytes();
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Drawable captchaImage = byteToDrawable(bytes);
//                                personalRegImgcheck.setImageDrawable(captchaImage);
//                            }
//                        });
//                    }
//                });
//            }
//        }).start();
//    }
//
//
//    public static Drawable byteToDrawable(byte[] byteArray) {
//        try {
//            String string = new String(byteArray, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        ByteArrayInputStream ins = new ByteArrayInputStream(byteArray);
//        return Drawable.createFromStream(ins, null);
//    }


//    public void getPersonalRegPhoneCheck() {
////17600304681
//
//
//        OkHttpClient click = new OkHttpClient();
//        String url = "http://reg.cntv.cn/regist/getVerifiCode.action";
//        String from = "http://cbox_mobile.regclientuser.cntv.cn";
////                    手机号
//        String tPhoneNumber = editPhone.getText().toString().trim();
////                    图形验证码
//        String imgyanzhengma = editImgyanzhengma.getText().toString().trim();
////                请求  获取验证码的 网络请求
////                post 请求体
//        Log.e("TAG", "图形验证码" + JSESSIONID);
//        RequestBody body = new FormBody.Builder()
//                .add("method", "getRequestVerifiCodeM")
//                .add("mobile", tPhoneNumber)
//                .add("verfiCodeType", "1")
//                .add("verificationCode", imgyanzhengma)
//                .build();
//        try {
////                    post  请求头
//            Request request = new Request.Builder().url(url)
//                    .addHeader("Referer", URLEncoder.encode(from, "UTF-8"))
//                    .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
//                    .addHeader("Cookie", JSESSIONID)
//                    .post(body).build();
//
//            click.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//                    exception = e.getMessage().toString();
//                    Log.e("TAG", e.getMessage().toString());
//
//
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//
//                    String string = response.body().string();
//                    Log.e("TAG", "手机验证码结果" + string);
//
//                }
//            });
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//    public void getRegister() throws UnsupportedEncodingException {
//
//        OkHttpClient client = new OkHttpClient();
////                    手机号
//        String tPhoneNumber = editPhone.getText().toString().trim();
//        Log.e("TAG", "手机号：" + tPhoneNumber);
////                    图形验证码
//        String imgyanzhengma = editImgyanzhengma.getText().toString().trim();
//        //手机验证码
//        phoneyanzhengma = editPhoneyanzhengma.getText().toString().trim();
//        Log.e("TAG", "手机验证码：" + phoneyanzhengma);
////mima
//        passwrod = editInputpasswrod.getText().toString().trim();
//
//        Log.e("TAG", "密码：" + passwrod);
//
////                请求  获取验证码的 网络请求
////                post 请求体
//        Log.e("TAG", "图形验证码" + JSESSIONID);
//        RequestBody body = new FormBody.Builder()
//                .add("method", "saveMobileRegisterM")
//                .add("mobile", tPhoneNumber)
//                .add("verfiCode", phoneyanzhengma)
//                .add("passWd", URLEncoder.encode(passwrod, "UTF-8"))
//                .add("verfiCod eType", "1")
//                .add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
//                .build();
//
//        Request build = new Request.Builder().url("https://reg.cntv.cn/regist/mobileRegist.do")
//                .addHeader("Referer", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
//                .addHeader("User-Agent", URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"))
//                .post(body)
//                .build();
//
//        client.newCall(build).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//                if (BuildConfig.DEBUG) {
//                    Log.e("TAG", e.getMessage());
//                }
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String tString = response.body().string();
//                if (BuildConfig.DEBUG) {
//                    Log.e("TAG", "注册：" + tString);
//
//                    if(tString.equals("Success")) {
//                        Toast.makeText(getActivity(), "注册成功，返回注册", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getActivity(), LoginActivity.class));
//                    }
//
//                }
//            }
//        });
//
//    }
}
