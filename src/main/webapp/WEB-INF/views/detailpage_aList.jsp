<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>Jimat - food choice for you</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />
<script src="https://kit.fontawesome.com/edd4d6d779.js"
	crossorigin="anonymous"></script>
<link href="css/main.css" type="text/css" rel="stylesheet" />
<link href=css/shopDetail.css " type="text/css" rel="stylesheet" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=952441bca7c2877c20d98599bb8b06bd&amp;libraries=LIBRARY"></script>
<script charset="UTF-8"
	src="https://t1.daumcdn.net/mapjsapi/js/main/4.4.8/kakao.js"></script>
</head>
<body>
	<div class="body-wrap container col-12 column-row">
		<div class="row">
			<%-- 메인 메뉴 불러오기 --%>
			<jsp:include page="mainMenu.jsp"></jsp:include>
		</div>
		<c:forEach items="${aList}" var="aList">
			<div class="shop-main-image">
				<img src='${aList.img_url}' id="shop-main-image" />
			</div>
			<p id="shop-name">${aList.foodstore_id}</p>
			<p id="shop-category">${aList.foodtype}</p>
			<p id="shop-rating">${aList.rate}</p>
			<p id="shop-address">${aList.road_name}</p>
			<p id="shop-phone">${aList.foodstroe_num}</p>
			<p id="shop-close">${aList.openinghours}</p>
		</c:forEach>
	</div>
</body>
</html>
