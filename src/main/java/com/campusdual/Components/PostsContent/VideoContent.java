package com.campusdual.Components.PostsContent;

public class VideoContent extends Content{
    private final String title;
    private final int quality;
    private final int lengthSeconds;

    public VideoContent(String title, int resolution, int lengthSeconds) {
        this.title = title;
        this.quality = resolution;
        this.lengthSeconds = lengthSeconds;
    }

    @Override
    void getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ VIDEO ]").append(" ");
        sb.append(this.title).append(" ");
        sb.append("(").append(this.quality).append("p, ");
        sb.append(this.lengthSeconds).append("secs").append(")");
        // ¿? Función que procese y pase a horas los secs

        System.out.println(sb);
    }
}
