package com.bewareofraj.userlist;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bewareofraj.userlist.users.UserListFragment;
import com.bewareofraj.userlist.util.MyApplication;

import org.json.JSONArray;

/**
 * The main screen
 */
public class MainActivity extends ActionBarActivity implements MainFragment.Callback {

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
        }
    }

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
     * Retrieve the list of users
     */
    public void getUserList() {
        String url = "http://jsonplaceholder.typicode.com/users";
        final String requestTag = "get_user_list";

        // show progress dialog
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage(getString(R.string.dialog_retrieving_info));
        dialog.setCancelable(false);
        dialog.show();

        Response.Listener<JSONArray> responseListener = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                dialog.dismiss();
                userArray = response;
                displayListFragment();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e(requestTag, "Error getting user list: " + error.getMessage());
                dialog.dismiss();
                Toast.makeText(getApplicationContext(), "Error retrieving information", Toast.LENGTH_LONG).show();
            }
        };

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, responseListener, errorListener);
        MyApplication.getInstance().addToRequestQueue(request, requestTag);
    }

    /**
     * Display the list fragment showing the list of users
     */
    public void displayListFragment() {
        if (userListFragment == null) {
            userListFragment = new UserListFragment();
        }
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

    /**
     * Return the json array of users
     * @return
     */
    public JSONArray getJsonArray() {
        return userArray;
    }

}
