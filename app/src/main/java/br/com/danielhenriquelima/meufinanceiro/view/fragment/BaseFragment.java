package br.com.danielhenriquelima.meufinanceiro.view.fragment;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    abstract public void onSuccess();
    abstract public void onError(Throwable t);
}
