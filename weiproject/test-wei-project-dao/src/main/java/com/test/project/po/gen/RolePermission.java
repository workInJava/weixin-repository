package com.test.project.po.gen;

import java.io.Serializable;
import java.util.Date;

public class RolePermission implements Serializable {
    private String rolePermissionId;

    private String permissionId;

    private String roleId;

    private Date createTime;

    private Date updateTimr;

    private static final long serialVersionUID = 1L;

    public String getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(String rolePermissionId) {
        this.rolePermissionId = rolePermissionId == null ? null : rolePermissionId.trim();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTimr() {
        return updateTimr;
    }

    public void setUpdateTimr(Date updateTimr) {
        this.updateTimr = updateTimr;
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
        RolePermission other = (RolePermission) that;
        return (this.getRolePermissionId() == null ? other.getRolePermissionId() == null : this.getRolePermissionId().equals(other.getRolePermissionId()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTimr() == null ? other.getUpdateTimr() == null : this.getUpdateTimr().equals(other.getUpdateTimr()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRolePermissionId() == null) ? 0 : getRolePermissionId().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTimr() == null) ? 0 : getUpdateTimr().hashCode());
        return result;
    }
}