## LP - 프로젝트 소개
![리그오브레전드](https://github.com/user-attachments/assets/dcfe6b20-3cb8-4303-b1dc-7847fe30e7d1)
- 리그오브레전드의 패치 노트 업데이트 내용(챔피언, 아이템 등)을 시각화하고, 유저 전적을 ml 모델을 통해 분석하여 정기적인 뉴스레터를 발송하는 서비스입니다.
- 카프카를 기반으로 전체 시스템을 설계 및 구현하였습니다.

<br />

## 구현 내용
- 웹사이트 로그인/회원가입, 구독 신청, 유저의 주챔피언 좋아요, 전적 및 분석 내용 조회 기능 등을 구현하였습니다.
- 카프카를 통해 패치 노트 업데이트에 대한 메세지를 Consume하여 뉴스레터를 발송합니다.
- 배치 서버에서 실시간으로 유저 전적 정보를 업데이트하고, 각 전적을 카프카에 Produce하여 ml 서버에게 전달합니다.

<br />

## 멀티모듈 아키텍처 구조
![Multimodule Architecture](https://github.com/user-attachments/assets/390fa9ec-9a00-4631-a7a1-22aa311c1116)

<br />

## 전체 아키텍처 구조
![Total Architecture](https://github.com/user-attachments/assets/424193d6-7dd6-4ac7-9cc4-eb498007f8f7)
