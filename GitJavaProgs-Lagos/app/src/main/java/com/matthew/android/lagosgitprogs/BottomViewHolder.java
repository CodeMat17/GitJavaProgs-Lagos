package com.matthew.android.lagosgitprogs;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Chukwu Matthew on 8/27/2017.
 */

public class BottomViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.item_bottom_progress) ProgressBar bottomProgress;
    @BindView(R.id.item_error_button) Button moreRetryButton;
    private UserClickedListener listener;
    private final String TAG = "BottomViewHolder";

    public BottomViewHolder(View itemView, final UserClickedListener listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.listener = listener;
        setUpViews();
    }

    private void setUpViews() {
        bottomProgress.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor
                (itemView.getContext(), R.color.colorAccent), PorterDuff.Mode.SRC_IN);

        moreRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.GONE);
                listener.onLoadMoreClicked();
            }
        });
    }

    public void processViews(UserAdapter.Status status) {
        if (status == UserAdapter.Status.FAILED) {
            bottomProgress.setVisibility(View.GONE);
            moreRetryButton.setVisibility(View.VISIBLE);

        } else if (status == UserAdapter.Status.SUCCESS) {
            bottomProgress.setVisibility(View.GONE);

        } else if (status == UserAdapter.Status.PRE_REQUEST) {
            bottomProgress.setVisibility(View.VISIBLE);
        }
    }
}
