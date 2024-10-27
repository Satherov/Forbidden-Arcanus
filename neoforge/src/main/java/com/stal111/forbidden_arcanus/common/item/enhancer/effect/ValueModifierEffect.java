package com.stal111.forbidden_arcanus.common.item.enhancer.effect;

/**
 * @author stal111
 * @since 02.03.2024
 */
public interface ValueModifierEffect<T> extends EnhancerEffect {
    T getModifiedValue(T originalValue);
}
