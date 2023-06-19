package org.sExample.Pages;

public class HomePage extends BasePage {

    public HomePage() {
        super();
        acceptCookies();
        chooseGender();
    }

    public void searchFor(String keyword) {
        enterSearch(keyword);
        search();
    }


}
