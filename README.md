# 環境
## データベース
データベースのクライアントから以下のクエリを実行して下さい。
### 問題集テーブル

```sql
CREATE DATABASE IF NOT EXISTS online_workbook;

USE online_workbook;

CREATE TABLE IF NOT EXISTS workbook (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  title varchar(255),
  price int,
  PRIMARY KEY (id)
);
```

### 章テーブル

```sql
CREATE TABLE IF NOT EXISTS chapter (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  number int,
  name varchar(255),
  workbook_id bigint(20),
  foreign key (workbook_id) references workbook(id) on delete cascade on update cascade,
  PRIMARY KEY (id)
);
```