# ✈️ LetsGo (Travel Schedule Planner)

LetsGo는 사용자가 여행 일정을 계획하고, 장소를 검색하며, 다른 사람들과 일정을 공유하고 소통할 수 있는 **웹 기반 여행 일정 관리 플랫폼**입니다.

## 📌 주요 기능 (Key Features)

### 1. 사용자 관리 (User Management)
- 회원가입 (`signup.html`) 및 로그인 (`login.html`)
- 아이디/비밀번호 찾기 및 변경 (`getid.html`, `updatepw.html`)

### 2. 여행지 탐색 및 담기 (Place Search & Bookmark)
- 카테고리별 장소 탐색: 숙소(`stay.html`), 레저(`leisere.html`), 식당(`restaurant.html`)
- 마음에 드는 장소를 장바구니/내 리스트에 담기 (`ShoppingCart.html`, `mylist.html`)

### 3. 나만의 여행 일정 계획 (Trip Planning)
- 새로운 여행 일정 생성 (`createTrip.html`, `tripList.html`)
- 여행 중 필요한 체크리스트(To-Do) 관리 (`todoList.html`)
- 여행 경비 및 예산 관리 (`priceManage.html`)
- 내 일정 모아보기 (`myscheduleAll.html`)

### 4. 일정 공유 및 권한 관리 (Schedule Sharing)
- 친구나 동행자와 일정 공유 및 공동 편집 권한 설정 (`share.html`)
- 공유받은 일정 확인 (`myscheduleShared.html`)

### 5. 커뮤니티 (Community & Posting)
- 내 일정을 사람들과 공유하는 게시글 작성 (`schedulepostAll.html`, `schedulepostMy.html`)
- 다른 사람의 일정 상세 보기 및 좋아요 (`schedulepostDetail.html`, `schedulepostLike.html`)

---

## 🛠️ 기술 스택 (Tech Stacks)

### Backend
<img src="https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white"> <img src="https://img.shields.io/badge/Apache Tomcat-F8DC75?style=for-the-badge&logo=Apache Tomcat&logoColor=white">

### Frontend
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white"> <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white">

### Database
<img src="https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=MariaDB&logoColor=white"> 
*(DDL 및 Dummy.sql 제공됨)*

### Version Control & Design
<img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white"> <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white">

---

## 🗄️ 데이터베이스 구조 (ERD / DDL)

이 프로젝트는 다음과 같은 핵심 엔티티를 관리합니다. (세부 사항은 `MariaDB_DDL.sql` 참조)
- **`users`**: 서비스 사용자 정보
- **`place`**: 여행지/장소 기본 정보 및 좌표 (`mapx`, `mapy`)
- **`my_schedule`**: 사용자가 생성한 여행 일정 (시작일, 공유 여부, 예산 등)
- **`visit_item`**: 특정 일정(`my_schedule` 또는 `schedule_post`)에 속한 방문 장소의 순서 및 거리 정보
- **`schedule_share_user`**: 일정 공동 관리를 위한 사용자 권한 (읽기/쓰기 등)
- **`schedule_post`**: 커뮤니티에 공개된 일정 게시글 (조회수, 좋아요 등)

> **ERD 모델**: 프로젝트 루트의 `1팀_ERD.exerd` 및 `ERD.png` 파일 참고.
