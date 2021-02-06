package com.example.menufy.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.example.menufy.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EmailFragment extends Fragment implements View.OnClickListener, DialogInterface.OnClickListener {


    private TextView textViewTitle;
    private FloatingActionButton fab;

    private AlertDialog.Builder builder;
    private EditText editTextMail;

    public EmailFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragments_email, container, false);

        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        textViewTitle = (TextView) view.findViewById(R.id.textViewTitle);

        return view;
    }


    @Override
    public void onClick(View v) {
        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("E-MAIL");
        builder.setMessage("Escribe tu email");

        editTextMail = new EditText(getContext());
        editTextMail.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        builder.setView(editTextMail);

        builder.setPositiveButton("OK", this);
        builder.setNegativeButton("Cancel", this);
        builder.show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            String email = editTextMail.getText().toString();
            if (!email.isEmpty()) textViewTitle.setText(email);
        } else if (which == DialogInterface.BUTTON_NEGATIVE){
            dialog.cancel();
        }
    }
}
