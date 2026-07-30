package tests.ui;

public class SlideData {
    private final String title;
    private final String description;

    public SlideData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitleText() {
        return title;
    }

    public String getImageAlt() {
        return description;
    }
}
