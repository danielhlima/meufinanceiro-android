package br.com.danielhenriquelima.domain.boundary;

public interface BoundaryOut<O> {

    interface Callback<O>{
        void onSuccess(O parameter);
        void onError(Throwable throwable);
    }

    void execute(Callback<O> callback);
}
