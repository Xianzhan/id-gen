package xianzhan.id.entity;

/**
 * common_config
 *
 * @author xianzhan
 * @since 2020-07-15
 */
public class CommonConfig {

    private Long   id;
    private String category;
    private String key;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CommonConfig{" +
               "id=" + id +
               ", category='" + category + '\'' +
               ", key='" + key + '\'' +
               ", value='" + value + '\'' +
               '}';
    }
}
