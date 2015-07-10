package com.bewareofraj.userlist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bewareofraj.userlist.users.UserListFragment;
import com.bewareofraj.userlist.util.MyApplication;

import org.json.JSONArray;
import org.json.JSONException;


public class MainActivity extends ActionBarActivity implements MainFragment.Callback {

    private static final String BUNDLE_JSON_ARRAY = "json_array";

    private JSONArray userArray;
    private UserListFragment userListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        } /*else {
            if (savedInstanceState.getSerializable(BUNDLE_JSON_ARRAY) != null) {
                try {
                    userArray = new JSONArray(savedInstanceState.getSerializable(BUNDLE_JSON_ARRAY));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }*/
        userListFragment = new UserListFragment();

    }
/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (userArray != null) {
            outState.putSerializable(BUNDLE_JSON_ARRAY, userArray.toString());
        }
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            getUserList();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method to get list of users
     */
    public void getUserList() {
        String url = "http://jsonplaceholder.typicode.com/users";
        final String requestTag = "get_user_list";

        Response.Listener<JSONArray> responseListener = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                userArray = response;
                displayListFragment();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(requestTag, "Error getting user list: " + error.getMessage());
            }
        };

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, responseListener, errorListener);
        MyApplication.getInstance().addToRequestQueue(request, requestTag);
    }

    /**
     * Display the list fragment showing the list of users
     */
    public void displayListFragment() {
        userListFragment.updateData();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, userListFragment).commit();
    }

    /**
     * This method is called when the "Get List" button is clicked in the Main fragment
     * @param view
     */
    @Override
    public void onRefreshButtonClicked(View view) {
        getUserList();
    }

    public JSONArray getJsonArray() {
        return userArray;
    }

}
