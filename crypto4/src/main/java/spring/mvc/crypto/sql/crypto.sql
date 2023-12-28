/*


1. 使用者
+--------+----------+----------+
| userId | username | password |      
+--------+----------+----------+
|  101   | user123  | pass123  |       
|  102   | user456  | pass456  |  
|  103   | user789  | pass789  |      
+--------+----------+----------+

2. 帳戶(Account)
+-----------  +----------+-------------+
| accountId   |   type   |  balance    |
+-------------+----------+-------------+
|    201      |   ETH    |   105       |
|    202      |   BNB    |   22        |
|    203      |   XRP    |   11        |
|    204      |   SOL    |   250       |
|    205      |   LLL    |   125       |
+-------------+----------+-------------+
3.user_ref_account(用戶關聯帳戶)
+--------+---------+
| userId |   a_id  |
+--------+---------+
|  101   |   201   |
|  102   |   203   |
|  103   |   204   |
+--------+---------+
4.交易資訊(Transaction)
+--------+---------+---------+---------+
| tra_id |   type  |  price  |  profit |
+--------+---------+---------+---------+
|	301  |   ETH   |  2330.1 |  -2.55% |
|	302  |	 BNB   |  242.5  |  +268%  |
|   303  |	 BTC   |  42000  |  +25%   |
+--------+---------+---------+---------+

5.account_ref_transaction(帳戶關聯交易)
+--------+---------+
| tra_id |   a_id  |  
+--------+---------+
|	301  |   201   |
|	302  |	 203   |
|   303  |	 204   |
+--------+---------+
6. 單獨貨幣資訊(cryptoInfo)
+----------+----------+----------+-----------+-----------------------------+
| c_number |  cName   |	  price  |   cRate   |              cValue         |
+----------+----------+----------+-----------+-----------------------------+
|    1     |   BTC    |  42000.2 |    2.72   |    $850.39B$850,385,991,320$|
|    2     |   ETH    |  2300    |    8.76   |    $289.65B$289,645,728,802$|
|    3     |   BNB    |  322.6   |    0.08   |    $49.05B$49,045,586,955$  |   
|    4     |   XRP    |  25.11   |    12.06  |    $44.28B$44,279,003,746$  |
|    5     |   USDT   |  30.52   |    3.5    |    $34.65B$34,650,555,290$  |
|    6     |   SOL    |  110.68  |    0.85   |    $44.28B$44,279,003,746$  |
+----------+----------+----------+-----------+------------+----------------|


資料庫的建立: CREATE SCHEMA `crypto` DEFAULT CHARACTER SET utf8mb4 ;

 * */
-- 授權資料表
drop table if exists user;
drop table if exists account;
drop table if exists user_ref_account;
drop table if exists transaction;
drop table if exists account_ref_transaction;
drop table if exists cryptoInfo;
