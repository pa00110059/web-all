-- 刪除表格（如果存在）
IF OBJECT_ID('sys_schedule', 'U') IS NOT NULL DROP TABLE sys_schedule;
IF OBJECT_ID('sys_user', 'U') IS NOT NULL DROP TABLE sys_user;

-- 創建 sys_user 表
CREATE TABLE sys_user (
  uid INT IDENTITY(1,1) PRIMARY KEY,
  username NVARCHAR(10) UNIQUE,  -- Unicode 字符
  user_pwd NVARCHAR(100) NULL
);

-- 創建 sys_schedule 表
CREATE TABLE sys_schedule (
  sid INT IDENTITY(1,1) PRIMARY KEY,
  uid INT NULL,
  title NVARCHAR(20) NULL,  -- 使用 NVARCHAR 儲存 Unicode
  completed BIT NULL,  -- SQL Server 使用 BIT 代表布林值
  FOREIGN KEY (uid) REFERENCES sys_user(uid)  -- 外鍵約束
);

-- 插入數據
INSERT INTO sys_user (username, user_pwd) VALUES 
(N'zhangsan', N'e10adc3949ba59abbe56e057f20f883e'),
(N'lisi', N'e10adc3949ba59abbe56e057f20f883e');