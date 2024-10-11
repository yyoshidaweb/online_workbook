# 問題集オンライン
オンライン上で問題集を閲覧できるようにするためのWebアプリケーションです。

資格学習を行う際、紙媒体の問題集では通勤時間中に学習することができないという課題を解決するために作成しました。

このWebアプリケーションに問題集の問題を登録することで、スマートフォンでの学習が可能になり、学習効率が向上します。


## 機能一覧

### 各種データ作成機能

#### 問題集

<img src="https://github.com/user-attachments/assets/48f196b9-9bd9-4760-bad6-6ccbbd4596e0" alt="問題集作成画面録画" width="640px">

1. 問題集一覧ページの`問題集を追加`ボタンをクリック
1. 問題集のタイトルと価格を入力
1. `作成`ボタンをクリック

> [!NOTE]
> 作成した問題集データは、`workbook`テーブルの`title`カラム、`price`カラムに保存されます。

#### 章

<img src="https://github.com/user-attachments/assets/fe2f3db3-54a5-47e1-96a0-e5dd04798ceb" alt="章作成画面録画" width="640px">

1. 目次ページの`章を追加`ボタンをクリック
1. 章番号と章のタイトルを入力
1. `作成ボタン`をクリック

> [!NOTE]
> 作成した章データは、`chapter`テーブルの`number`カラム、`name`カラムに保存されます。

#### 問題

<img src="https://github.com/user-attachments/assets/60142162-baff-4b31-9615-36d9cb9742ca" alt="問題作成画面録画" width="640px">

1. 問題一覧ページの`問題を追加`ボタンをクリック
1. 問題番号と問題文を入力
1. `作成ボタン`をクリック

> [!NOTE]
> 作成した問題データは、`question`テーブルの`number`カラム、`sentence`カラムに保存されます。

### 各種データ編集機能

#### 問題集

<img src="https://github.com/user-attachments/assets/c7087c5b-8016-4ab2-bc05-788fee5cef69" alt="問題集編集画面録画" width="640px">

1. 問題集一覧ページの`編集`ボタンをクリック
1. 問題集のタイトルと価格を変更
1. `変更`をクリック

#### 章

<img src="https://github.com/user-attachments/assets/88aab617-e4d4-4411-bb42-0e1dfd3f639a" alt="章編集画面録画" width="640px">

1. 目次ページの`編集`ボタンをクリック
1. 章番号と章のタイトルを変更
1. `変更`をクリック

#### 問題

<img src="https://github.com/user-attachments/assets/71b830a3-4666-4a97-ac76-ea8493189f59" alt="問題編集画面録画" width="640px">

1. 問題一覧ページの`編集`ボタンをクリック
1. 問題番号と問題文を変更
1. `変更`をクリック

### 各種データ削除機能

#### 問題集

<img src="https://github.com/user-attachments/assets/802ed8d8-167c-4f2f-b703-1de72543f3aa" alt="問題集削除画面録画" width="640px">

1. 問題集一覧ページの`削除`ボタンをクリック

> [!WARNING]
> 問題集に紐づく章、その章に紐づく問題も全て削除されます。

#### 章

<img src="https://github.com/user-attachments/assets/44ee523a-c3a8-4850-91b8-ff3ed8333565" alt="章削除画面録画" width="640px">

1. 目次ページの`削除`ボタンをクリック

> [!WARNING]
> 章に紐づく問題も全て削除されます。

#### 問題

<img src="https://github.com/user-attachments/assets/c0028316-3c20-4fe9-a00c-d9b9f2891bab" alt="問題削除画面録画" width="640px">

1. 問題一覧ページの`削除`をクリック

## 使用技術

* フロントエンド
    * HTML5
    * CSS3
* テンプレートエンジン
    * Thymeleaf 3.1.2
* バックエンド
    * Java 17
* フレームワーク
    * Spring Framework 6.1.13
        * Spring Boot 3.3.4
        * MyBatis 3.5.14
* データベース
    * MySQL 8.4.2

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
