package ute.application.baemax.dao;

public class Food {
    private  int resourceId;
    private String title ;
    public Food(int resourceId, String title) {
        this.resourceId = resourceId;
        this.title = title;
    }
    public int getResourceId() {
        return resourceId;
    }
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
