# App layer

- controller 에서 호출 된다.
- 파라메터명은 접미어로 `Cmd`를 사용한다.
- 1개 이상의 `domain service`를 호출하여 `비지니스 로직`을 처리한다.
- `Transaction`의 시작점