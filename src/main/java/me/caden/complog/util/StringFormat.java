package me.caden.complog.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <b><a href=https://github.com/CadenCCC>Caden</a></b>
 * @since 1.0.0
 */
public class StringFormat {
    private String originalString;
    private String regex;
    private Object[] inputs;

    public StringFormat setRegex(String regex) {
        this.regex = regex;
        return this;
    }

    public StringFormat setInputs(Object[] inputs) {
        this.inputs = inputs;
        return this;
    }

    public StringFormat setOriginalString(String originalString) {
        this.originalString = originalString;
        return this;
    }

    public String format() {
        if (regex == null || originalString == null) {
            throw new IllegalArgumentException("regex or original string is null");
        }

        Pattern pattern = Pattern.compile(Pattern.quote(regex));
        Matcher matcher = pattern.matcher(originalString);

        StringBuilder result = new StringBuilder();

        int i = 0;
        while (matcher.find()) {
            if (i < inputs.length) {
                matcher.appendReplacement(result, Matcher.quoteReplacement(String.valueOf(inputs[i++])));
            } else {
                matcher.appendReplacement(result, "");
            }
        }

        matcher.appendTail(result);
        return result.toString();
    }
}