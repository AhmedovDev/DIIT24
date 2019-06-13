package com.example.diit24.ui.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.diit24.R;
import com.example.diit24.data.global.models.User;

import java.util.List;

public class TaskAdapter  extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<User> users;
    private ItemClickListener itemClickListener;


    public TaskAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(users.get(position));


    }

    @Override
    public int getItemCount() {
        if (users == null)
            return 0;
        return users.size();
    }

    public void setItemClickListener(TaskAdapter.ItemClickListener itemClickListener) {

        this.itemClickListener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder    {

        private TextView project;
        private TextView task;
        private View itemView;

        private ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            project = itemView.findViewById(R.id.project_name);
            task = itemView.findViewById(R.id.task);
        }

        public void setData(User user) {
            project.setText(user.getDate());
            task.setText(user.getFio());
            itemView.setOnClickListener(v -> {

                itemClickListener.click(user);
            });

        }
    }

    public interface ItemClickListener {
        void click(User user);

    }
}