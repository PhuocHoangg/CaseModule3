drop database quanly1;
create database quanly1;
use quanly1;
CREATE TABLE Brand ( id INT PRIMARY KEY AUTO_INCREMENT, 
name VARCHAR(255) NOT NULL );
CREATE TABLE Iphone (
    id INT PRIMARY KEY AUTO_INCREMENT,
    brand_id INT NOT NULL,
    model VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quality INT NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES Brand(id)
);
INSERT INTO Brand (name) VALUES
('Apple'),
('Samsung'),
('Google'),
('OnePlus');

INSERT INTO Iphone (brand_id, model, color, price, quality) VALUES
(1, 'iPhone 12', 'Black', 799, 99),
(2, 'Galaxy S21', 'White', 999, 90),
(1, 'iPhone SE', 'Red', 399, 98),
(3, 'Pixel 5', 'Green', 699, 98),
(2, 'Galaxy Note 20', 'Blue', 1199, 80),
(4, 'OnePlus 8', 'Purple', 499, 100),
(1, 'iPhone 12 Pro', 'Gold', 999, 100),
(3, 'Pixel 4a', 'Black', 349, 97),
(4, 'OnePlus 8 Pro', 'White', 799, 100),
(2, 'Galaxy Z Flip', 'Pink', 1380, 99);
SELECT * FROM Iphone


    