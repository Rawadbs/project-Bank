
package Bank;

public class Customer {
  //Declaring instance variables.
  final private String name ;
  final private int nationalid;
  final private String address;
  final private String email;
  final private int number ;
  //Customer constructor method.
  public Customer(String name,int nationalid,String address,String email,int number){
    this.name = name;
    this.nationalid = nationalid;
    this.address = address;
    this.email = email;
    this.number = number;
    }
    //toString method for use in the selection screen.
    @Override
    public String toString() {
        return "Customer{" + "Name: " + name + ", National ID:" + nationalid + ", Address=" + address + ", E-mail=" + email + ", Phone Number=" + number + '}';
      }
}
