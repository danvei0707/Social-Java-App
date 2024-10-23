package com.campusdual.Components;

import com.campusdual.Components.PostsContent.Content;


import java.util.*;

public class Post {
    // Fecha, lista de comentarios, contenido
    private Date publishDate;
    private Stack<Comment> comments;
    private Content content;
}
