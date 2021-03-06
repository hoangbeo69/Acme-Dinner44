<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<!-- Messages -->
<spring:message code="soiree.date" var="soireeDate" />
<spring:message code="soiree.address" var="soireeAddress" />
<spring:message code="soiree.organizer" var="soireeOrganizer" />
<spring:message code="soiree.pictures" var="soireePictures" />
<spring:message code="soiree.dishes" var="soireeDishes" />

<div class=row style="text-align:center">
	<div class="col-md-6" >
	
		<div class='title'>${soireeDate}:</div>
		&nbsp;&nbsp;
		<fmt:formatDate value="${soiree.date}" pattern="dd/MM/yyyy HH:mm"/>
		<br />
		<br />
		
		<div class='title'>${soireeAddress}:</div>
		&nbsp;&nbsp;
		<jstl:out value="${soiree.address}" />
		<br />
		<br />
		
		<div class='title'>${soireeOrganizer}:</div>
		&nbsp;&nbsp;
		<jstl:out value="${soiree.organizer.actorName}" />
		<br />
		<br />
		
		<div class='title'>${soireePictures}:</div>		
		
		<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
			    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>
			
			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<jstl:forEach var="e" items="${soiree.pictures}">
					<div class="item">
						<img src="${e}" alt="First slide">
				    </div>
				</jstl:forEach>      
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			</a>
			<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			</a>
		</div>
		
	</div>
	
	<div class="col-md-6">
		<h1 class='title'>${soireeDishes}</h1>
		<!-- Table -->
		<display:table  name="dishes" id="row" requestURI="${requestURI}" class="table">
			<display:column property="name" title="${dishName}" sortable="false" />
			<display:column property="description" title="${dishDescription}" sortable="false" />	
			<display:column property="dishType.value" title="${dishType}" sortable="true"/>
			<display:column property="ingredients" title="${dishIngredients}" sortable="false" />
		</display:table>
	</div>
	
</div>