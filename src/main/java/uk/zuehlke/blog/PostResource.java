package uk.zuehlke.blog;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import uk.zuehlke.blog.domain.Post;

import com.google.common.base.Strings;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class PostResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostResource.class);

	@Autowired
	private PostRepository postRepository;
	
	@GET
	public Iterable<Post> getAllPosts(@QueryParam("q") String query){
		LOGGER.info("Retrieve posts based on query: " + query + ".");
		Sort sort = new Sort(Sort.Direction.DESC, "createdDate");
		if (Strings.isNullOrEmpty(query)) {
			return postRepository.findAll(sort);
		} else {
			return postRepository.findPostsByQuery(query, sort);
		}
	}
	
	@GET @Path("/{postId}")
	public Post getPost(@PathParam("postId") String id) {
		Post post = postRepository.findOne(id);
		if (post != null) return post;
		throw new WebApplicationException(Response.Status.NOT_FOUND);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createPost(Post newPost) {
		LOGGER.info(String.format("Creating post with title %s.", newPost.getTitle()));
		postRepository.save(newPost);
	}
	
	@DELETE
	@Path("/{postId}")
	public void deletePost(@PathParam("postId") String postToDelete) {
		LOGGER.info(String.format("Deleting post with id %s.", postToDelete));
		postRepository.delete(postToDelete);
	}
	
}
