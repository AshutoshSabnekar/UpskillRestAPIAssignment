package RestAPISample;

import java.util.List;

public class rootBody {
	
	private int id;

    private category category;

    private String name;

    private String status;
    
    private List<String> photoURL;
    
    private List<RestAPISample.category> Tags;

	public List<String> getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(List<String> photoURL) {
		this.photoURL = photoURL;
	}
	
	public void setTags(List<category> Tags) {
		this.Tags = (List<category>) Tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public category getCategory() {
		return category;
	}
	
	public List<category> getTags() {
		return Tags;
	}

	public void setCategory(category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
 
}
