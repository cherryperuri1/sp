<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
 --%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Calculator</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<style>
input {
	width: 250px;
	border: 1px solid #666;
	border-radius: 5px;
	padding: 4px;
	font-size: 16px;
}

body {
	/*     background-color: #F2F4DB;
 */
	
}

.split {
	height: 100%;
	width: 50%;
	position: fixed;
	z-index: 1;
	top: 0;
	overflow-x: hidden;
	padding-top: 20px;
}

.left {
	left: 0;
	margin-top: 55px;
	background-color: #F2F4DB;
}

.right {
	right: 0;
	margin-top: 80px;

	/*    background-color: #F2F4DB;
 */
}

.centered {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
}

.centered img {
	width: 150px;
	border-radius: 50%;
}

header {
	height: 15%;
	max-height: 50px;
}
</style>
<header>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Moneymatters.com</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/home/emi">Calculate
						Installment</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/home/emi">Repayments
						Schedule</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/home/emi">Component
						for particular installment</a></li>
			</ul>
			<button class="btn btn-danger navbar-btn">Our Products</button>
		</div>
	</nav>
</header>

<body>
	<div class="split left">

		<div class="centered">
			<springForm:form action="calculate" modelAttribute="emiParam"
				method="POST">
				<table>
					<tbody>
						<tr>
							<td><label>Principal</label></td>
							<td><springForm:input path="principal" /></td>
							<td><springForm:errors path="principal" cssClass="error" /></td>

						</tr>
						<tr>
							<td><label>Rate Of Interest(in percentage)</label></td>
							<td><springForm:input path="rateOfInterest" /></td>
							<td><springForm:errors path="rateOfInterest"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>Period (in months)</label></td>
							<td><springForm:input path="periodInMonths" /></td>
							<td><springForm:errors path="periodInMonths"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td><label>No Of Installments(per year)</label></td>
							<td><springForm:input path="noOfInstallments" /></td>
							<td><springForm:errors path="noOfInstallments"
									cssClass="error" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Calculate Emi"
								class="btn btn-success" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
						<%-- <tr>
						<td><label>Emi</label></td>
						<td><form:input path="emi" required="" /></td>
					</tr> --%>

						<tr>
							<td><label>Equated Monthly Instalment is:</label></td>
							<td><font face="verdana" size="5" color="blue">&#8377;
									${emival}</font></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td>
								<button class="btn btn-info" formaction="schedule">View
									Repayment Schedule</button>
							</td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
						<tr>
							<td><label>Installment No:</label></td>
							<td><springForm:input path="breakup" required="" /></td>
							<td><springForm:errors path="breakup" cssClass="error" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><button class="btn btn-primary"
									formaction="breakschedule">Components for particular
									installment</button></td>

						</tr>

					</tbody>
				</table>


			</springForm:form>


		</div>
	</div>


	<div class="split right">

		<!--   <div class="centered">
 -->
		<table class="table table-striped">
			<tr>
				<th>Installment Number</th>
				<th>Outstanding Principal</th>
				<th>Interest Component</th>
				<th>Principal Component</th>
				<th>Emi</th>
			</tr>
			<c:forEach var="tempComponent" items="${components}">
				<tr>
					<td>${tempComponent.installmentNO}</td>
					<td>${tempComponent.outstandingPrincipal}</td>
					<td>${tempComponent.interestComponent}</td>
					<td>${tempComponent.principalComponent}</td>
					<td>${tempComponent.emi}</td>
				</tr>

			</c:forEach>

		</table>

	</div>
</body>
</html>