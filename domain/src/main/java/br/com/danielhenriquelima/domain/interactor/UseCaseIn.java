package br.com.danielhenriquelima.domain.interactor;

public interface UseCaseIn<I> {

    interface Callback{
        void onSuccess();
        void onError(Throwable throwable);
    }

    void execute(I parameter, Callback callback);
}
