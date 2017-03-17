package com.wxs.model;

import javax.persistence.*;

@Table(name = "sys_user_roles")
public class SysUserRoles {
    @Column(name = "sys_user_id")
    private Long sysUserId;

    @Column(name = "roles_id")
    private Long rolesId;

    /**
     * @return sys_user_id
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * @param sysUserId
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * @return roles_id
     */
    public Long getRolesId() {
        return rolesId;
    }

    /**
     * @param rolesId
     */
    public void setRolesId(Long rolesId) {
        this.rolesId = rolesId;
    }
}