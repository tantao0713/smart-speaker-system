# 智能音箱管理系统 - 安装指南

## 📋 系统需求

### 后端要求
- **Java**: JDK 11 或更高版本
- **Maven**: 3.6 或更高版本
- **MySQL**: 8.0 或更高版本
- **内存**: 至少 2GB RAM
- **磁盘空间**: 至少 500MB

### 前端要求
- **现代浏览器**: Chrome、Firefox、Safari、Edge（最新版本）
- **网络**: 能够访问本地服务器

## 🚀 快速开始（5分钟）

### 第1步：数据库准备

```bash
# 1. 登录 MySQL
mysql -u root -p

# 2. 执行数据库脚本
mysql> source backend/src/main/resources/db/schema.sql;

# 3. 验证数据库
mysql> use smart_speaker_db;
mysql> show tables;
```

### 第2步：修改后端配置

编辑 `backend/src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    username: root           # 改为你的 MySQL 用户名
    password: your_password  # 改为你的 MySQL 密码
    url: jdbc:mysql://localhost:3306/smart_speaker_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
```

### 第3步：启动后端

```bash
# 方式1：使用 Maven
cd backend
mvn clean install
mvn spring-boot:run

# 方式2：直接运行 JAR（先打包）
cd backend
mvn clean package
java -jar target/smart-speaker-backend-1.0.0.jar
```

**输出示例**（表示启动成功）：
```
2026-06-04 10:30:00.123  INFO 12345 --- [main] c.s.SmartSpeakerApplication : Started SmartSpeakerApplication in 5.234 seconds
```

### 第4步：启动前端

#### 方式1：直接打开 HTML（最简单）
```bash
# 在浏览器中打开
file:///path/to/frontend/index.html
```

#### 方式2：使用 Python 简单服务器
```bash
cd frontend
python -m http.server 8000

# 浏览器访问：http://localhost:8000
```

#### 方式3：使用 Node.js HTTP 服务器
```bash
# 安装 http-server（如果未安装）
npm install -g http-server

cd frontend
http-server -p 8080

# 浏览器访问：http://localhost:8080
```

### 第5步：验证应用

1. **打开浏览器** 访问 `http://localhost:8000`（或对应的地址）
2. **查看连接状态** 右上角应显示"已连接"
3. **新增设备** 点击"+ 新增"按钮，填写设备信息
4. **控制设备** 选择设备后可以实时控制

## 🔧 详细配置说明

### MySQL 配置

#### Windows 系统
```bash
# 1. 下载 MySQL Community Server
# https://dev.mysql.com/downloads/mysql/

# 2. 安装（按默认选项）

# 3. 启动 MySQL 服务
net start MySQL80

# 4. 登录
mysql -u root -p

# 5. 执行数据库脚本
source backend/src/main/resources/db/schema.sql;
```

#### macOS 系统
```bash
# 使用 Homebrew
brew install mysql

# 启动服务
brew services start mysql

# 登录
mysql -u root

# 执行脚本
source backend/src/main/resources/db/schema.sql;
```

#### Linux 系统
```bash
# Ubuntu/Debian
sudo apt-get install mysql-server

# CentOS/RHEL
sudo yum install mysql-server

# 启动服务
sudo systemctl start mysql

# 登录
mysql -u root -p

# 执行脚本
source backend/src/main/resources/db/schema.sql;
```

## 📞 获取帮助

- **文档**: 查看 README.md 和各目录下的说明
- **日志**: 检查后端 `logs/app.log` 文件
- **浏览器控制台**: F12 打开开发者工具，查看 Console 和 Network

---

祝你使用愉快！🎉
