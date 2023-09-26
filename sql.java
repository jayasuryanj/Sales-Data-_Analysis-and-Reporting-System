-- Create the database
CREATE DATABASE IF NOT EXISTS SalesData;
USE SalesData;

-- Create the 'products' table
CREATE TABLE IF NOT EXISTS products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255),
    product_price DECIMAL(10, 2)
);

-- Create the 'sales' table
CREATE TABLE IF NOT EXISTS sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    sale_date DATE,
    product_id INT,
    sale_amount DECIMAL(10, 2),
    sale_quantity INT
);

-- Insert sample data into 'products'
INSERT INTO products (product_name, product_price)
VALUES
    ('Product A', 19.99),
    ('Product B', 29.99),
    ('Product C', 9.99);

-- Insert sample data into 'sales'
INSERT INTO sales (sale_date, product_id, sale_amount, sale_quantity)
VALUES
    ('2023-09-01', 1, 199.90, 10),
    ('2023-09-02', 2, 59.98, 2),
    ('2023-09-03', 1, 99.95, 5);

-- Create a sample query (view)
CREATE VIEW IF NOT EXISTS sales_summary AS
SELECT
    s.sale_id,
    s.sale_date,
    p.product_name,
    s.sale_amount,
    s.sale_quantity
FROM
    sales s
JOIN
    products p ON s.product_id = p.product_id;
