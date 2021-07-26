package xianzhan.id.pojo.entity;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
public class UserIdGen {

    private Long id;
    private Long startId;
    private Long endId;
    private Long used;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStartId() {
        return startId;
    }

    public void setStartId(Long startId) {
        this.startId = startId;
    }

    public Long getEndId() {
        return endId;
    }

    public void setEndId(Long endId) {
        this.endId = endId;
    }

    public Long getUsed() {
        return used;
    }

    public void setUsed(Long used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "UserIdGen{" +
               "id=" + id +
               ", startId=" + startId +
               ", endId=" + endId +
               ", used=" + used +
               '}';
    }
}
