package br.com.danielhenriquelima.domain.interactor;

public interface UseCaseOut<O> {

    interface Callback<O>{
        void onSuccess(O parameter);
        void onError(Throwable throwable);
    }

    void execute(Callback<O> callback);
}
