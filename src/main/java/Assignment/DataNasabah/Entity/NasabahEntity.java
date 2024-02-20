package Assignment.DataNasabah.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "nasabah")
public class NasabahEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nama_lengkap")
    private String namaLengkap;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private String tanggalLahir;

    @Column(name = "no_ktp")
    private String nomerKtp;

    @Column(name = "no_hp")
    private String nomerHanphone;


}
