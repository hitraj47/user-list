package com.bewareofraj.userlist.users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bewareofraj.userlist.R;
import com.bewareofraj.userlist.util.JsonAdapter;

import org.json.JSONArray;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    private JSONArray array;

    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_list, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.user_list);
        JsonAdapter adapter = new JsonAdapter(getActivity(), array);
        listView.setAdapter(adapter);

        return rootView;
    }


}
