public class etelaa {
    private  String name;
    private String familyname;
    private String email;
    private String user;
    private String pass;
    private String photo;

    etelaa(String name , String familyname , String email , String user , String pass , String photo){
        this.name = name;
        this.familyname=familyname;
        this.email=email;
        this.user=user;
        this.pass=pass;
        this.photo=photo;
    }
    public String getPhoto() {return photo;}
    public void setPhoto(String photo) { this.photo = photo;}
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
