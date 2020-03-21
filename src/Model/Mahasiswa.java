/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 48faraaz
 */
public class Mahasiswa {
private String NRP,Nama,Gender,NoHp,alamat;

    public Mahasiswa(String NRP, String Nama, String Gender, String NoHp, String alamat) {
        this.NRP = NRP;
        this.Nama = Nama;
        this.Gender = Gender;
        this.NoHp = NoHp;
        this.alamat = alamat;
    }

    public Mahasiswa() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getNRP() {
        return NRP;
    }
    public String getNama() {
        return Nama;
    }
    public String getGender() {
        return Gender;
    }
    public String getNoHp() {
        return NoHp;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setNRP(String NRP) {
        this.NRP = NRP;
    }
    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
    public void setNoHp(String NoHp) {
        this.NoHp = NoHp;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
