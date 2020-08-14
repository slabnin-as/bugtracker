package model;

public enum Role {
    ADMIN("Administrator"),
    MANAGER("Manager"),
    DEVELOPER("Developer");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getName(){
        return role;
    }
}
