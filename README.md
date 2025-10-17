# 🛒 Product Management API

A simple RESTful API built using **Spring Boot** to manage products.  
This API provides endpoints to create, read, update, and delete product data efficiently.

---

## 📦 Entity: `Product`

| Field      | Type     | Description                |
|-------------|----------|----------------------------|
| `id`        | Integer  | Auto-generated product ID   |
| `name`      | String   | Product name               |
| `category`  | String   | Product category           |
| `brand`     | String   | Product brand name         |
| `price`     | Double   | Product price              |
| `quantity`  | Integer  | Product stock quantity     |

---

## 🚀 API Endpoints

### ➕ Create Operations

| Method | Endpoint | Description |
|--------|-----------|-------------|
| **POST** | `/products` | Add a new product |
| **POST** | `/products/batch` | Add multiple products at once |

---

### 🔍 Read Operations

| Method | Endpoint | Description |
|--------|-----------|-------------|
| **GET** | `/products` | Fetch all products |
| **GET** | `/products/{id}` | Get product by ID |
| **GET** | `/products/name/{name}` | Get products by name |
| **GET** | `/products/available` | Get available (in-stock) products |

---

### ✏️ Update Operations

| Method | Endpoint | Description |
|--------|-----------|-------------|
| **PUT** | `/products` | Update existing product |
| **PATCH** | `/products/{id}/quantity` | Update product quantity by ID |

---

### ❌ Delete Operations

| Method | Endpoint | Description |
|--------|-----------|-------------|
| **DELETE** | `/products/{id}` | Delete product by ID |
| **DELETE** | `/products/brand/{brand}` | Delete products by brand |

---

## 🧩 Technologies Used

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Hibernate**
- **MySQL Database**
- **Lombok (optional)**

---

## ⚙️ Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/product-management-api.git](https://github.com/arjun-9990/ProductManagementSystem.git
