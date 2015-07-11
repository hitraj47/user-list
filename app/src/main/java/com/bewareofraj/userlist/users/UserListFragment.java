package com.bewareofraj.userlist.users;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.bewareofraj.userlist.MainActivity;
import com.bewareofraj.userlist.R;
import com.bewareofraj.userlist.util.JsonAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * This fragment is responsible for displaying the list of users
 */
public class UserListFragment extends Fragment {

    private static final String BUNDLE_JSON_ARRAY = "json_array";

    private JsonAdapter adapter;

    public UserListFragment() {
        // Required empty public constructor
    }

    /**
     * Used for when the array is updated
     */
    public void updateData() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_list, container, false);

        JSONArray array = null;

        if (savedInstanceState != null) {
            try {
                array = new JSONArray(savedInstanceState.getString(BUNDLE_JSON_ARRAY));
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "Error loading user list", Toast.LENGTH_LONG).show();
            }
        } else {
            array = ((MainActivity) getActivity()).getJsonArray();
        }

        ListView listView = (ListView) rootView.findViewById(R.id.user_list);
        adapter = new JsonAdapter(getActivity(), array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JSONObject object = adapter.getItem(position);
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                intent.putExtra(UserInfoActivity.EXTRA_JSON_OBJECT, object.toString());
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(BUNDLE_JSON_ARRAY, adapter.getJsonArray().toString());
    }


}
