package spring.jpa.login.model;

public class Luser {

   public String getUserName() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   private String username;
   private  String password;


}
