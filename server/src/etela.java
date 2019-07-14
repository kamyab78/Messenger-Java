public class etela {
    private String name;
    private String familyname;
    private String email;
    private String  username;
    private String pass;
private String photo;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFamilyname() { return familyname; }
    public void setFamilyname(String familyname) { this.familyname = familyname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPass() { return pass; }
    public void setPass(String pass) {this.pass = pass;}
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    etela(String name , String familyname , String email , String username , String pass , String photo){
        this.name = name;
        this.familyname = familyname;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.photo = photo;
    }

}
