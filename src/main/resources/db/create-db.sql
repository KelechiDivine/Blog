create database if not exists Blog;

# create user if not exists  'root'@'localhost' identified by 'keLechi5363@#';
create user if not exists  'blogUser'@'localhost' identified by 'blog111';

grant all privileges on Blog.* to 'blogUser'@'localhost';
flush privileges;