package com.bewareofraj.userlist.users;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bewareofraj.userlist.R;

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

    private JSONObject userObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        try {
            userObject = new JSONObject(getIntent().getStringExtra(EXTRA_JSON_OBJECT));
            populateUi(userObject);
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

    private void populateUi(JSONObject object) throws JSONException {
        TextView txtName = (TextView) findViewById(R.id.txt_name);
        txtName.setText(object.getString("name"));

        TextView txtId = (TextView) findViewById(R.id.txt_id_placeholder);
        txtId.setText(object.getString("id"));

        TextView txtUsername = (TextView) findViewById(R.id.txt_username);
        txtUsername.setText(object.getString("username"));

        TextView txtEmail = (TextView) findViewById(R.id.txt_email);
        txtEmail.setText(object.getString("email"));

        JSONObject addressObject = object.getJSONObject("address");

        TextView txtStreet = (TextView) findViewById(R.id.txt_street);
        txtStreet.setText(addressObject.getString("street"));

        TextView txtSuite = (TextView) findViewById(R.id.txt_suite);
        txtSuite.setText(addressObject.getString("suite"));

        TextView txtCityZip = (TextView) findViewById(R.id.txt_cityzip);
        String cityZip = addressObject.getString("city") + ", " + addressObject.getString("zipcode");
        txtCityZip.setText(cityZip);

        JSONObject geoObject = addressObject.getJSONObject("geo");

        TextView txtLat = (TextView) findViewById(R.id.txt_lat);
        txtLat.setText(geoObject.getString("lat"));

        TextView txtLng = (TextView) findViewById(R.id.txt_lng);
        txtLng.setText(geoObject.getString("lng"));

        TextView txtPhone = (TextView) findViewById(R.id.txt_phone);
        txtPhone.setText(object.getString("phone"));

        TextView txtWebsite = (TextView) findViewById(R.id.txt_website);
        txtWebsite.setText(object.getString("website"));

        JSONObject companyObject = object.getJSONObject("company");

        TextView txtCompanyName = (TextView) findViewById(R.id.txt_company_name);
        txtCompanyName.setText(companyObject.getString("name"));

        TextView txtCatchphrase = (TextView) findViewById(R.id.txt_catchphrase);
        txtCatchphrase.setText(companyObject.getString("catchPhrase"));

        TextView txtBs = (TextView) findViewById(R.id.txt_bs);
        txtBs.setText(companyObject.getString("bs"));
    }

}
