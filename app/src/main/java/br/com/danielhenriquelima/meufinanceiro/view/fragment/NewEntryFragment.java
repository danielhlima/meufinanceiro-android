package br.com.danielhenriquelima.meufinanceiro.view.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import br.com.danielhenriquelima.meufinanceiro.R;


public class NewEntryFragment extends Fragment {

    public NewEntryFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_new_entry, container, false);
    }
}