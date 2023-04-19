package com.caihong.designpattern.state;

public class Screen {
    private int clickCount = 0;
    private ScreenState current;
    private ScreenState normal;
    private ScreenState larger;
    private ScreenState largest;

    public Screen() {
        normal = new NormalState();
        larger = new LargerState();
        largest = new LargestState();
        current = normal;
    }

    public void setState(ScreenState state) {
        current = state;
    }

    public void onClick() {
        clickCount++;
        int i = clickCount % 3;
        if (i == 0) {
            setState(normal);
        } else if (i == 1) {
            setState(larger);
        } else {
            setState(largest);
        }
        current.display();
    }
}
