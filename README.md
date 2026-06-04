# 智能音箱管理系统

一个基于 Spring Boot + MyBatis + MySQL + WebSocket 的全栈项目，实现智能音箱的远程控制和实时数据监测。

## 📋 项目功能概述

### 核心功能
1. **电源管理** - 远程/手动控制音箱开关
2. **音量控制** - 0-100 级调节，90%+ 触发警报
3. **灯光效果** - 律动灯光显示（亮2秒，灭1秒循环）
4. **运行时监测** - 超时自动关闭并告警
5. **电池管理** - 实时监测电量和电压
6. **充电指示** - 动态显示充电状态（橙/蓝/绿/红）
7. **历史数据** - 查看电量、电压、运行时间等历史记录
8. **告警系统** - 多种告警类型（音量、超时、低电量）

## 🏗️ 项目架构

```
smart-speaker-system/
├── backend/                    # Spring Boot 后端项目
│   ├── src/main/java/
│   │   └── com/smartspeaker/
│   │       ├── controller/     # REST API 控制层
│   │       ├── service/        # 业务逻辑层
│   │       ├── mapper/         # 数据访问层
│   │       ├── entity/         # 实体类
│   │       ├── websocket/      # WebSocket 配置
│   │       ├── config/         # 配置类
│   │       └── utils/          # 工具类
│   ├── src/main/resources/
│   │   ├── application.yml     # 应用配置
│   │   ├── db/schema.sql       # 数据库脚本
│   │   └── mapper/             # MyBatis XML 映射
│   └── pom.xml
│
├── frontend/                   # 前端项目
│   ├── index.html              # 主页面
│   ├── css/style.css           # 样式
│   └── js/app.js               # 应用脚本
│
├── QUICK_START.md              # 快速开始指南
├── INSTALL.md                  # 详细安装指南
├── DEPLOYMENT.md               # 生产环境部署
└── README.md                   # 本文件
```

## 🚀 快速开始

### 前置要求
- Java 11+
- MySQL 8.0+
- Maven 3.6+
- 现代浏览器

### 安装步骤

#### 1. 创建数据库
```bash
mysql -u root -p < backend/src/main/resources/db/schema.sql
```

#### 2. 配置后端
编辑 `backend/src/main/resources/application.yml`
```yaml
spring:
  datasource:
    username: root
    password: your_password
```

#### 3. 启动后端
```bash
cd backend
mvn spring-boot:run
```

#### 4. 启动前端
```bash
cd frontend
python -m http.server 8000
# 访问 http://localhost:8000
```

## 📊 核心业务逻辑

### 算法1：电池电量百分比计算
```
公式：(V2 - V_min) / (V1 - V_min) × 100%
说明：根据当前电压计算电量百分比
```

### 算法2：充电指示灯颜色判断
```
充电中        → 橙色 (ORANGE)
未充电+开启    → 蓝色 (BLUE) 或 绿色 (GREEN) 或 红色 (RED)
未充电+关闭    → 灭 (OFF)
```

### 算法3：音量警告触发
```
当 volume >= 90% 时触发警告
触发：灯光亮1秒，灭0.5秒，重复
清除：调节音量至 <= 90%
```

### 算法4：连续运行超时检测
```
IF 运行时间 > 最大安全运行时间 THEN
  - 触发告警（声音和灯光）
  - 自动关闭音箱
  - 记录告警
END IF
```

### 算法5：低电量告警
```
当电量 <= 10% 时触发
显示红色灯光，亮1秒灭0.5秒重复
充电后自动清除
```

## 🔌 API 端点

### 设备管理
- `GET /api/device/list` - 获取所有设备
- `GET /api/device/{id}` - 获取设备详情
- `POST /api/device/register` - 注册新设备
- `POST /api/device/updateStatus` - 更新设备状态
- `DELETE /api/device/{id}` - 删除设备

### 历史数据
- `GET /api/history/list` - 获取历史记录
- `GET /api/history/alarms` - 获取告警记录
- `POST /api/history/clearAlarm` - 清除告警

## 🔌 WebSocket 通信

### 连接地址
```
ws://localhost:8080/api/ws/device
```

### 消息格式
```json
// 前端→后端（控制）
{
  "messageType": "CONTROL",
  "deviceId": 1,
  "command": "POWER_SWITCH",
  "value": 1
}

// 后端→前端（推送状态）
{
  "messageType": "STATUS_UPDATE",
  "deviceId": 1,
  "status": {...}
}
```

## 📚 文档

- [快速开始](QUICK_START.md) - 5分钟上手
- [安装指南](INSTALL.md) - 详细安装步骤
- [部署指南](DEPLOYMENT.md) - 生产环境部署

## 🛠️ 技术栈

**后端**
- Spring Boot 2.7.14
- Spring WebSocket
- MyBatis 2.2.2
- MySQL 8.0
- Druid 连接池

**前端**
- HTML5
- CSS3（响应式）
- Vanilla JavaScript
- WebSocket API

## 📄 许可证

MIT License

## 🎉 完成！

更多细节请查看相关文档。祝你使用愉快！
