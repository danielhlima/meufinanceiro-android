package br.com.danielhenriquelima.domain.interactor;

public interface UseCase<P> {

    interface Callback{
        void onSuccess();
        void onError(Throwable throwable);
    }

    void execute(P parameter, Callback callback);
}
