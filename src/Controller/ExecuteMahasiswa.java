/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Model.Mahasiswa;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 48faraaz
 */
public class ExecuteMahasiswa {
    public String InsertMahasiswa(Mahasiswa mhs) {
        String query = "INSERT INTO mahasiswa value(?,?,?,?,?)";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        String Respon;
        try{
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1, mhs.getNRP());
            pstm.setString(2, mhs.getNama());
            pstm.setString(3, mhs.getGender());
            pstm.setString(4, mhs.getAlamat());
            pstm.setString(5, mhs.getNoHp());
            pstm.executeUpdate();
            Respon = "Insert Sukses";
        } catch (SQLException ex){
            Respon = "Insert Gagal";
            Logger.getLogger(ExecuteMahasiswa.class.getName()).log(Level.SEVERE, null, ex); 
        }
            conMan.Logoff();
            return Respon;
    }
    
    public List<Mahasiswa> ListMhs() {
        List<Mahasiswa>arlistmhs = new ArrayList<>();
        String query= "SELECT * FROM mahasiswa";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                Mahasiswa mhs = new Mahasiswa();
                mhs.setNRP(rs.getString("NRP"));
                mhs.setNama(rs.getString("Nama"));
                mhs.setGender(rs.getString("Gender"));
                mhs.setAlamat(rs.getString("Alamat"));
                mhs.setNoHp(rs.getString("NoHp"));
                arlistmhs.add(mhs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExecuteMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.Logoff();
        return arlistmhs;
    }
    
    public String UpdateMahasiswa(Mahasiswa mhs) {
        String hasil ="";
        String query = "UPDATE mahasiswa set nama='"+mhs.getNama()+"', gender='"+mhs.getGender()+"'"
                + ",nohp='"+mhs.getNoHp()+"', alamat='"+mhs.getAlamat()+"' where nrp='"+mhs.getNRP()+"'";
        
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try{
            Statement stm = conn.createStatement();
           stm.executeUpdate(query);
           hasil="Berhasil";
        }
        catch (SQLException ex){
            hasil="Gagal";
        Logger.getLogger(ExecuteMahasiswa.class.getName()).log(Level.SEVERE, null,ex);
    }
        conMan.Logoff();
        return hasil;
    }
    
    public String deletemahasiswa(String mhs){
        String hasil="";
        String query = "delete from mahasiswa where nrp='"+mhs+"'";
        ConnectionManager conMan = new ConnectionManager();
        Connection conn = conMan.Logon();
        try{
            Statement stm = conn.createStatement();
            stm.executeUpdate(query);
            hasil="Berhasil";
        } catch (SQLException ex){
            hasil="Gagal";
            Logger.getLogger(ExecuteMahasiswa.class.getName()).log(Level.SEVERE,null,ex);
        }
        conMan.Logoff();
        return hasil;
    }
}
