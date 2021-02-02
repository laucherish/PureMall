package com.laucherish.puremall.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.laucherish.puremall.R;
import com.laucherish.puremall.app.base.BaseSupportActivity;
import com.laucherish.puremall.di.component.DaggerLoginComponent;
import com.laucherish.puremall.mvp.contract.LoginContract;
import com.laucherish.puremall.mvp.model.entity.UserResponse;
import com.laucherish.puremall.mvp.presenter.LoginPresenter;
import com.laucherish.puremall.mvp.ui.widget.view.ClearEditText;
import com.laucherish.puremall.mvp.ui.widget.view.PasswordEditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 02/02/2021 13:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class LoginActivity extends BaseSupportActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.et_login_phone)
    ClearEditText etLoginPhone;
    @BindView(R.id.et_login_password)
    PasswordEditText etLoginPassword;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void loginSuccess(UserResponse userResponse) {
        showMessage("登录成功");

    }

    @OnClick({R.id.btn_login_commit, R.id.iv_login_qq, R.id.iv_login_wechat})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_commit:
                String username = etLoginPhone.getText().toString();
                String password = etLoginPassword.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    showMessage("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    showMessage("请输入密码");
                    return;
                }
                if (mPresenter != null) {
                    mPresenter.login(username,password);
                }
                break;
            case R.id.iv_login_qq:
                break;
            case R.id.iv_login_wechat:
                break;
        }
    }
}
