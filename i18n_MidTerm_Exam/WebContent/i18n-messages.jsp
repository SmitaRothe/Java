<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="theLocale" 
       value="${not empty param.theLocale?param.theLocale:pageContext.request.locale}"
       scope="session"/>
       
<fmt:setLocale value="${theLocale}"/>

<fmt:setBundle basename="com.example.jsp.i18n_MidTerm_Project.resources.mylabels"/>

<html>
<head>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
	<div id="wrapper">
	  <div id="container">
			<a href="i18n-messages.jsp?theLocale=en_US">English (US)</a>
			|
			<a id="french" href="i18n-messages.jsp?theLocale=fr_CA">French (CA)</a>
			
			<hr>
			<p>
				<fmt:message key="label.movieTitle"/> The Shawshank Redemption <br/>
				<fmt:message key="label.year"/> 1994 <br/>
				<fmt:message key="label.director"/> Frank Darabont<br/>
				<fmt:message key="label.Country"/> USA <br/><br/>
			</p>
			<hr>
			
			Selected Locale: <b id="locale">${theLocale}</b>
	  </div>
	</div>
</body>

</html>