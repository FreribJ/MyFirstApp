package com.example.myapplication5.Calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication5.R;

public class calculatorResultFragment extends Fragment {

    private static final String ARG_CONTENT = "content";
    private String content;

    public static calculatorResultFragment newInstance(String content) {
        calculatorResultFragment fragment = new calculatorResultFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.content = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calculator_result_fragment, container, false);
        TextView textView = view.findViewById(R.id.calculatedResult);
        textView.setText(this.content);
        return view;
    }


}
