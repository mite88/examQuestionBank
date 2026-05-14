# examQuestionBank
시험문제은행 프로젝트(개인)


### 1. GitHub 프로젝트 협업 규칙 문서 (Wiki/README용)

#### 🌿 브랜치 전략 (Git-flow 간단 버전)

프로젝트의 규모와 하루 1시간이라는 제약을 고려하여 가장 효율적인 구조로 설정했습니다.

|**브랜치명**|**설명**|**비고**|
|---|---|---|
|**`main`**|최종 완성본 관리|서비스 배포용|
|**`develop`**|개발 중심 브랜치|모든 기능 개발의 통합|
|**`feature/기능명`**|세부 기능 개발|`develop`에서 생성, 완료 후 merge|
|**`release`**|배포 전 최종 점검|버그 수정 및 마무리|
|**`hotfix`**|긴급 오류 수정|`main`에서 직접 파생 및 수정|

#### 📝 커밋 메시지 규칙 (Commit Message Convention)

메시지만 보고도 어떤 작업을 했는지 알 수 있도록 `타입: 제목` 형식을 사용합니다.


|**타입**|**설명**|**예시**|
|---|---|---|
|**`Plan`** (추가)|**계획 및 일정 수립**|`Plan: 2주차 보안 설정 개발 일정 작성`|
|`Feat`|새로운 기능 추가|`Feat: 로그인 API 구현`|
|`Fix`|버그 수정|`Fix: 검색 결과 페이징 오류 수정`|
|`Docs`|문서 수정 (README 등)|`Docs: 설치 가이드 업데이트`|
|`Style`|코드 포맷팅 (로직 변경 X)|`Style: 인덴트 수정 및 세미콜론 추가`|
|`Refactor`|코드 리팩토링|`Refactor: Service 계층 로직 분리`|
|`Chore`|빌드/설정/패키지 관리|`Chore: .gitignore 파일 설정`|


---

### 2. 이슈(Issue) 및 코멘트(Comment) 가이드

GitHub의 **Issue** 기능을 활용해 그날의 1시간 목표를 관리하면 흐름을 놓치지 않는 데 도움이 됩니다.

#### 🚩 이슈 생성 예시

* **제목**: [Feat] Querydsl 검색 API 구현
* **내용**:
* [ ] BooleanExpression을 활용한 동적 쿼리 작성

* [ ] 과목별, 중요도별 필터링 기능 검증

* [ ] Postman 응답 확인


#### 💬 Pull Request(PR) 코멘트 작성 팁

`feature` 브랜치를 `develop`에 합칠 때 작성합니다.

* **작업 내용 요약**: "Querydsl의 `BooleanExpression`을 사용하여 여러 검색 조건을 하나의 메서드로 처리했습니다."


* **학습 포인트 (포트폴리오용)**: "정보처리기사 실기의 SQL 구조(WHERE, JOIN)를 코드로 구현하며 쿼리 최적화를 고민했습니다."


* **고민한 점**: "N+1 문제를 방지하기 위해 `fetchJoin`을 적용했습니다."

---

### 3. 프로젝트 초기 세팅 팁 (하루 1시간 절약법)

* **PR 템플릿 설정**: `.github/PULL_REQUEST_TEMPLATE.md` 파일을 만들어두면 매번 같은 형식을 쓰지 않아도 됩니다.

* **Project Board 활용**: GitHub Projects(Kanban)를 사용해 '할 일(To Do) - 진행 중(In Progress) - 완료(Done)'를 시각화하세요.
 프로젝트를 관리하시면, 7월 실기 시험 이후 이 리포지토리를 그대로 포트폴리오로 활용하실 수 있습니다! 가장 먼저 **`develop` 브랜치 생성**과 **`Chore: build.gradle 설정`** 커밋부터 시작해 보시겠어요?