package br.com.danielhenriquelima.domain.model;

import br.com.danielhenriquelima.domain.R;

public enum Category {

    SUPERMARKET(R.string.supermarket),
    FUEL(R.string.fuel),
    TRANSPORT(R.string.transport),
    RESTAURANT(R.string.restaurant),
    STUDY(R.string.study),
    CLOTHES(R.string.clothes),
    SHOES(R.string.shoes),
    PHARMACY(R.string.pharmacy),
    GIFTS(R.string.gifts),
    AUTO_MECHANIC(R.string.mechanic),
    DONATIONS(R.string.donation),
    PITSTOPS(R.string.pitstop),
    BAKERY(R.string.bakery),
    TRANSFERS(R.string.transfers),
    PARKING(R.string.parking),
    BOOKS(R.string.books),
    PETS(R.string.pets),
    CAR(R.string.car),
    CONTRUCTION_MATERIALS(R.string.construction),
    PERFUMARY(R.string.perfumary),
    BUTCHERY(R.string.butchery),
    STATIONARY_STORE(R.string.stationary_store),
    DENTIST(R.string.dentist),
    DOCTORS(R.string.doctors),
    ENERGY(R.string.energy),
    WATER(R.string.water),
    INTERNET(R.string.internet),
    TV(R.string.tv),
    MOBILE(R.string.mobile),
    FEES(R.string.fees),
    INVESTMENT(R.string.investment),
    PREVIDENCY(R.string.previdency),
    INSURANCE(R.string.insurance),
    HABITATION(R.string.habitation),
    ENTERTAINMENT(R.string.entertainment),
    STORES(R.string.stores);


    private int descriptionCode;
    Category(int description){
        this.descriptionCode = description;
    }

    public int getDescription() {
        return descriptionCode;
    }
}
