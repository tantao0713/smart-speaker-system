# 智能音箱管理系统 - 生产环境部署指南

## 🌍 部署架构

```
┌─────────────┐
│   客户端     │ (浏览器)
│  Frontend   │
└──────┬──────┘
       │ HTTP/WebSocket
       ↓
┌──────────────────────────┐
│    反向代理 (Nginx)       │
│    负载均衡 (可选)        │
└──────┬───────────────────┘
       │
       ↓
┌──────────────────────────┐
│  Spring Boot 应用        │
│  (smart-speaker-backend)  │
└──────┬───────────────────┘
       │
       ↓
┌──────────────────────────┐
│  MySQL 数据库            │
│  (smart_speaker_db)      │
└──────────────────────────┘
```

## 🖥️ 服务器配置

### 最低配置
- CPU: 2核
- 内存: 2GB
- 磁盘: 20GB
- 带宽: 1Mbps

### 推荐配置
- CPU: 4核
- 内存: 4GB
- 磁盘: 50GB
- 带宽: 5Mbps

## 📦 部署步骤

### 第1步：准备服务器

```bash
# 1. 登录服务器
ssh user@your-server-ip

# 2. 更新系统
sudo apt update && sudo apt upgrade -y

# 3. 安装依赖
sudo apt install -y openjdk-11-jdk mysql-server nginx curl wget
```

### 第2步：配置 MySQL

```bash
# 1. 启动 MySQL
sudo systemctl start mysql
sudo systemctl enable mysql

# 2. 登录 MySQL
mysql -u root -p

# 3. 执行数据库脚本
source /path/to/schema.sql;

# 4. 创建应用数据库用户
CREATE USER 'app'@'localhost' IDENTIFIED BY 'strong_password';
GRANT ALL PRIVILEGES ON smart_speaker_db.* TO 'app'@'localhost';
FLUSH PRIVILEGES;
```

### 第3步：部署后端

```bash
# 1. 上传或克隆项目
git clone https://github.com/tantao0713/smart-speaker-system.git /opt/smart-speaker-system
cd /opt/smart-speaker-system/backend

# 2. 修改配置文件
# 编辑 src/main/resources/application.yml

# 3. 构建应用
mvn clean package -DskipTests

# 4. 创建运行目录
sudo mkdir -p /opt/app
sudo cp target/smart-speaker-backend-1.0.0.jar /opt/app/
sudo chown -R app:app /opt/app
```

### 第4步：创建 Systemd 服务

```bash
# 创建服务文件
sudo tee /etc/systemd/system/smart-speaker.service > /dev/null << EOF
[Unit]
Description=Smart Speaker System Backend
After=network.target mysql.service

[Service]
Type=simple
User=app
WorkingDirectory=/opt/app
ExecStart=/usr/bin/java -jar smart-speaker-backend-1.0.0.jar
Restart=on-failure
RestartSec=10

[Install]
WantedBy=multi-user.target
EOF

# 启用服务
sudo systemctl daemon-reload
sudo systemctl enable smart-speaker
sudo systemctl start smart-speaker

# 检查状态
sudo systemctl status smart-speaker
```

### 第5步：配置 Nginx

```bash
# 创建 Nginx 配置
sudo tee /etc/nginx/sites-available/smart-speaker > /dev/null << 'EOF'
upstream backend {
    server localhost:8080;
}

server {
    listen 80;
    server_name your-domain.com;
    return 301 https://$server_name$request_uri;
}

server {
    listen 443 ssl http2;
    server_name your-domain.com;

    ssl_certificate /etc/letsencrypt/live/your-domain.com/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/your-domain.com/privkey.pem;

    ssl_protocols TLSv1.2 TLSv1.3;
    ssl_ciphers HIGH:!aNULL:!MD5;
    ssl_prefer_server_ciphers on;

    root /opt/smart-speaker/frontend;
    index index.html index.htm;

    location /api {
        proxy_pass http://backend;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }

    location /api/ws {
        proxy_pass http://backend;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        proxy_set_header Host $host;
        proxy_read_timeout 86400;
    }

    location / {
        try_files $uri /index.html;
    }
}
EOF

# 启用配置
sudo ln -s /etc/nginx/sites-available/smart-speaker /etc/nginx/sites-enabled/
sudo nginx -t
sudo systemctl restart nginx
```

---

祝部署成功！🎉
