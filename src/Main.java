public class Main {

    public static void main(String[] args) {

    }

    public static Label verificationText(TextAnalyzer[] textAnalyzers, String text) {
        for (TextAnalyzer textAnalyzer : textAnalyzers) {
            if (textAnalyzer.processText(text) != Label.OK)
                return textAnalyzer.processText(text);
        }
        return Label.OK;
    }

}

public interface TextAnalyzer {
    Label processText(String text);
}

public enum Label {
    SPAM, NEGATIVE_TEXT, TOO_LONG, OK
}

public abstract class AbstractKeywordAnalyzer implements TextAnalyzer {

    public abstract String[] getKeywords();

    public abstract Label getLabel();

    public Label processText(String text) {
        String[] keywords = getKeywords();
        for (String s : keywords) {
            if (text.contains(s))
                return getLabel();
        }
        return Label.OK;

    }

}

public class NegativeTextAnalyzer extends AbstractKeywordAnalyzer {

    private String[] analyzerKey = {":(", "=(", ":|"};

    @Override
    public String[] getKeywords() {
        return analyzerKey;
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}

public class SpamAnalyzer extends AbstractKeywordAnalyzer {

    private String[] analyzerKey;

    public SpamAnalyzer(String[] analyzerKey) {
        this.analyzerKey = analyzerKey;
    }

    @Override
    public String[] getKeywords() {
        return analyzerKey;
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
}

public class TooLongTextAnalyzer implements TextAnalyzer {

    private int length;

    public TooLongTextAnalyzer(int length) {
        this.length = length;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > length)
            return Label.TOO_LONG;
        else
            return Label.OK;
    }
}
