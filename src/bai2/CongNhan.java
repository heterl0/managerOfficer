/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Le Van Hieu CE160866
 */
public class CongNhan extends CanBo{
    private int level;

    public CongNhan(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CongNhan{" + "name=" + super.getName() + ", age=" + super.getAge() + ", gender=" + super.getGender() + ", address=" + super.getAddress() + "level=" + level + '}';
    }
    
}
