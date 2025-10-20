package calculator;

public class NumberStringParser {
    private final String input;
    private final DelimiterExtractor delimiterExtractor;

    public NumberStringParser(String input) {
        this.input = input;
        this.delimiterExtractor = new DelimiterExtractor(input);
    }

    public String[] parse() {
        String targetString = extractTargetString();
        String delimiterRegex = delimiterExtractor.getDelimiterRegex();

        return targetString.split(delimiterRegex);
    }

    private String extractTargetString() {
        if (delimiterExtractor.getHasCustomDelimiter()) {
            return input.substring(input.indexOf(DelimiterExtractor.CUSTOM_DELIMITER_SUFFIX)
                    + DelimiterExtractor.CUSTOM_DELIMITER_SUFFIX.length());
        }
        return input;
    }
}
