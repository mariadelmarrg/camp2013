package uk.zuehlke.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import uk.zuehlke.blog.domain.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mongo-context.xml")
public class PostResourceTest {

	@Autowired
	private PostResource postResource;

	@Test
	public void testGetAllPosts() {
		Iterable<Post> allPosts = postResource.getAllPosts("");
		for (Post post : allPosts) {
			System.out.println(post);
		}
	}
	
	@Test
	public void testGetPostById(){
		Post post = postResource.getPost("51b7514e701070c69930b6fd");
		System.out.println(post.toString());
		
		Assert.notNull(post);
	}
	
	

}
