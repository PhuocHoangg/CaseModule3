drop database quanly1;
create database quanly1;
use quanly1;
CREATE TABLE Iphone (
id INT PRIMARY KEY auto_increment,
    brand VARCHAR(255),
    model VARCHAR(255),
    color VARCHAR(255),
    price DECIMAL(10, 2),
    quality INT,
    nation VARCHAR(255)
);
CREATE TABLE Android(
id INT PRIMARY KEY auto_increment,
brand VARCHAR(255),
    model VARCHAR(255),
    color VARCHAR(255),
    price DECIMAL(10, 2),
    quality INT
    );
INSERT INTO Android(brand,model,color,price,quality)
VALUES 
    ('Samsung', 'Galaxy S21', 'Phantom Gray', 799.99, 9),
    ('Google', 'Pixel 6', 'Sorta Seafoam', 699.99, 8 ),
    ('OnePlus', 'OnePlus 9', 'Winter Mist', 729.99, 8),
    ('Xiaomi', 'Mi 11', 'Horizon Blue', 749.99, 8),
    ('Sony', 'Xperia 5 III', 'Black', 899.99, 8);

INSERT INTO Iphone (brand, model, color, price, quality, nation)
VALUES
    ('Apple', 'iPhone 13 Pro', 'Silver', 999.99, 9, 'USA'),
    ('Apple', 'iPhone 13', 'Black', 799.99, 8, 'USA'),
    ('Apple', 'iPhone 12', 'White', 699.99, 7, 'USA'),
    ('Apple', 'iPhone 11', 'Green', 599.99, 6, 'USA'),
    ('Apple', 'iPhone SE', 'Red', 399.99, 7, 'USA');
    