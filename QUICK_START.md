# 快速开始指南（5分钟上手）

## 🎯 目标

在 5 分钟内启动完整的智能音箱管理系统。

## ⚡ 快速步骤

### 1️⃣ 克隆项目（1分钟）

```bash
git clone https://github.com/tantao0713/smart-speaker-system.git
cd smart-speaker-system
```

### 2️⃣ 创建数据库（2分钟）

```bash
# 打开 MySQL 客户端
mysql -u root -p

# 执行脚本
mysql> source backend/src/main/resources/db/schema.sql;

# 验证（应看到 4 个表）
mysql> use smart_speaker_db;
mysql> show tables;
```

### 3️⃣ 修改数据库配置（1分钟）

编辑文件：`backend/src/main/resources/application.yml`

找到这两行，改为你的 MySQL 用户名和密码：
```yaml
username: root              # ← 改这里
password: root              # ← 改这里
```

### 4️⃣ 启动后端（1分钟）

```bash
cd backend
mvn spring-boot:run
```

✅ 看到 "Started SmartSpeakerApplication" 表示成功！

### 5️⃣ 启动前端（0分钟）

**方式A：直接打开（最简单）**
```bash
# 在浏览器中打开
file:///path/to/smart-speaker-system/frontend/index.html
```

**方式B：简单服务器（推荐）**
```bash
cd frontend
python -m http.server 8000

# 浏览器访问：http://localhost:8000
```

## ✅ 验证成功

1. ✅ 页面显示"智能音箱管理系统"
2. ✅ 右上角显示"已连接"（绿色）
3. ✅ 左侧显示设备列表
4. ✅ 可以点击"+新增"添加设备

完成！🎉

## 📞 遇到问题？

### ❌ 右上角显示"未连接"
→ 检查后端是否运行：`curl http://localhost:8080/api/device/list`

### ❌ 页面加载空白
→ 刷新页面（Ctrl+F5）

### ❌ MySQL 连接失败
→ 检查用户名和密码：`mysql -u root -p`

### ❌ 更多帮助
→ 查看 INSTALL.md 详细指南

---

## 🚀 接下来

- 📖 阅读 README.md 了解完整功能
- 🔧 阅读 DEPLOYMENT.md 部署到服务器
- 🔨 修改代码实现自己的需求
