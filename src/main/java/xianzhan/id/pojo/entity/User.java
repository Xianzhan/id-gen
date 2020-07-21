package xianzhan.id.pojo.entity;

import java.util.Date;

/**
 * @author xianzhan
 * @since 2020-07-15
 */
public class User {

    private Long id;
    private Long userId;
    private Date createTime;
    private Date updateTime;

    // 省略其它字段数据, 如手机号等个人信息在本项目非关键字段

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", userId=" + userId +
               ", createTime=" + createTime +
               ", updateTime=" + updateTime +
               '}';
    }
}
