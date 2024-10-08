## データベース作成クエリ

```sql
CREATE DATABASE IF NOT EXISTS online_workbook;

USE online_workbook;

CREATE TABLE IF NOT EXISTS workbook (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  title varchar(255),
  price int,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS chapter (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  number int,
  name varchar(255),
  workbook_id bigint(20),
  foreign key (workbook_id) references workbook(id) on delete cascade on update cascade,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS question (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  number int,
  sentence varchar(10000),
  chapter_id bigint(20),
  foreign key (chapter_id) references chapter(id) on delete cascade on update cascade,
  PRIMARY KEY (id)
);
```
