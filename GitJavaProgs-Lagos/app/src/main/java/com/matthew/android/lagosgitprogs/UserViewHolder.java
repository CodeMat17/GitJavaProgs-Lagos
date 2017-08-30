package com.matthew.android.lagosgitprogs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chukwu Matthew on 8/26/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.user_avatar) ImageView userAvatar;
    @BindView(R.id.user_name) TextView userName;
    @BindView(R.id.item_root) LinearLayout rootLayout;

    private UserClickedListener clickedListener;

    public UserViewHolder(final View View,UserClickedListener clickedListener) {
        super(View);
        ButterKnife.bind(this, View);
        this.clickedListener = clickedListener;
    }

    public void bindModel(final UserItem userItem) {
        MyGlide.load(itemView.getContext(), userAvatar, userItem.getAvatarUrl(), null);

        userName.setText(userItem.getUsername());
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedListener.onUserClicked(userItem.getUserObject());
            }
        });
    }
}
