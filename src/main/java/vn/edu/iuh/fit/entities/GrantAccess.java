package vn.edu.iuh.fit.entities;

public class GrantAccess {
    private String roleId;
    private String accountId;
    private int isGrant;
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(String roleId, String accountId, int isGrant, String note) {
        this.roleId = roleId;
        this.accountId = accountId;
        this.isGrant = isGrant;
        this.note = note;
    }

    public GrantAccess(String roleId, String accountId) {
        this.roleId = roleId;
        this.accountId = accountId;

    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(int isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "roleId='" + roleId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
