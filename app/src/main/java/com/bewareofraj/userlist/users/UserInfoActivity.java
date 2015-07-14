package com.bewareofraj.userlist.users;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bewareofraj.userlist.R;
import com.bewareofraj.userlist.users.objects.User;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * This activity displays the selected user info
 */
public class UserInfoActivity extends ActionBarActivity {

    /**
     * The intent extra key to get the json object string
     */
    public static final String EXTRA_JSON_OBJECT = "json_object";

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        try {
            user = new User(new JSONObject(getIntent().getStringExtra(EXTRA_JSON_OBJECT)));
            populateUi(user);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error loading user info", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // make the up button do the same as back button
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void populateUi(User user) {
        TextView txtName = (TextView) findViewById(R.id.txt_name);
        txtName.setText(user.getName());

        TextView txtId = (TextView) findViewById(R.id.txt_id_placeholder);
        txtId.setText(Integer.toString(user.getId()));

        TextView txtUsername = (TextView) findViewById(R.id.txt_username);
        txtUsername.setText(user.getUsername());

        TextView txtEmail = (TextView) findViewById(R.id.txt_email);
        txtEmail.setText(user.getEmail());

        TextView txtStreet = (TextView) findViewById(R.id.txt_street);
        txtStreet.setText(user.getAddressStreet());

        TextView txtSuite = (TextView) findViewById(R.id.txt_suite);
        txtSuite.setText(user.getAddressSuite());

        TextView txtCityZip = (TextView) findViewById(R.id.txt_cityzip);
        String cityZip = user.getAddressCity() + ", " + user.getAddressZipcode();
        txtCityZip.setText(cityZip);

        TextView txtLat = (TextView) findViewById(R.id.txt_lat);
        txtLat.setText(user.getGeoLat());

        TextView txtLng = (TextView) findViewById(R.id.txt_lng);
        txtLng.setText(user.getGeoLng());

        TextView txtPhone = (TextView) findViewById(R.id.txt_phone);
        txtPhone.setText(user.getPhone());

        TextView txtWebsite = (TextView) findViewById(R.id.txt_website);
        txtWebsite.setText(user.getWebsite());

        TextView txtCompanyName = (TextView) findViewById(R.id.txt_company_name);
        txtCompanyName.setText(user.getCompanyName());

        TextView txtCatchphrase = (TextView) findViewById(R.id.txt_catchphrase);
        txtCatchphrase.setText(user.getCompanyCatchphrase());

        TextView txtBs = (TextView) findViewById(R.id.txt_bs);
        txtBs.setText(user.getCompanyBs());
    }

}
