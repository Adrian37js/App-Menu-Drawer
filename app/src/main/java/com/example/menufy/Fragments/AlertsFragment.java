package com.example.menufy.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.menufy.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class AlertsFragment  extends Fragment implements View.OnClickListener, AlertDialog.OnClickListener{


    private FloatingActionButton fab;
    private AlertDialog.Builder builder;
    private Switch aSwitch;
    private TextView textViewTitle;




    public AlertsFragment() {
        // Required empty public constructor
         }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragments_alert, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);

        return view;
    }



    @Override
    public void onClick(View view) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Escoge");

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.fragments_alert, null);

        aSwitch = (Switch) dialogView.findViewById(R.id.switchOption);

        builder.setView(dialogView);

        builder.setPositiveButton("OK", this);

        builder.setNegativeButton("Cancel", this);
        builder.show();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            if (aSwitch.isChecked()) textViewTitle.setText("Alerts enabled"); else textViewTitle.setText("Alerts disabled");
        } else if (which == DialogInterface.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }

}
