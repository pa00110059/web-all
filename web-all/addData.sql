-- �R�����]�p�G�s�b�^
IF OBJECT_ID('sys_schedule', 'U') IS NOT NULL DROP TABLE sys_schedule;
IF OBJECT_ID('sys_user', 'U') IS NOT NULL DROP TABLE sys_user;

-- �Ы� sys_user ��
CREATE TABLE sys_user (
  uid INT IDENTITY(1,1) PRIMARY KEY,
  username NVARCHAR(10) UNIQUE,  -- Unicode �r��
  user_pwd NVARCHAR(100) NULL
);

-- �Ы� sys_schedule ��
CREATE TABLE sys_schedule (
  sid INT IDENTITY(1,1) PRIMARY KEY,
  uid INT NULL,
  title NVARCHAR(20) NULL,  -- �ϥ� NVARCHAR �x�s Unicode
  completed BIT NULL,  -- SQL Server �ϥ� BIT �N���L��
  FOREIGN KEY (uid) REFERENCES sys_user(uid)  -- �~�����
);

-- ���J�ƾ�
INSERT INTO sys_user (username, user_pwd) VALUES 
(N'zhangsan', N'e10adc3949ba59abbe56e057f20f883e'),
(N'lisi', N'e10adc3949ba59abbe56e057f20f883e');