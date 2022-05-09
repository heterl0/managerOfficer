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
public class KySu extends CanBo {
    private String major;

    public KySu(String name, int age, String gender, String address, String major) {
        super(name, age, gender, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    
}
