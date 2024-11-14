package com.campusdual.UtilsDani;

import com.campusdual.Components.Comment;
import com.campusdual.Components.Post;
import com.campusdual.Components.PostsContent.Content;
import com.campusdual.Components.PostsContent.ImageContent;
import com.campusdual.Components.PostsContent.TextContent;
import com.campusdual.Components.PostsContent.VideoContent;
import com.campusdual.Components.User;

import java.util.List;
import java.util.Random;

import static com.campusdual.Main.usersList;
import static com.campusdual.UtilsDani.MockPlaceholders.*;

public class MockData {
        public static void build(){
        Random random = new Random();

        for (String username : usernames) {
            User user = new User(username);
            int postCount = 2 + random.nextInt(4);

            // Each user creates between 2 and 5 posts
            for (int i = 0; i < postCount; i++) {
                Post post = new Post(generateRandomContent());
                user.createPost(post);
            }

            usersList.put(username, user);
        }

        // MOCK COMMENTS
        for (User commenter : usersList.values()) {
            for (User targetUser : usersList.values()) {
                // Avoid commenting on own posts
                if (!commenter.equals(targetUser)) {
                    List<Post> targetPosts = targetUser.getMyPosts();
                    if (!targetPosts.isEmpty()) {
                        Post targetPost = targetPosts.get(random.nextInt(targetPosts.size()));
                        if (random.nextInt(2) == 1) {
                            String randomComment = randomComments[random.nextInt(randomComments.length)];
                            targetPost.addComment(new Comment(randomComment, commenter)); // Comment action (50% chance)
                        }
                    }
                }
            }
        }
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
        System.out.println("*****************       Mock data generated       ********************");
        System.out.println("**********************************************************************");
        System.out.println("**********************************************************************");
    }

    public static Content generateRandomContent() {
        Random random = new Random();
        int contentType = random.nextInt(3);

        switch (contentType) {
            case 0:
                return new TextContent(generateRandomText());
            case 1:
                return new ImageContent(generateRandomTitle(), generateRandomResolution());
            case 2:
                return new VideoContent(generateRandomTitle(), generateRandomQuality(), generateRandomLength());
            default:
                throw new IllegalStateException("Unexpected content type: " + contentType);
        }
    }

    // Oriented to fill textContents
    public static String generateRandomText() {
        return texts[new Random().nextInt(texts.length)];
    }

    // Oriented to fill image and video titles
    public static String generateRandomTitle() {
        return titles[new Random().nextInt(titles.length)];
    }

    public static String generateRandomResolution() {
        String[] resolutions = { "1080x720", "1920x1080", "1280x720", "640x480" };
        return resolutions[new Random().nextInt(resolutions.length)];
    }

    public static int generateRandomQuality() {
        int[] qualities = { 480, 720, 1080, 1440, 2160 };
        return qualities[new Random().nextInt(qualities.length)];
    }

    public static int generateRandomLength() {
        return 30 + new Random().nextInt(270);  // 30 to 300 seconds
    }
}
