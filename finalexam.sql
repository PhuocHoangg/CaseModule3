CREATE TABLE phuong_thuc (
    id INT PRIMARY KEY AUTO_INCREMENT,
    phuongthuc VARCHAR(50) NOT NULL
);
CREATE TABLE Room (
    id INT PRIMARY KEY AUTO_INCREMENT,
    ten VARCHAR(255) NOT NULL,
    sdt VARCHAR(20) NOT NULL,
    ngay_thue DATE NOT NULL,
    phuongthuc_id INT,
    FOREIGN KEY (phuongthuc_id) REFERENCES phuong_thuc(id)
);
INSERT INTO phuong_thuc (phuongthuc) VALUES
('Theo tháng'),
('Theo quý'),
('Theo năm');

