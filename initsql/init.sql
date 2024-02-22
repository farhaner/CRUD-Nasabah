CREATE TABLE nasabah (
                       id VARCHAR PRIMARY KEY,
                       nama_lengkap VARCHAR,
                       alamat VARCHAR,
                       tempat_lahir VARCHAR,
                       tanggal_lahir VARCHAR,
                       no_ktp VARCHAR,
                       no_hp VARCHAR
);

INSERT INTO nasabah (nama_lengkap, alamat, tempat_lahir, tanggal_lahir, no_ktp, no_hp)
VALUES ('John Doe', 'Jl. Contoh No. 123', 'Jakarta', '1990-01-01', '1234567890', '081234567890'),
       ('Jane Doe', 'Jl. Contoh No. 456', 'Bandung', '1995-05-05', '0987654321', '085678901234');
