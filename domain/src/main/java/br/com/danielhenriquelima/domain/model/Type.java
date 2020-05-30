package br.com.danielhenriquelima.domain.model;

import br.com.danielhenriquelima.domain.R;

public enum Type {

    CREDIT(R.string.credit),
    DEBIT(R.string.debit);

    private int descriptionCodde;
    Type(int type) { this.descriptionCodde = type; }

    public int getDescription() {
        return descriptionCodde;
    }
}
