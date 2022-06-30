package com.example.tugassensorgenap2022akbif_310119085;
//10119085,Arif Abdan Syakur,IF-3
public class ScreenItem {
    String screen_title, screen_desc, screen_swipe;

    public ScreenItem(String screen_title, String screen_desc, String screen_swipe) {
        this.screen_title = screen_title;
        this.screen_desc = screen_desc;
        this.screen_swipe = screen_swipe;
    }

    public void setScreen_title(String screen_title) {
        this.screen_title = screen_title;
    }

    public void setScreen_desc(String screen_desc) {
        this.screen_desc = screen_desc;
    }

    public void setScreen_swipe(String screen_swipe) {
        this.screen_swipe = screen_swipe;
    }

    public String getScreen_title() {
        return screen_title;
    }

    public String getScreen_desc() {
        return screen_desc;
    }

    public String getScreen_swipe() {
        return screen_swipe;
    }
}
