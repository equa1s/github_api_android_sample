package com.android.githubretrofit.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.githubretrofit.R;
import com.android.githubretrofit.database.model.User;
import com.android.githubretrofit.ui.RecyclerViewClickListener;
import com.android.githubretrofit.util.NumberUtils;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * {@author equa1s}
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserCardHolder> {

    private List<User> mData;
    private LayoutInflater mLayoutInflater;
    private Context context;
    private RecyclerViewClickListener listener;

    public static class UserCardHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.git_hub_user_id) public TextView id;
        @BindView(R.id.git_hub_user_name) public TextView name;
        @BindView(R.id.git_hub_user_email) public TextView email;
        @BindView(R.id.git_hub_user_login) public TextView login;
        @BindView(R.id.git_hub_user_avatar) public ImageView avatar;

        public UserCardHolder(final View itemView, final RecyclerViewClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onUserClick(login);
                }
            });
            ButterKnife.bind(this, itemView);
        }

    }

    public UserListAdapter(@NonNull Context context, @NonNull List<User> data, @NonNull RecyclerViewClickListener listener) {
        this.context = context;
        this.mData = data;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @Override
    public UserListAdapter.UserCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;

        if (NumberUtils.isPair(viewType))
            v = mLayoutInflater.inflate(R.layout.github_user_card_left, parent, false);
        else
            v = mLayoutInflater.inflate(R.layout.github_user_card_right, parent, false);

        return new UserCardHolder(v, listener);

    }

    @Override
    public void onBindViewHolder(UserListAdapter.UserCardHolder holder, int position) {

        User user = mData.get(position);

            holder.id.setText(String.valueOf(user.getGithubId()));
            holder.login.setText(user.getLogin());
            holder.email.setText(user.getEmail());
            holder.name.setText(user.getName());

        Glide.with(context).load(user.getAvatarUrl()).into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void swap(List<User> data) {
        if (mData != null) {
            mData.clear();
            mData.addAll(data);
        } else {
            mData = data;
        }
        this.notifyDataSetChanged();
    }

}
