package com.example.shoppinglist;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    private View rootview;
    TableLayout tbl;
    static List<String> lst = new LinkedList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_2, container, false);
        initview();
        Toast.makeText(requireActivity(), "hhhhhh", Toast.LENGTH_SHORT).show();
        return rootview;
    }

    private void initview() {
        Bundle bundle = getArguments();
        tbl = rootview.findViewById(R.id.tbl);
        if(bundle != null){
            String productname = bundle.getString("productName");

            lst.add(productname);
            for(int i =0; i<lst.size(); i++){
                TableRow tblr = new TableRow(requireActivity());

                TextView tvProduct = new TextView(requireActivity());
                tvProduct.setText(lst.get(i).toString());
                tvProduct.setTextColor(getResources().getColor(R.color.black));
                CheckBox checkBox = new CheckBox(requireActivity());
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(checkBox.isChecked()){
                            tvProduct.setTextColor(Color.BLUE);
                        }
                        else{
                            tvProduct.setTextColor(Color.BLACK);
                        }
                    }
                });
                tblr.addView(tvProduct);
                tblr.addView(checkBox);
                tbl.addView(tblr);
            }
        }
    }
}