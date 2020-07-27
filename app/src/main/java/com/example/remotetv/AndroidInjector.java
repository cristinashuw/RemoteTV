package com.example.remotetv;

import dagger.BindsInstance;
import dagger.android.AndroidInjection;
import dagger.android.ContributesAndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.internal.Beta;

/**
 * Performs members-injection for a concrete subtype of a <a
 * href="https://developer.android.com/guide/components/">core Android type</a> (e.g., {@link
 * android.app.Activity} or {@link android.app.Fragment}).
 *
 * <p>Commonly implemented by {@link dagger.Subcomponent}-annotated types whose {@link
 * dagger.Subcomponent.Factory} extends {@link dagger.android.AndroidInjector.Factory}.
 *
 * @param <T> a concrete subtype of a core Android type
 * @see AndroidInjection
 * @see DispatchingAndroidInjector
 * @see ContributesAndroidInjector
 */
@Beta
public interface AndroidInjector<T> {

    /** Injects the members of {@code instance}. */
    void inject(T instance);

    /**
     * Creates {@link dagger.android.AndroidInjector}s for a concrete subtype of a core Android type.
     *
     * @param <T> the concrete type to be injected
     */
    interface Factory<T> {
        /**
         * Creates an {@link dagger.android.AndroidInjector} for {@code instance}. This should be the same instance
         * that will be passed to {@link #inject(Object)}.
         */
        dagger.android.AndroidInjector<T> create(@BindsInstance T instance);
    }

    /**
     * An adapter that lets the common {@link dagger.Subcomponent.Builder} pattern implement {@link
     * dagger.android.AndroidInjector.Factory}.
     *
     * @param <T> the concrete type to be injected
     * @deprecated Prefer {@link dagger.android.AndroidInjector.Factory} now that components can have {@link dagger.Component.Factory
     *     factories} instead of builders
     */
    @Deprecated
    abstract class Builder<T> implements dagger.android.AndroidInjector.Factory<T> {
        @Override
        public final dagger.android.AndroidInjector<T> create(T instance) {
            seedInstance(instance);
            return build();
        }

        /**
         * Provides {@code instance} to be used in the binding graph of the built {@link
         * dagger.android.AndroidInjector}. By default, this is used as a {@link BindsInstance} method, but it may be
         * overridden to provide any modules which need a reference to the activity.
         *
         * <p>This should be the same instance that will be passed to {@link #inject(Object)}.
         */
        @BindsInstance
        public abstract void seedInstance(T instance);

        /** Returns a newly-constructed {@link dagger.android.AndroidInjector}. */
        public abstract dagger.android.AndroidInjector<T> build();
    }
}
