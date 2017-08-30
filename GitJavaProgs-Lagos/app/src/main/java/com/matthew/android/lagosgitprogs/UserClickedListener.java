package com.matthew.android.lagosgitprogs;

/**
 * Created by Chukwu Matthew on 8/25/2017.
 */

public interface UserClickedListener {
    //Handles clicks on the gadget and  items of GadgetFragment, UserListFragment, CatsFragment and DetailsFragment
    void onUserClicked(String Object);
    void onLoadMoreClicked();
}