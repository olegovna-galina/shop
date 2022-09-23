CREATE TABLE IF NOT EXISTS customer (
  customer_id VARCHAR NOT NULL PRIMARY KEY,
  first_name VARCHAR NOT NULL,
  last_name VARCHAR NOT NULL,
  address VARCHAR NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES users (log_in) ON DELETE CASCADE
);

create table IF NOT EXISTS product (
    product_id INT NOT NULL,
    name varchar(20) NOT NULL,
    description varchar(255) NOT NULL,
    price DECIMAL NOT NULL,
    brand varchar(255) NOT NULL,
    category varchar(255) NOT NULL,
    primary key (product_id)
);