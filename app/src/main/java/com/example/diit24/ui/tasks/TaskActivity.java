package com.example.diit24.ui.tasks;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.diit24.App;
import com.example.diit24.R;
import com.example.diit24.data.global.models.User;
import com.example.diit24.mvp.tasks.TaskPresenter;
import com.example.diit24.mvp.tasks.TaskView;
import com.example.diit24.ui.watch.WatchActivity;

import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity implements TaskView {
    private TaskPresenter presenter;

    private RecyclerView recyclerView;
    private List<User> posts = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);


        presenter = new TaskPresenter(App.dataManager);
        presenter.attachView(this);
        presenter.getUsersShow();


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }



    @Override
    public void showUsers(List<User> users) {
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TaskAdapter adapter = new TaskAdapter(users); // t
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(user -> {
           intent();
        });

    }

    @Override
    public void showmasage() {
        Toast.makeText(TaskActivity.
                this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
    }

    private void intent () {
         Intent intent = new Intent(TaskActivity.this, WatchActivity.class);
         startActivity(intent);

    }
}