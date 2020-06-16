package br.com.danielhenriquelima.meufinanceiro.view;

import br.com.danielhenriquelima.domain.entity.Entry;

public interface EntryView {
    void createEntry(Entry entry);
    void onSuccess();
    void onError(Throwable throwable);
}
