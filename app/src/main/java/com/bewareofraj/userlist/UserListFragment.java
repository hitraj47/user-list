package com.bewareofraj.userlist;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends Fragment {

    // test string array
    private String[] items = {"User 1", "User 2", "User 3", "User 4", "User 5"};

    private ArrayAdapter<String> adapter;


    public UserListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_list, container, false);

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_user_list, items);
        ListView listView = (ListView) rootView.findViewById(R.id.user_list);

        return rootView;
    }


}
