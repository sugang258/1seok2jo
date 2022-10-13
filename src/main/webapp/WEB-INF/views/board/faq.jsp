<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>자주묻는질문</title>
    <link rel="stylesheet" href="/resources/css/board/faq.css" />
    <link rel="stylesheet" href="/resources/css/index.css" />
    <%-- Bootstrap CSS --%>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Arvo&family=Dongle&family=Montserrat:wght@200&family=PT+Serif&family=Playfair+Display:wght@600&family=Prompt&family=Vollkorn:wght@500&display=swap"
      rel="stylesheet"
    />
    <%-- favicon --%>
    <link rel="shortcut icon" href="/resources/images/favicon.ico" />
  </head>
  <c:import url="../template/header.jsp"></c:import>
  <body>
    <section class="container" >
        <div class="d-flex">
            <!--Sidebar-->
            <div class="row" style="width:8%;">
                <div class="col-4 d-md-block d-none">
                    <div class="list-group sidebar">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a
                        class="list-group-item list-group-item-action"
                        id="list-home-list"
                        data-bs-toggle="list"
                        href="#list-home"
                        role="tab"
                        aria-controls="list-home"
                        style="font-size: 18px; color: pink"
                        onclick="location.href='/'"
                        ><i class="fa-solid fa-house"></i
                        ></a>
                        <a
                        class="list-group-item list-group-item-action"
                        id="list-profile-list"
                        data-bs-toggle="list"
                        href="#list-profile"
                        role="tab"
                        aria-controls="list-profile"
                        onclick="location.href='./notice'"
                        >공지사항</a
                        >
                        <a
                        class="list-group-item list-group-item-action"
                        id="list-messages-list"
                        data-bs-toggle="list"
                        href="#list-messages"
                        role="tab"
                        aria-controls="list-messages"
                        onclick="location.href='/csBoard/mylist'"
                        >1대 1문의</a
                        >
                        <a
                        class="list-group-item list-group-item-action active"
                        id="list-settings-list"
                        data-bs-toggle="list"
                        href="#list-messages"
                        role="tab"
                        aria-controls="list-settings"
                        onclick="location.href='./faq'"
                        >자주묻는 질문</a
                        >
                    </div>
                    </div>
                </div>
            </div>

            <!--Board_Contents-->
            <div style="width: 92%;">
            <div class="banner">
                <div class="banner_box">
                <div class="d-flex align-items-start flex-column mb-3" style="height: 200px;">
                    <p class="FaqContainer__banner--title p-2">어떤 부분이 궁금하세요?</p>
                    <p class="FaqContainer__banner--content p-2">수강생들이 자주 궁금해하는 부분들을 모은 공간이에요. <br><span><span>자주 묻는 질문</span>을 통해 빠르게 궁금증을 해결할 수 있어요!</span></p>
                </div>
                </div>
            </div>
    
    
            <div class="cate-div d-flex justify-content-center" id="cate-box">
                <div class="cate lec" id="lec">강의상세</div>
                <div style="width: 1%; line-height: 85px;">▫</div>
                <div class="cate man" id="man">계정관리</div>
                <div style="width: 1%; line-height: 85px;">▫</div>
                <div class="cate rec" id="rec">기기 및 재생환경</div>
                <div style="width: 1%; line-height: 85px;">▫</div>
                <div class="cate sign" id="sign">결제</div>
            </div>
            <hr style="margin-top: -25px;">
    
            <div class="show1">
                <div class="d-flex flex-column" style="width: 90%; margin: 0 auto;">
                <div style="margin-left: 2.4rem; margin-bottom: 1rem; font-size: 0.9rem; color: #3b393d;"><b>강의 상세관련 FAQ가 총 <span style="color: rgb(125, 20, 230);">4</span>건 있습니다.</b></div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        강의를 듣다가 궁금증이 생기면 어떻게 해야 하나요?
                    </div>
                    <div class="pt-1 pb-1"><button class="t_btn" style="border: none; background-color: transparent; width: 2em;"><i class="minus fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line_box"  style="display: none;">
                    <ul class="pt-2 toggle_box" style="padding-right: 20px; display: none; background-color: white;">레슨 하단 질문하기를 통해 커뮤니티에 궁금증을 남기고, 다른 수강생들과 함께 해결해보세요. 커뮤니티 정책을 참고하여 커뮤니티를 200% 활용해 보세요.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        커리어/스킬, 토픽, 챕터, 레슨이 무엇인가요?
                    </div>
                    <div class="pt-1 pb-1"><button class="t_btn"  style="border: none; background-color: transparent; width: 2em;"><i class="minus fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line_box" style="display: none;">
                    <ul class="pt-2 toggle_box" style="padding-right: 20px; display: none; background-color: white;">강의 구조는 다음과 같이 이루어져 있어요.
                    레슨(강의/노트/퀴즈/과제) < 챕터 < 토픽 < 커리어/스킬 레슨은 동영상 강의, 노트, 퀴즈, 과제를 나타내는 가장 작은 단위의 수업이에요. 이를 묶어 놓은 것이 챕터, 그리고 챕터를 묶어 수강할 수 있도록 만든 것이 토픽입니다. 커리어/스킬은 이 모든 과정을 가장 효과적으로 학습할 수 있도록 단계별로 배치한 것입니다.</ul>
                </div>
                
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        강의 영상을 다운로드할 수 있나요?
                    </div>
                    <div class="pt-1 pb-1"><button class="t_btn" style="border: none; background-color: transparent; width: 2em;"><i class="minus fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line_box" style="display: none;">
                    <ul class="pt-2 toggle_box" style="padding-right: 20px; display: none; background-color: white;">아니요. 강의 내용은 다운로드가 불가능합니다. 다만 노트북, 태플릿, 스마트 폰 등 다양한 기기에서 언제든지 강의를 수강하실 수 있습니다.</ul>
                </div>
    
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        동영상 강의는 몇 분 정도인가요?
                    </div>
                    <div class="pt-1 pb-1"><button class="t_btn" style="border: none; background-color: transparent; width: 2em;"><i class="minus fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line_box" id="line_box4" style="display: none;">
                    <ul class=" toggle_box pt-2" style="padding-right: 20px; display: none; background-color: white;">강의는 10분 내외의 짧은 영상으로 이루져있어요. 예상 소요시간은 각 토픽 페이지에서 확인하실 수 있습니다.</ul>
                </div>
                </div>
            </div>
    
            <div class="show2">       
                <div class="d-flex flex-column" style="width: 90%; margin: 0 auto;">
                <div style="margin-left: 2.4rem; margin-bottom: 1rem; font-size: 0.9rem; color: #3b393d;"><b>강의 상세관련 FAQ가 총 <span style="color: rgb(125, 20, 230);">7</span>건 있습니다.</b></div>
                    <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                        <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                        <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        회원 탈퇴는 어떻게 하나요?
                        </div>
                        <div class="t_btn2 pt-1 pb-1"><button id="t2_btn1" style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;"><회원 탈퇴>
                        회원 탈퇴를 원하시면 아래 주의 사항을 꼭 확인하시고, 우측 하단 문의하기를 이용해주세요.
                        계정관리 > 회원 탈퇴 > 탈퇴 신청을 클릭하신 후 탈퇴 요청 계정과 탈퇴 사유를 남겨주세요.
                        
                        <탈퇴 시 주의사항>
                        탈퇴 시 수강 기록 및 결제 내역 등을 포함한 모든 활동 기록과 정보가 삭제되어 조회 및 복구가 불가능합니다.</ul>
                </div>
                
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        비밀번호를 변경하고 싶어요.
                    </div>
                    <div class="t_btn2 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;">
                    우측 상단의 프로필 이미지 > 계정 관리 > 내 프로필 > 비밀번호 변경을 통해 변경이 가능해요.</ul>
                </div>
                
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        비밀번호를 잊어버렸어요.
                    </div>
                    <div class="t_btn2 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;">로그인 페이지에서 비밀번호 찾기를 통해 가입 시 등록한 이메일로 비밀번호 재설정 링크를 받아보실 수 있어요. 이메일 확인이 어려우시면 우측 하단의 문의하기 > 계정관리 > 비밀번호 찾기 > 직접 문의로 남겨주세요.</ul>
                </div>
    
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        개인 정보 처리 방침은 어떻게 되나요?
                    </div>
                    <div class="t_btn2 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;">개인 정보 처리 방침은 사이트 하단 개인정보 취급방침에서 확인 가능해요.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        로그인 시 문제가 생겨요.
                    </div>
                    <div class="t_btn2 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;">연락처 이메일이 등록되어 있지 않은 경우에는 네이버 아이디 계정을 입력하여 로그인을 하시면 됩니다.
                    해결이 되지 않으시면 우측 하단 문의하기 > 계정 관리 > 계정 찾기 > 직접 문의를 통해 메시지를 남겨주세요.</ul>
                </div>
    
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        가입한 아이디로 로그인이 되지 않아요.
                    </div>
                    <div class="t_btn2 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;">네이버, 카카오, 페이스북, 구글을 통한 간편 가입을 하셨는지 확인해보시고, SNS 간편 로그인으로 로그인 해보세요. 그래도 문제가 발생한다면 우측 하단 문의하기 > 계정 관리 > 계정 찾기로 문의해 주세요.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        여러 사람이 한 계정을 사용해도 되나요?
                    </div>
                    <div class="t_btn2 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus2 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus2 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line2_box" style="display: none;">
                    <ul class="toggle2_box pt-2" style="padding-right: 20px; display: none; background-color: white;">1인 1계정이 원칙입니다. 이를 위반할 시 불이익이 있을 수 있으니 양해 부탁드려요.</ul>
                </div>
                </div>
            </div>
    
            <div class="show3">
                <div class="d-flex flex-column" style="width: 90%; margin: 0 auto;">
                <div style="margin-left: 2.4rem; margin-bottom: 1rem; font-size: 0.9rem; color: #3b393d;"><b>강의 상세관련 FAQ가 총 <span style="color: rgb(125, 20, 230);">2</span>건 있습니다.</b></div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        여러 기기에서 이용이 가능한가요?
                    </div>
                    <div class="pt-1 pb-1"><button class="t_btn3" style="border: none; background-color: transparent; width: 2em;"><i class="minus3 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus3 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line3_box"  style="display: none;">
                    <ul class="pt-2 toggle3_box" style="padding-right: 20px; display: none; background-color: white;">노트북, 태블릿, 스마트폰에서 모두 이용 가능해요. 다만, iPhone 및 iPad 이용 시에는 실습창에서 한글 입력 오류가 발생할 수 있어요. iPhone 및 iPad는 iOS, iPadOS 버전 13 부터 문제 없이 사용하실 수 있습니다.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        서비스 이용 가능한 브라우저는 무엇인가요?
                    </div>
                    <div class="pt-1 pb-1"><button class="t_btn3"  style="border: none; background-color: transparent; width: 2em;"><i class="minus3 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus3 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line3_box" style="display: none;">
                    <ul class="pt-2 toggle3_box" style="padding-right: 20px; display: none; background-color: white;">크롬(Chrome) 브라우저 이용을 권장합니다. Internet Explorer 는 지원하지 않습니다. 다른 브라우저를 이용해주세요.
                    크롬 브라우저에 최적화 되어 있습니다. 크롬 브라우저 사용시 문제가 있다면 파이어폭스(Firefox), Edge(Windows), Safari(MacOS)를 이용해주세요.
                    - 크롬 브라우저 다운로드 https://www.google.com/chrome/
                    - 파이어폭스 다운로드 https://www.mozilla.org/ko/firefox/new/</ul>
                </div>
                </div>
            </div>
            
            <div class="show4">
                <div class="d-flex flex-column" style="width: 90%; margin: 0 auto;">
                <div style="margin-left: 2.4rem; margin-bottom: 1rem; font-size: 0.9rem; color: #3b393d;"><b>강의 상세관련 FAQ가 총 <span style="color: rgb(125, 20, 230);">10</span>건 있습니다.</b></div>
                    <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                        <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                        <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        무료 체험이 가능한가요?
                        </div>
                        <div class="t_btn4 pt-1 pb-1"><button id="t2_btn1" style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">네, 가능합니다. 처음 이용하시는 분들은 메인 페이지(바로가기) 에서 7일 무료 수강 버튼을 클릭하신 후 등록 절차를 마치시면 7일 동안 무료로 모든 레슨을 들으실 수 있어요</ul>
                </div>
                
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        결제 정보는 어디에서 확인하나요?
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">
                    우측 상단 프로필 이미지 > 내 프로필 > 내 멤버십 에서 결제 수단 및 결제 내역에서 확인이 가능해요. (바로가기)</ul>
                </div>
                
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        멤버십을 변경하고 싶어요.
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">우측 상단 프로필 이미지 > 내 프로필 > 내 멤버십 > 멤버십 정보 > 멤버십 변경을 통해 변경이 가능해요.
    
                    변경 사항은 현재 이용 중인 멤버십 기간이 종료된 시점부터 적용됩니다.</ul>
                </div>
    
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        쿠폰 사용 방법이 궁금해요.
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">7일 무료 수강 등록 후에 쿠폰을 사용하실 수 있습니다. 먼저 메인 페이지(바로가기) 에서 7일 무료 수강 버튼을 클릭하여 등록 절차를 마쳐주세요. 그리고
                         사이트 내 우측 상단 프로필 이미지 > 내 프로필 > 내 멤버십 > 쿠폰 등록을 통해 등록 후 사용해 주세요.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        잔액 부족, 한도 초과 등으로 결제에 실패했어요.
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">결제가 실패될 경우 결제 카드 변경 혹은 문제 해결 후 [즉시 재결제]를 통해, 현재 이용 중인 멤버십을 계속 이용하실 수 있어요.
    
                    <결제 카드 변경>
                    우측 상단 프로필 사진 > 계정 관리 > 내 멤버십 > 결제 수단 > 결제 카드 변경 > 즉시 재결제 (바로가기)
                    [즉시 재결제]가 아닌 경우 자동으로 추가 결제 시도가 이루어집니다.
                    - 1차 재결제일 : 당초 결제 실패일 + 15일
                    - 2차 재결제일 : 당초 결제 실패일 + 31일
                    *2차 재결제 실패 시 정기 결제가 해지됩니다.</ul>
                </div>
    
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        결제 수단을 변경하고 싶어요.
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">우측 상단 프로필 이미지 > 내 프로필 > 내 멤버십 > 결제 수단 > 결제 카드 변경을 통해 카드 변경이 가능해요.(바로가기)
                    변경사항은 현재 이용 중인 멤버십 기간이 종료된 시점부터 적용됩니다.</ul>
                </div>
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                    <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                        내일배움카드 결제가 가능한가요?
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                    </div>
                    <hr class="line4_box" style="display: none;">
                    <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">아니요. 현재 내일배움카드 결제는 지원되지 않습니다.</ul>
                </div>
                
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                    법인카드로 결제가 가능한가요?
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                </div>
                <hr class="line4_box" style="display: none;">
                <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">법인카드를 통한 멤버십 결제가 가능합니다. 단, 현재 원격 평생교육원으로 등록이 되어 있어 상품에 소득세가 적용되지 않기 때문에, 회사에서는 10% 공제 혜택을 따로 받을 수 없다는 점 유의 부탁드립니다.
                    결제가 이루어지지 않는 경우, 홈페이지 우측 하단에 문의하기 > 오류 신고로 문의를 남겨주세요.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                    쿠폰 사용이 되지 않아요.
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                </div>
                <hr class="line4_box" style="display: none;">
                <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">쿠폰코드로 입력하시는 경우에는 정확한 입력을 위해 복사 후 붙여넣기를 통해 등록해주세요. 계속되는 오류시 홈페이지 우측 하단 문의하기 > 오류 신고로 문의를 남겨주세요.</ul>
                </div>
    
                <div class="p-3 mb-3" style="border-radius: 10px; box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;">
                <div class="d-flex">
                    <div class="pt-1 pb-1" style="color: rgb(125, 20, 230); padding-right: 10px; font-weight: bold; font-size: 20px; line-height: 20px;">Q</div>
                    <div class="flex-fill pt-1 pb-1" style="background-color: white;">
                    해외 카드도 사용할 수 있나요?
                    </div>
                    <div class="t_btn4 pt-1 pb-1"><button style="border: none; background-color: transparent; width: 2em;"><i class="minus4 fa-solid fa-minus" style="display: none; color: rgb(81, 0, 157);"></i><i class="plus4 fa-solid fa-plus" style="color: rgb(81, 0, 157);"></i></button></div>
                </div>
                <hr class="line4_box" style="display: none;">
                <ul class="toggle4_box pt-2" style="padding-right: 20px; display: none; background-color: white;">해외 카드 결제는 지원하지 않아요. 빠른 시일내에 지원할 수 있도록 하겠습니다.</ul>
                </div>
            </div>

        </div>
    </div>
    </section>

    <c:import url="../template/footer.jsp"></c:import>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/6e23c67242.js"
      crossorigin="anonymous"
    ></script>
    <script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
	<script>
	$(document).ready(function() {
	  $(".show1").show();
	  $('.show2').hide();
	  $('.show3').hide();
	  $('.show4').hide();
	
	$('.lec').on('click', function() {
	    $('.show1').show();
	    $('.show2').hide();
	    $('.show3').hide();
	    $('.show4').hide();
	});
	
	$('.man').on('click', function() {
	  $('.show2').show();
	  $('.show1').hide();
	  $('.show3').hide();
	  $('.show4').hide();
	});
	
	$('.rec').on('click', function() {
	  $('.show3').show();
	  $('.show1').hide();
	  $('.show2').hide();
	  $('.show4').hide();
	});
	
	$('.sign').on('click', function() {
	$('.show4').show();
	$('.show1').hide();
	$('.show2').hide();
	$('.show3').hide();
	});
	});
	</script>
	<script src="/resources/js/faq.js"></script>
  </body>
</html>