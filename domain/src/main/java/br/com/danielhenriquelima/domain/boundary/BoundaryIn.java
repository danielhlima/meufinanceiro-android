package br.com.danielhenriquelima.domain.boundary;

public interface BoundaryIn<I> {

    interface Callback{
        void onSuccess();
        void onError(Throwable throwable);
    }

    void execute(I parameter, Callback callback);
}
