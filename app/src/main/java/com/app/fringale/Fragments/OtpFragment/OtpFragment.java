package com.app.fringale.Fragments.OtpFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.app.fringale.R;
import com.app.fringale.Utils.GenericTextWatcher;
import com.app.fringale.databinding.FragmentOtpBinding;

public class OtpFragment extends Fragment implements View.OnClickListener {
    private FragmentOtpBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOtpBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        EditText[] edit = {binding.otpET1, binding.otpET2, binding.otpET3, binding.otpET4};

        binding.otpET1.addTextChangedListener(new GenericTextWatcher(binding.otpET1, edit));
        binding.otpET2.addTextChangedListener(new GenericTextWatcher(binding.otpET2, edit));
        binding.otpET3.addTextChangedListener(new GenericTextWatcher(binding.otpET3, edit));
        binding.otpET4.addTextChangedListener(new GenericTextWatcher(binding.otpET4, edit));
        listeners();
        return view;
    }

    private void listeners() {
        binding.btncontinue.setOnClickListener(this);
        binding.imgbackarrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == binding.btncontinue) {
            Navigation.findNavController(getActivity(), R.id.fragmentContainerView3).navigate(R.id.action_otpFragment_to_personalDetailFragment);
        }else  if (view==binding.imgbackarrow){
            Navigation.findNavController(getActivity(), R.id.fragmentContainerView3).navigate(R.id.action_otpFragment_to_loginFragment);

        }
    }
}