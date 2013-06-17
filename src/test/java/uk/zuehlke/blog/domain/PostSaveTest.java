package uk.zuehlke.blog.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uk.zuehlke.blog.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mongo-context.xml")
public class PostSaveTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	public void readPosts() {
		Iterable<Post> posts = postRepository.findAll();
		for (Post post : posts) {
			System.out.println(post);
		}
	}
	
	@Test
	public void writePost() {
		Post post = new Post();
		post.setTitle("Our first post");
		post.setContent("This is amazing!!!");
		
		postRepository.save(post);
	}
}
