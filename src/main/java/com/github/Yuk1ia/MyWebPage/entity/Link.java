package  com.github.Yuk1ia.MyWebPage.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "links")
public class Link{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String url;
    private String description;
    private String category;

    public Link(long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.category = category;
        this.description = description;
    }

    public Link() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

