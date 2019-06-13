package com.example.diit24.ui.autorization;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diit24.App;
import com.example.diit24.R;
import com.example.diit24.mvp.autorization.AutorizationPresenter;
import com.example.diit24.mvp.autorization.AutorizationView;
import com.example.diit24.ui.tasks.TaskActivity;

public class AutorizationActivity extends AppCompatActivity implements AutorizationView {

    private AutorizationPresenter presenter;

    private EditText emailEdit;
    private EditText passwordEdit;
    private Button button_enter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AutorizationPresenter(App.dataManager);
        presenter.attachView(this);
        setContentView(R.layout.activity_main);
        initViews();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        button_enter = findViewById(R.id.enter_in_account);


    }

   public void inteny() {
    Intent intent = new Intent(AutorizationActivity.this, TaskActivity.class);
    startActivity(intent);}

    private void initViews() {
        emailEdit = findViewById(R.id.email);
        passwordEdit = findViewById(R.id.password);

        button_enter = findViewById(R.id.enter_in_account);
        button_enter.setOnClickListener(v -> {
            presenter.autorization(
                    emailEdit.getText().toString(),
                    passwordEdit.getText().toString());

        });
    }






    @Override
    public void showmassage() {
        Toast.makeText(this, "Вы успешно вошли!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showerror() {
        Toast.makeText(this, "Не верный логин или пароль", Toast.LENGTH_SHORT).show();
    }


}
