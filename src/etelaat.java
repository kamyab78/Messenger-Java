public class etelaat {
    private String name;
    private String familyname;
    private String email;
    private String user;
    private String pass;
    public etelaat(String name,String familyname , String email , String user , String pass){
        this.email=email;
        this.familyname=familyname;
        this.name=name;
        this.pass=pass;
        this.user=user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}