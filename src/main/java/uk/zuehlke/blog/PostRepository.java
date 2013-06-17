package uk.zuehlke.blog;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import uk.zuehlke.blog.domain.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, String>{

	@Query("{$or: [{content: {$regex:?0,$options:'i'}}, {tags: {$regex:?0, $options:'i'}}, {title: {$regex:?0,$options:'i'}}]}")
	Iterable<Post> findPostsByQuery(String query, Sort sort);
	
}
