# Domain layer

- `Entity`와 해당 `Entity`에 대한 crud 
- `Entity Service`는 자신의 정보 외에는 `아무것도 모른다`
- 단, Query 형태의 서비스는 예외로 한다. (ex: Search)
- `Entity`는 DBMS에 저장되는 `정보`로서 외부에 제공되지 않는다.
- 외부에 제공시 `VO(Value Object)` 형태로만 제공
- 변하는것과 변하지 않는것을 분리
- 요청의 접미어는 `Param` 사용
- 요청의 결과는 `Result` 사용