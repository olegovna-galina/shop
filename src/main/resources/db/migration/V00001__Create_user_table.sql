CREATE TABLE IF NOT EXISTS `user` (

    `user_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `password` varchar(20) NOT NULL,
    `role` varchar(10)
);