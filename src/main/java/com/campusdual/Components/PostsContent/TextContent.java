package com.campusdual.Components.PostsContent;

public class TextContent extends Content{
    private final String text;

    public TextContent(String text) {
        this.text = text;
    }

    @Override
    void getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ TEXT ]").append(" ");
        sb.append(this.text);

        System.out.println(sb);
    }
}
