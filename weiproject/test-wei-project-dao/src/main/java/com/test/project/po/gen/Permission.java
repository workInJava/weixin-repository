package com.test.project.po.gen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Permission implements Serializable {
    private String permissionId;

    private String permissionName;

    private String url;

    private Date createTime;

    private Date updateTime;

    private String permissionDecription;

    private BigDecimal permissionOrder;

    private static final long serialVersionUID = 1L;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public String getPermissionDecription() {
        return permissionDecription;
    }

    public void setPermissionDecription(String permissionDecription) {
        this.permissionDecription = permissionDecription == null ? null : permissionDecription.trim();
    }

    public BigDecimal getPermissionOrder() {
        return permissionOrder;
    }

    public void setPermissionOrder(BigDecimal permissionOrder) {
        this.permissionOrder = permissionOrder;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()))
            && (this.getPermissionName() == null ? other.getPermissionName() == null : this.getPermissionName().equals(other.getPermissionName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPermissionDecription() == null ? other.getPermissionDecription() == null : this.getPermissionDecription().equals(other.getPermissionDecription()))
            && (this.getPermissionOrder() == null ? other.getPermissionOrder() == null : this.getPermissionOrder().equals(other.getPermissionOrder()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        result = prime * result + ((getPermissionName() == null) ? 0 : getPermissionName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPermissionDecription() == null) ? 0 : getPermissionDecription().hashCode());
        result = prime * result + ((getPermissionOrder() == null) ? 0 : getPermissionOrder().hashCode());
        return result;
    }
}