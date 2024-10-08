# 問題集オンライン
オンライン上で問題集を閲覧できるようにするためのWebアプリケーションです。<br>
資格学習を行う際、紙媒体の問題集だけでは通勤時間に学習できないという課題を解決するために作成しました。

## 機能一覧

### 問題集作成機能

![問題集作成画面録画](https://github.com/user-attachments/assets/7d686f8a-8410-460a-a4c2-0c326530075f)

1. 問題集一覧ページの`問題集を追加`ボタンをクリック
1. 問題集のタイトルと価格を入力
1. `作成`ボタンをクリック

> [!NOTE]
> 作成した問題集データは、`workbook`テーブルの`title`カラム、`price`カラムに保存されます。

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
