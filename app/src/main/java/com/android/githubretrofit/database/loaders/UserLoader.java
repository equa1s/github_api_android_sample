package com.android.githubretrofit.database.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.android.githubretrofit.database.model.User;
import com.orm.query.Select;

import java.util.Collections;
import java.util.List;

/**
 * {@author equa1s}
 */
public class UserLoader extends AsyncTaskLoader<List<User>> {

    public static final int USER_LOADER_ID = 7;

    public UserLoader(Context context) {
        super(context);
    }

    @Override
    public List<User> loadInBackground() {
        List<User> list = Select.from(User.class).list();
        Collections.reverse(list);
        return list;
    }

}
