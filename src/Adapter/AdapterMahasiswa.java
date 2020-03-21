/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import Controller.ExecuteMahasiswa;
import Model.Mahasiswa;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 48faraaz
 */
public class AdapterMahasiswa {
    public Object[][] getAllGuru() {
        ExecuteMahasiswa em = new ExecuteMahasiswa();
        List<Mahasiswa>lstmhs= em.ListMhs();
        Object[][] datamhs= new Object [lstmhs.size()][5];
        
        int mysize=0;
        for (Mahasiswa mhs:lstmhs){
            datamhs[mysize][0]=mhs.getNRP();
            datamhs[mysize][1]=mhs.getNama();
            datamhs[mysize][2]=mhs.getGender();
            datamhs[mysize][3]=mhs.getNoHp();
            datamhs[mysize][4]=mhs.getAlamat();
            mysize++;
        }
        return datamhs;
    }
}
