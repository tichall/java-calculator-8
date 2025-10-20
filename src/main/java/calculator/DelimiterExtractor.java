package calculator;

public class DelimiterExtractor {
    public static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    private final boolean hasCustomDelimiter;
    private final String customDelimiter;

    public DelimiterExtractor(String input) {
        this.hasCustomDelimiter = input.startsWith(CUSTOM_DELIMITER_PREFIX);
        this.customDelimiter = extractCustomDelimiter(input);
    }

    public boolean getHasCustomDelimiter() {
        return this.hasCustomDelimiter;
    }

    public String getDelimiterRegex() {
        return hasCustomDelimiter ? customDelimiter : DEFAULT_DELIMITER_REGEX;
    }

    private String extractCustomDelimiter(String input) {
        if (hasCustomDelimiter) {
            int lastIndexOfCustomDelimiter = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

            if (lastIndexOfCustomDelimiter == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정이 유효하지 않습니다.");
            }

            String delimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), lastIndexOfCustomDelimiter);
            validateDelimiterIsNotNumeric(delimiter);
            return delimiter;
        }
        return "";
    }

    private void validateDelimiterIsNotNumeric(String delimiter) {
        try {
            Double.parseDouble(delimiter);
            throw new IllegalArgumentException("커스텀 지정자로 숫자를 사용할 수 없습니다.");
        } catch (NumberFormatException ignore) {

        }
    }
}
