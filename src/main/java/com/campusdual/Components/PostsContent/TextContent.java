package com.campusdual.Components.PostsContent;

public class TextContent extends Content{
    private final String text;

    public TextContent(String text) {
        this.text = text;
    }

    @Override
    public void getDetails() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ TEXT  ]").append(" ");
        sb.append(this.text);

        System.out.print(sb);
    }
}
