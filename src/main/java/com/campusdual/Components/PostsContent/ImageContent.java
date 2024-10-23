package com.campusdual.Components.PostsContent;

public class ImageContent extends Content{
    private final String title;
    private final String resolution;

    public ImageContent(String title, String resolution) {
        this.title = title;
        this.resolution = resolution;
    }

    @Override
    public void getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ IMAGE ]").append(" ");
        sb.append(this.title).append(" ");
        sb.append("(").append(this.resolution).append(")");

        System.out.println(sb);
    }
}
