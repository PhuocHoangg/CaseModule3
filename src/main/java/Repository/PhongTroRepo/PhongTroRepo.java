package Repository.PhongTroRepo;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import Repository.BaseRepository;
import Repository.PhuongThuc.PhuongThucRepo;
import com.example.demo5.PhongTro;
import com.example.demo5.PhuongThuc;

import java.util.List;

public class PhongTroRepo implements IPhongTro{
    private PhuongThucRepo phuongThucRepo = new PhuongThucRepo();
 private static final List<PhongTro> list = null;
 private final String FIND_ALL="select * from Room";
    ; private final String DEL_PhongTro = "DELETE FROM Room WHERE id = ?";
 private final String INS_PhongTro="insert INTO Room(name,sdt,ngay_thue,ghi_chu,phuongthuc_id)"+"values (?,?,?,?,?)";
    @Override
    public List<PhongTro> findAll() {
     List<PhongTro> phongTros = new ArrayList<>();
     BaseRepository baseRepo = new BaseRepository();
Connection con = baseRepo.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL);
            while(rs.next()) {
int id = rs.getInt("id");
String name = rs.getString("name");
String phonenumber=rs.getString("sdt");
LocalDate day=rs.getDate("ngay_thue").toLocalDate();
String note=rs.getString("ghi_chu");
int phuongThucId=rs.getInt("phuongthuc_id");
PhuongThuc phuongThuc= phuongThucRepo.findById(phuongThucId);
phongTros.add(new PhongTro(id,name,phonenumber,day,note,phuongThuc));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      return phongTros;
    }

    @Override
    public void save(PhongTro p) {
 BaseRepository baseRepo = new BaseRepository();
 Connection con = baseRepo.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(INS_PhongTro);
           ps.setString(1, p.getName());
           ps.setString(2,p.getSodienthoai());
           ps.setDate(3, Date.valueOf(p.getNgaythue()));
           ps.setString(4, p.getGhichu());
           ps.setInt(5,p.getPhuongthuc().getId());
           ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(int id) {
        BaseRepository baseRepo = new BaseRepository();
        Connection con = baseRepo.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(DEL_PhongTro);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}









