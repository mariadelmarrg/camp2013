package uk.zuehlke.blog.domain;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class Post {

	@Id
	private ObjectId id;
	private String title;
	private String content;
	private String tags;
	private Date createdDate = new Date();
	@Transient
	private List<String> listOfTags;
	@Transient
	private String createdDateAsString;

	public String getId() {
		return id.toString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public List<String> getListOfTags(){
		return tags != null ? Arrays.asList(tags.split(" ")) : Collections.<String>emptyList();		
	}
	
	public String getCreatedDateAsString() {
		return (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format(createdDate);
	}
	
	public Date getCreatedDate(){
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", tags=" + tags + "]";
	}
}
