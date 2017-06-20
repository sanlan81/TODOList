CREATE TABLE user(
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL,
  password VARCHAR(30) NOT NULL,
  PRIMARY KEY (id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE todo_list (
  id int(11) NOT NULL AUTO_INCREMENT,
  user_id int(11) DEFAULT NULL,
  title VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  KEY fk_user_idx (user_id)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE todo_list_item (
  id int(11) NOT NULL AUTO_INCREMENT,
  todo_list_id int(11) DEFAULT NULL,
  title VARCHAR(50) NOT NULL,
  completed tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_todo_list_idx (todo_list_id)
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;