# DB

## ER 다이어그램

![ERD](https://user-images.githubusercontent.com/74192619/228433185-423b2fcd-8718-4932-a436-8f7efcb74365.png)

## 테이블 구성

### 1. Member

| Column   | DataType     | Java DataType | PK  | FK  | NN  | Description             |
| -------- | ------------ | ------------- | --- | --- | --- | ----------------------- |
| Id       | bigint       | Long          | O   |     |     | 멤버 식별자             |
| Birth    | data         | LocalData     |     |     | O   | 멤버의 생년 월일        |
| Email    | varchar(255) | String        |     |     | O   | 멤버의 이메일           |
| Name     | varchar(255) | String        |     |     | O   | 멤버의 이름             |
| Password | varchar(255) | String        |     |     | O   | 멤버의 비밀번호 (HS512) |
| Phone    | varchar(255) | String        |     |     | O   | 멤버의 전화번호         |
| Role     | varchar(255) | Enum          |     |     | O   | 멤버의 역활             |

### 2. Product

| Column   | DataType     | Java DataType | PK  | FK  | NN  | Description   |
| -------- | ------------ | ------------- | --- | --- | --- | ------------- |
| Id       | bigint       | Long          | O   |     |     | 제품 식별자   |
| Category | varchar(255) | Enum          |     |     | O   | 제품 카테고리 |
| Image    | CLOB         | String        |     |     | O   | 제품 이미지   |
| Info     | varchar(255) | String        |     |     | O   | 제품 설명     |
| Name     | varchar(255) | String        |     |     | O   | 제품 이름     |
| Price    | integer      | int           |     |     | O   | 제품 가격     |
| Stock    | integer      | int           |     |     | O   | 제품 재고     |
| Target   | varchar(255) | Enum          |     |     | O   | 제품 고객층   |

### 3. Carousel

| Column      | DataType | Java DataType | PK  | FK  | NN  | Description   |
| ----------- | -------- | ------------- | --- | --- | --- | ------------- |
| Carousel_Id | bigint   | Long          | O   |     |     | 캐러셀 식별자 |
| Product_Id  | bigint   | Long          |     | O   | O   | 제품 식별자   |
| Image       | CLOB     | String        |     |     | O   | 캐러셀 이미지 |

- `Product ----< Carousel`

### 4. Cart

| Column     | DataType | Java DataType | PK  | FK  | NN  | Description     |
| ---------- | -------- | ------------- | --- | --- | --- | --------------- |
| Id         | bigint   | Long          | O   |     |     | 장바구니 식별자 |
| Member_Id  | bigint   | Long          |     | O   | O   | 멤버 식별자     |
| Product_Id | bigint   | Long          |     | O   | O   | 제품 식별자     |
| Checked    | boolean  | boolean       |     |     | O   | 선택 유무       |
| Quantity   | integer  | int           |     |     | O   | 제품 수량       |

- `Member ----< Cart`
- `Product ----< Cart`

### 5. Orders

| Column     | DataType     | Java DataType | PK  | FK  | NN  | Description      |
| ---------- | ------------ | ------------- | --- | --- | --- | ---------------- |
| Id         | bigint       | Long          | O   |     |     | 주문 목록 식별자 |
| Member_Id  | bigint       | Long          |     | O   | O   | 멤버 식별자      |
| Product_Id | bigint       | Long          |     | O   | O   | 제품 식별자      |
| Date       | date         | LocalDate     |     |     | O   | 주문 날자        |
| Quantity   | integer      | int           |     |     | O   | 주문 수량        |
| Status     | varchar(255) | Enum          |     |     | O   | 주문 상태        |

- `Member ----< Order`
- `Product ----< Order`

### 6. Review

| Column     | DataType     | Java DataType | PK  | FK  | NN  | Description   |
| ---------- | ------------ | ------------- | --- | --- | --- | ------------- |
| Id         | bigint       | Long          | O   |     | O   | 리뷰 식별자   |
| Member_Id  | bigint       | Long          |     | O   |     | 멤버 식별자   |
| Product_Id | bigint       | Long          |     | O   |     | 제품 식별자   |
| Category   | varchar(255) | Enum          |     |     | O   | 제품 카테고리 |
| Content    | varchar(255) | String        |     |     |     | 리뷰 내용     |
| Image      | CLOB         | String        |     |     | O   | 리뷰 이미지   |

- `Member ----< Review`
- `Product ----< Review`

### 7. Refresh_Token

| Column   | DataType     | Java DataType | PK  | FK  | NN  | Description        |
| -------- | ------------ | ------------- | --- | --- | --- | ------------------ |
| RT_Key   | varchar(255) | String        | O   |     | O   | Refresh Key Member |
| RT_Value | varchar(255) | String        |     |     | O   | Refresh Key Token  |

### 8. Address - 보류

| Column       | DataType     | Java DataType | PK  | FK  | NN  | Description |
| ------------ | ------------ | ------------- | --- | --- | --- | ----------- |
| Id           | bigint       | Long          | O   |     |     | 주소 식별자 |
| Member_Id    | bigint       | Long          |     | O   | O   | 멤버 식별자 |
| Address_Info | varchar(255) | String        |     |     | O   | 상세 주소   |
| Recipient    | varchar(255) | String        |     |     | O   | 수취인      |
| Zip_Code     | varchar(255) | String        |     |     | O   | 우편 번호   |

- `Member ----< Address`