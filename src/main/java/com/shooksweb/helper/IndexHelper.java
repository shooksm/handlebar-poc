package com.shooksweb.helper;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Rob Whitaker on 1/14/2015.
 */

public enum IndexHelper implements Helper<Object> {
    /**
     * You can use the increaseByOne helper to return the input value plus 1
     *
     * <tr class="{{increaseByOne value}}">
     *
     * If value is 2, the output will be 3.
     *
     */
    increaseByOne {
        @Override
        public CharSequence apply(Number value, Options options) {
            int intVal = value.intValue();
            intVal++;
            value = ((Number) intVal);
            return options.param(0, value.toString());
        }
    };

    @Override
    public CharSequence apply(final Object context, final Options options)
            throws IOException {
        if (context instanceof Number) {
            return apply((Number) context, options);
        }
        return null;
    }

    protected abstract CharSequence apply(final Number value,
                                          final Options options);

    public void registerHelper(final Handlebars handlebars) {
        notNull(handlebars, "The handlebars is required.");
        handlebars.registerHelper(this.name(), this);
    }

    public static void register(final Handlebars handlebars) {
        notNull(handlebars, "A handlebars object is required.");
        IndexHelper[] helpers = values();
        for (IndexHelper helper : helpers) {
            helper.registerHelper(handlebars);
        }
    }
}
