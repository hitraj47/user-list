package com.bewareofraj.userlist.users;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.bewareofraj.userlist.R;

import org.json.JSONObject;

public class UserInfoActivity extends ActionBarActivity {

    public static final String EXTRA_JSON_OBJECT = "json_object";

    private JSONObject userObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }

}
