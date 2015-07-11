package com.bewareofraj.userlist.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bewareofraj.userlist.R;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Adapter used to display a json array in a listview
 */
public class JsonAdapter extends BaseAdapter implements ListAdapter {

    private Activity activity;
    private JSONArray array;

    /**
     * Constructor
     * @param activity
     * @param array
     */
    public JsonAdapter(Activity activity, JSONArray array) {
        this.activity = activity;
        this.array = array;
    }

    @Override
    public int getCount() {
        if (array == null) {
            return 0;
        } else {
            return array.length();
        }
    }

    @Override
    public JSONObject getItem(int position) {
        if (array == null) {
            return null;
        } else {
            return array.optJSONObject(position);
        }
    }

    @Override
    public long getItemId(int position) {
        JSONObject object = getItem(position);

        return object.optLong("id");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.fragment_user_list_item, null);
        }

        TextView txtUserName = (TextView) convertView.findViewById(R.id.user_name);
        JSONObject object = getItem(position);
        if (object != null) {
            String name = object.optString("name");
            txtUserName.setText(name);
        }

        return convertView;
    }

    /**
     * Return the json array associated with the adapter
     * @return
     */
    public JSONArray getJsonArray() {
        return array;
    }
}
